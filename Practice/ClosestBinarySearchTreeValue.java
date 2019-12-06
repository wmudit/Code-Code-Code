import java.util.*;

public class ClosestBinarySearchTreeValue {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int closestValue(TreeNode root, double target) {
		if (root == null) {
			throw new NullPointerException("Tree must be non-empty");
		}

		int result = 0;
		double min = Double.MAX_VALUE;

		while (root != null) {
			if (root.val == target) {
				return root.val;
			}

			double dist = Math.abs(root.val - target);
			if (dist < min) {
				result = root.val;
				min = dist;
			}

			if (target > root.val) {
				root = root.right;
			} else if (target < root.val) {
				root = root.left;
			}
		}
		return result;
	}

}