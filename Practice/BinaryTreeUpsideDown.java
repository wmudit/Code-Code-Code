/*Given a binary tree where all the right nodes are either leaf nodes with a sibling 
 * (a left node that shares the same parent node) or empty, flip it upside down and turn 
 * it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
 *  1
   / \
  2   3  <--Given
 / \
4   5

    4
   / \
  5   2  <--Return
     / \
    3   1  */

public class BinaryTreeUpsideDown {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode upsideDownBinaryTree(TreeNode root) {
		if (root == null) {
			return null;
		}

		return upsideDownBinaryTreeHelper(root, null);
	}

	private TreeNode upsideDownBinaryTreeHelper(TreeNode root, TreeNode parent) {
		if (root == null) {
			return parent;
		}

		TreeNode newNode = upsideDownBinaryTreeHelper(root.left, root);

		root.left = parent == null ? null : parent.right;
		root.right = parent;

		return newNode;
	}

}
