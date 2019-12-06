/* A balanced binary tree is a binary tree in which the depth of the 
 * two subtrees of every node never differs by more than 1*/

public class BalancedBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int DFSHeight(TreeNode root) {
		if(root == null)
			return 0;
		int leftHeight = DFSHeight(root.left);
		if(leftHeight == -1) 
			return -1;
		int rightHeight = DFSHeight(root.right);
		if(rightHeight == -1)
			return -1;
		if(Math.abs(leftHeight - rightHeight) > 1)
			return -1;
		return Math.max(leftHeight, rightHeight) + 1;
	}

	public boolean isBalanced(TreeNode root) {
		return DFSHeight(root) != -1;
	}

}
