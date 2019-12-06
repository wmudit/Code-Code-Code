
public class LowestCommonAncestor {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// BST
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while ((root.val - (long) p.val) * (root.val - (long) q.val) > 0)
			root = p.val < root.val ? root.left : root.right;
		return root;
	}

	// Binary Tree
	public TreeNode lowestCommonAncestorII(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		return left == null ? right : right == null ? left : root;
	}

}
