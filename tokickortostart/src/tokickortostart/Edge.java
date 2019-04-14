package tokickortostart;
/**
 *  Class used to implement a simple edge
 *
 */
public class Edge {
	
	/**
	 * Start vertex of the edge
	 */
	private final int start; 
	/**
	 * End vertex of the edge
	 */
	private final int end;
	/**
	 * Weight of the edge
	 */
	private final double weight; 

	/**
	 * Edge constructor
	 * 
	 * @param start The start vertex of the edge
	 * @param end The end vertex of the edge
	 * @param weight The weight of the edge
	 */
	public Edge(int start, int end, double weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	
	/**
	 * Gets the start vertex of the edge
	 * @return the start vertex of the edge
	 */
	public int getStart() { 
		return this.start;
	}
	
	/**
	 * Gets the end vertex of the edge
	 * @return the end vertex of the edge
	 */
	public int getEnd() { 
		return this.end;
	}
	
	/**
	 * Gets the weight of the edge
	 * @return the weight of the edge
	 */
	public double getWeight() {
		return this.weight;
	}
}