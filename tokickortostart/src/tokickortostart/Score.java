package tokickortostart;

import java.util.ArrayList;

/**
 * This module is used to determine the "best" project from an array of Project based on both likeness and fitness.
 */
public class Score {
	/**
	 * This method returns the best project found in the given array.
	 * 
	 * @param arr An array of project types
	 * @return Returns the best Project found in the array
	 */
	public static Project BestProject(Project[] arr) {
		/**
		 * Three ArrayList<Project> containing projects from the input array with likeness above 90, between 80-90, and between 70-80, respectively.
		 */
		ArrayList<Project> layer1 = new ArrayList<Project>(); //90+
		ArrayList<Project> layer2 = new ArrayList<Project>(); //80-89.9
		ArrayList<Project> layer3 = new ArrayList<Project>(); //70-79.9
		int sum = 1;
		
		/**
		 * Iterates through each Project in the input array and adds it to one of the ArrayList<Project>. Also assigns the Project an ID based on a counter sum.
		 */
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
				/**
				 * Can break here since the input array will be sorted from highest likeness to lowest, so once one has a likeness < 70 the rest will too.
				 */
				break;
			}
		}
		
		/**
		 * Initializes the graph with sum vertices.
		 */
		Graph graph = new Graph(sum);
		
		/**
		 * Sets the edges from node 0 (input project) to the projects in layer1
		 */
		for (int i = 0; i < layer1.size(); i++) {
			Project curr = layer1.get(i);
			double weight = curr.getFitness() - 20;
			graph.addEdge(0, curr.getID(), weight);
		}
		
		/**
		 * Sets the edges from layer1 to layer2
		 */
		for (int i = 0; i < layer2.size(); i++) {
			Project curr1 = layer2.get(i);
			for (int j = 0; j < layer1.size(); j++) {
				Project curr2 = layer1.get(j);
				double weight = curr1.getFitness() - curr2.getFitness() - 20;
				graph.addEdge(curr2.getID(), curr1.getID(), weight);
			}
		}
		
		/**
		 * Sets the edges from layer2 to layer3
		 */
		for (int i = 0; i < layer3.size(); i++) {
			Project curr1 = layer3.get(i);
			for (int j = 0; j < layer2.size(); j++) {
				Project curr2 = layer2.get(j);
				double weight = curr1.getFitness() - curr2.getFitness() - 20;
				graph.addEdge(curr2.getID(), curr1.getID(), weight);
			}
		}

		/**
		 * Calls the private function Best to get the ID of the "best" project
		 */
		int best = Best(graph);
		
		/**
		 * Gets the Project associated with the ID returned from Best, and returns it
		 */
		for (int i = 0; i < arr.length; i++)
			if (arr[i].getID() == best)
				return arr[i];
		
		/**
		 * The default is to return the Project with the highest likeness
		 */
		return arr[0];
	}

	
	/**
	 * This method runs a custom modified DFS on the given graph to determine the node with the longest path from node 0.
	 * 
	 * @param graph The graph to run the search on.
	 * @return Returns the ID of the node with the longest path.
	 */
	private static int Best(Graph graph) {
		ArrayList<Edge> adj0 = graph.adj(0);
		int bestProj = 0;
		double maxWeight = 0;

		/**
		 * Iterate through the nodes adjacent to node 0 (through nodes in layer 1)
		 */
		for (int i = 0; i < adj0.size(); i++) {
			Edge curr1 = adj0.get(i);
			
			double currWeight1 = curr1.getWeight();
			
			ArrayList<Edge> adj1 = graph.adj(curr1.getEnd());

			/**
			 * Iterate through the nodes adjacent to the current node of layer 1 (through nodes in layer 2)
			 */
			for (int j = 0; j < adj1.size(); j++) {
				Edge curr2 = adj1.get(j);
				
				double currWeight2 = curr2.getWeight() + currWeight1;
				
				ArrayList<Edge> adj2 = graph.adj(curr2.getEnd());

				/**
				 * Iterate through the nodes adjacent to the current node of layer 2 (through nodes in layer 3)
				 */
				for (int k = 0; k < adj2.size(); k++) {
					Edge curr3 = adj2.get(k);
					
					double currWeight3 = currWeight2 + curr3.getWeight();
					
					/**
					 * Checks to see if this path is more expensive than the current most expensive
					 */
					if (currWeight3 > maxWeight) {
						maxWeight = currWeight3;
						bestProj = curr3.getEnd();
					}
				}

				/**
				 * Checks to see if this path without the last node is more expensive than the current most expensive
				 */
				if (currWeight2 > maxWeight) {
					maxWeight = currWeight2;
					bestProj = curr2.getEnd();
				}
				
			}

			/**
			 * Checks to see if this path without the two last nodes is more expensive than the current most expensive
			 */
			if (currWeight1 > maxWeight) {
				maxWeight = currWeight1;
				bestProj = curr1.getEnd();
			}
		}

		/**
		 * Returns the project with the most expensive path
		 */
		return bestProj;
	}
}
