import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPreorder {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return helper(0, 0, inorder.length - 1, preorder, inorder);
	}

	public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
		if (preStart > preorder.length - 1 || inStart > inEnd) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preStart]);
		int inIndex = 0; // Index of current root in inorder
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == root.val) {
				inIndex = i;
			}
		}
		root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
		root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
		return root;
	}

	// Caching Inorder to reduce running time
	public TreeNode buildTreeII(int[] preorder, int[] inorder) {
		Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < inorder.length; i++) {
			inMap.put(inorder[i], i);
		}

		TreeNode root = buildTreeII(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
		return root;
	}

	public TreeNode buildTreeII(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
			Map<Integer, Integer> inMap) {
		if (preStart > preEnd || inStart > inEnd)
			return null;

		TreeNode root = new TreeNode(preorder[preStart]);
		int inRoot = inMap.get(root.val);
		int numsLeft = inRoot - inStart;

		root.left = buildTreeII(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
		root.right = buildTreeII(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

		return root;
	}

}
