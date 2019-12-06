package Tree;

import java.util.*;

public class CousinsInBinaryTree {

	public static boolean areCousins(TreeNode root, int x, int y) {
		if(root == null)
			return false;
		Queue<TreeNode> q = new LinkedList<>();
		boolean foundX = false, foundY = false;
		q.add(root);
		int size = q.size();
		while(!q.isEmpty()) {
			size = q.size();
			while(size > 0) {
				TreeNode node = q.poll();
				if(node.val == x)
					foundX = true;
				else if(node.val == y)
					foundY = true;
				if((node.left != null && node.right != null) && ((node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val == x))) {
					return false;
				}
				else {
					if(node.left != null)
						q.add(node.left);
					if(node.right != null)
						q.add(node.right);
						
				}
				size--;
			}
			if(foundX && foundY)
				return true;
			else 
				foundX = foundY = false;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(5);
		root.left.right.left = new TreeNode(6);
		root.left.right.right = new TreeNode(7);
		root.right.right.left = new TreeNode(8);
		root.right.right.right = new TreeNode(9);
		System.out.println(areCousins(root, 6, 9));
	}
	
}
