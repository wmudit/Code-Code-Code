package Graph;

import java.util.*;

public class Graph {

	LinkedList<Integer> adj[];
	int[] weights;
	
	@SuppressWarnings("unchecked")
	public Graph(int v, int[] wts) {
		adj = new LinkedList[v];
		weights = wts;
		
		for(int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int u, int v) {
		adj[u].add(v);
		adj[v].add(u);
	}
	
	public void printGraph() {
		for(int i = 0; i < adj.length; i++) {
			System.out.print(weights[i] + " -> " );
			for(int j = 0; j < adj[i].size(); j++) {
				System.out.print(weights[adj[i].get(j)] + " ");
			}
			System.out.println();
		}
	}
	
}
