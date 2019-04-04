package tokickortostart;

import java.util.ArrayList;

public class Score {
	public static Project BestProject(Project[] arr) {
		ArrayList<Project> layer1 = new ArrayList<Project>(); //90+
		ArrayList<Project> layer2 = new ArrayList<Project>(); //80-89.9
		ArrayList<Project> layer3 = new ArrayList<Project>(); //70-79.9
		int sum = 1;
		for (int id = 0; id < arr.length; id++) {
			Project curr = arr[id];
			if (curr.getLikeness() >= 90) {
				layer1.add(curr);
				curr.setID(sum);
				sum += 1;
			} else if (curr.getLikeness() >= 80) {
				layer2.add(curr);
				curr.setID(sum);
				sum += 1;
			} else if (curr.getLikeness() >= 70) {
				layer3.add(curr);
				curr.setID(sum);
				sum += 1;
			} else {
				break;
			}
		}

		Graph graph = new Graph(sum /*+ 1*/);
		
		for (int i = 0; i < layer1.size(); i++) {
			Project curr = layer1.get(i);
			double weight = curr.getFitness() - 20;
			graph.addEdge(0, curr.getID(), weight);
		}
		
		for (int i = 0; i < layer2.size(); i++) {
			Project curr1 = layer2.get(i);
			for (int j = 0; j < layer1.size(); j++) {
				Project curr2 = layer1.get(j);
				double weight = curr1.getFitness() - curr2.getFitness() - 20;
				graph.addEdge(curr2.getID(), curr1.getID(), weight);
			}
		}
		
		for (int i = 0; i < layer3.size(); i++) {
			Project curr1 = layer3.get(i);
			for (int j = 0; j < layer2.size(); j++) {
				Project curr2 = layer2.get(j);
				double weight = curr1.getFitness() - curr2.getFitness() - 20;
				graph.addEdge(curr2.getID(), curr1.getID(), weight);
			}
		}
		
		int best = Best(graph);
		
		for (int i = 0; i < arr.length; i++)
			if (arr[i].getID() == best)
				return arr[i];
		
		return arr[0];
	}
	
	public static int Best(Graph graph) { //Modified DFS
		ArrayList<Edge> adj0 = graph.adj(0);
		int bestProj = 0;
		double maxWeight = 0;
		
		for (int i = 0; i < adj0.size(); i++) {
			Edge curr1 = adj0.get(i);
			
			double currWeight1 = curr1.getWeight();
			
			ArrayList<Edge> adj1 = graph.adj(curr1.getEnd());
			
			for (int j = 0; j < adj1.size(); j++) {
				Edge curr2 = adj1.get(j);
				
				double currWeight2 = curr2.getWeight() + currWeight1;
				
				ArrayList<Edge> adj2 = graph.adj(curr2.getEnd());
				
				for (int k = 0; k < adj2.size(); k++) {
					Edge curr3 = adj2.get(k);
					
					double currWeight3 = currWeight2 + curr3.getWeight();
					
					if (currWeight3 > maxWeight) {
						maxWeight = currWeight3;
						bestProj = curr3.getEnd();
					}
				}
				
				if (currWeight2 > maxWeight) {
					maxWeight = currWeight2;
					bestProj = curr2.getEnd();
				}
				
			}
			
			if (currWeight1 > maxWeight) {
				maxWeight = currWeight1;
				bestProj = curr1.getEnd();
			}
		}
		
		return bestProj;
	}
}
