import java.util.*;

public class HouseRobber {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int rob(int num[]) {
		int n = num.length;
		int a = 0;
		int b = 0;

		for (int i = 0; i < n; i++) {
			if (i % 2 == 0)
				a = Math.max(a + num[i], b);

			else
				b = Math.max(a, b + num[i]);
		}
		return Math.max(a, b);
	}

	// Houses are arranged in a circular fashion
	public int robII(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
	}

	private int rob(int[] num, int lo, int hi) {
		int include = 0, exclude = 0;
		for (int j = lo; j <= hi; j++) {
			int i = include, e = exclude;
			include = e + num[j];
			exclude = Math.max(e, i);
		}
		return Math.max(include, exclude);
	}

	// Dynamic Programming
	public int rob(TreeNode root) {
		return robSub(root, new HashMap<>());
	}

	private int robSub(TreeNode root, Map<TreeNode, Integer> map) {
		if (root == null)
			return 0;
		if (map.containsKey(root))
			return map.get(root);

		int val = 0;

		if (root.left != null) {
			val += robSub(root.left.left, map) + robSub(root.left.right, map);
		}

		if (root.right != null) {
			val += robSub(root.right.left, map) + robSub(root.right.right, map);
		}

		val = Math.max(val + root.val, robSub(root.left, map) + robSub(root.right, map));
		map.put(root, val);

		return val;
	}

	/*
	 * rob(root) is a function which will return an array of two elements, the first
	 * element of which denotes the maximum amount of money that can be robbed if
	 * root is not robbed, while the second element signifies the maximum amount of
	 * money robbed if it is robbed
	 */
	public int robII(TreeNode root) {
		int[] res = robSub(root);
		return Math.max(res[0], res[1]);
	}

	private int[] robSub(TreeNode root) {
		if (root == null)
			return new int[2];

		int[] left = robSub(root.left);
		int[] right = robSub(root.right);
		int[] res = new int[2];

		res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		res[1] = root.val + left[0] + right[0];

		return res;
	}
}
