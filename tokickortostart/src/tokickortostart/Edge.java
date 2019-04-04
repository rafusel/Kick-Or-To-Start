package tokickortostart;

//Class used to implement a more simple edge

public class Edge {
	private final int start; //Start vertex of the edge
	private final int end; //End vertex of the edge
	private final double weight; //Weight of the edge

	public Edge(int start, int end, double weight) {
		//Initialize state variables based of inputs
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	
	public int getStart() { //Gets the start vertex of the edge
		return this.start;
	}
	
	public int getEnd() { //Gets the end vertex of the edge
		return this.end;
	}
	
	public double getWeight() { //Gets the weight of the edge
		return this.weight;
	}
}