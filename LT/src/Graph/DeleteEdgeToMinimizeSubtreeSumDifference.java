package Graph;

import java.util.*;

public class DeleteEdgeToMinimizeSubtreeSumDifference {
	
	static int res = Integer.MAX_VALUE;
	
	public static void dfsSum(List<Integer> graph[], int[] wts, int u, int parent, int[] subtreeSum, int total) {
		int sum = subtreeSum[u];
		
		for(int i = 0; i < graph[u].size(); i++) {
			int v = graph[u].get(i);
			if(v != parent) {
				dfsSum(graph, wts, v, u, subtreeSum, total);
				sum += subtreeSum[v];
			}
		}
		
		subtreeSum[u] = sum;
		
		if(u != 0 && Math.abs(total - 2 * sum) < res)
			res = Math.abs(total - 2 * sum); 
		
	}

	public static void main(String[] args) {
		int[] weights = {4, 2, 1, 6, 3, 5, 2};
		Graph g = new Graph(7, weights);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 5);
		g.addEdge(3, 6);
		
		int sum = 0;
		int[] subtreeSum = new int[weights.length];
		for(int i = 0; i < weights.length; i++) {
			sum += weights[i];
			subtreeSum[i] = weights[i];
		}
		
		dfsSum(g.adj, weights, 0, -1, subtreeSum, sum);
		System.out.println(res);
		
	}

}
