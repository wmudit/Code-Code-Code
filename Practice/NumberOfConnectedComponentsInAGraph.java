import java.util.*;

public class NumberOfConnectedComponentsInAGraph {

	private int[] father;

	public int countComponents(int n, int[][] edges) {
		Set<Integer> set = new HashSet<Integer>();
		father = new int[n];
		for (int i = 0; i < n; i++) {
			father[i] = i;
		}
		for (int i = 0; i < edges.length; i++) {
			union(edges[i][0], edges[i][1]);
		}

		for (int i = 0; i < n; i++) {
			set.add(find(i));
			System.out.println("i = " + i + " father[i] = " + father[i] + " find(i) = " + find(i));
		}
		return set.size();
	}

	int find(int node) {
		if (father[node] == node) {
			return node;
		}
		father[node] = find(father[node]);
		return father[node];
	}

	void union(int node1, int node2) {
		father[find(node1)] = find(node2);
	}

	public static void main(String[] args) {
		NumberOfConnectedComponentsInAGraph n = new NumberOfConnectedComponentsInAGraph();
		int[][] e = { { 0, 1 }, { 1, 2 }, { 3, 4 } };
		n.countComponents(5, e);
	}

}
