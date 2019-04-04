package tokickortostart;

import java.util.ArrayList;

//ADT for the representation of weighted digraphs

public class Graph {
	private final int V; //Number of vertices in the graph
	private ArrayList<Edge>[] adj; //Array of ArrayList<Edge> representing the edges going out of every vertex

	public Graph(int size) {
		//Initialize a digraph with the given parameters
		this.V = size;
		adj = new ArrayList[size];
		for (int v = 0; v < size; v++) {
			adj[v] = new ArrayList<Edge>();
		}
	}

	public void addEdge(int v, int w, double weight) {
		Edge one = new Edge(v, w, weight);
		adj[v].add(one);
	}
	
	public int getV() { //Gets the number of vertices in the graph
		return this.V;
	}

	public ArrayList<Edge> adj(int v) { //Gets the ArrayList<Edge> representing the edges coming out from a vertex
		return adj[v];
	}

}