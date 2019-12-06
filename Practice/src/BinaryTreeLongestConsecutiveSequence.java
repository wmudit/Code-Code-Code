
public class BinaryTreeLongestConsecutiveSequence {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int longestConsecutive(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return findLongest(root, 0, root.val - 1);
	}

	private int findLongest(TreeNode root, int length, int preVal) {
		if (root == null) {
			return length;
		}

		int currLen = preVal + 1 == root.val ? length + 1 : 1;

		return Math.max(currLen,
				Math.max(findLongest(root.left, currLen, root.val), findLongest(root.right, currLen, root.val)));
	}
}
