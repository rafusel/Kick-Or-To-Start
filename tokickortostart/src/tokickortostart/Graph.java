package tokickortostart;

import java.util.ArrayList;

/**
 * ADT for the representation of weighted digraphs
 * 
 */
public class Graph {
	/**
	 * Number of vertices in the graph
	 */
	private final int V;
	
	/**
	 * Array of ArrayList<Edge> representing the edges going out of every vertex
	 */
	private ArrayList<Edge>[] adj; 

	/**
	 * Constructor for a digraph of the specified size
	 * @param size Number of vertices in the graph to create
	 */
	public Graph(int size) {
		this.V = size;
		adj = new ArrayList[size];
		for (int v = 0; v < size; v++) {
			adj[v] = new ArrayList<Edge>();
		}
	}

	/**
	 * Adding an edge to the digraph
	 * @param v The starting vertex of the edge
	 * @param w The ending vertex of the edge
	 * @param weight The weight of the edge
	 */
	public void addEdge(int v, int w, double weight) {
		Edge one = new Edge(v, w, weight);
		adj[v].add(one);
	}
	
	/**
	 * Accessor for the number of vertices in the graph
	 * @return Number of vertices in the graph
	 */
	public int getV() { 
		return this.V;
	}

	/**
	 * Accessor for the ArrayList which holds the edges for each vertex
	 * @param v The integer representing the vertex
	 * @return An ArrayList of edge types
	 */
	public ArrayList<Edge> adj(int v) { //Gets the ArrayList<Edge> representing the edges coming out from a vertex
		return adj[v];
	}

}