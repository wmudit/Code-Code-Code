package Tree;

import java.util.*;

public class VerticalOrderTraversal {
	
	static Map<Integer, List<Integer>> map;

	static class Node {
		int val;
		Node left, right;
		public Node(int val) {
			this.val = val;
			left = null;
			right = null;
		}
	}
	
	public static void traverse(Node node, int d) {
		if(node == null)
			return;
		if(map.containsKey(d)) {
			List<Integer> list = map.get(d);
			list.add(node.val);
			map.put(d, list);
		} else {
			List<Integer> list = new ArrayList<>();
			list.add(node.val);
			map.put(d, list);
		}
		if(node.left != null)
			traverse(node.left, d - 1);
		if(node.right != null)
			traverse(node.right, d + 1);
	}
	
	public static void verticalOrderTraversal(Node root) {
		map = new TreeMap<>();
		traverse(root, 0);
		//List<List<Integer>> res = new ArrayList<List<Integer>>();
		for(Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
			List<Integer> list = e.getValue();
			//res.add(list);
			System.out.print(e.getKey() + " -> ");
			for(int l : list)
				System.out.print(l + " ");
			System.out.print("\n");
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		verticalOrderTraversal(root);
		
	}
	
}
