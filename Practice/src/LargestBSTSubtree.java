
public class LargestBSTSubtree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Data {
		int size = 0;
		int lower = Integer.MAX_VALUE;
		int upper = Integer.MIN_VALUE;
		boolean isBST = false;
	}

	private int max = 0;

	public int largestBSTSubtree(TreeNode root) {
		if (root == null) {
			return 0;
		}

		largestBSTHelper(root);

		return max;
	}

	private Data largestBSTHelper(TreeNode root) {
		Data curr = new Data();
		if (root == null) {
			curr.isBST = true;
			return curr;
		}

		Data left = largestBSTHelper(root.left);
		Data right = largestBSTHelper(root.right);

		curr.lower = Math.min(root.val, Math.min(left.lower, right.lower));
		curr.upper = Math.max(root.val, Math.max(left.upper, right.upper));

		if (left.isBST && root.val > left.upper && right.isBST && root.val < right.lower) {
			curr.size = left.size + right.size + 1;
			curr.isBST = true;
			max = Math.max(max, curr.size);
		} else {
			curr.size = 0;
		}

		return curr;
	}

}
