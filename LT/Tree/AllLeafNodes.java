package Tree;

public class AllLeafNodes {
	
	static class TreeNode {
		int val;
		TreeNode left, right;
		public TreeNode(int x) {
			val = x;
			left = right = null;
		}
	}
	
	public static void printLeaves(TreeNode root) {
		if(root == null) 
			return;
		printLeaves(root.left);
		if(root.left == null && root.right == null)
			System.out.print(root.val + " ");
		printLeaves(root.right);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		//root.left = new TreeNode(2);
		//root.right = new TreeNode(3);
		//root.left.left = new TreeNode(4);
		//root.left.right = new TreeNode(5);
		//root.right.left = new TreeNode(6);
		//root.right.right = new TreeNode(7);
		printLeaves(root);
	}

}
