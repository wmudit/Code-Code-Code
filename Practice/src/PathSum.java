import java.util.*;

public class PathSum {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null)
			return sum == root.val;
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<Integer>();
		pathSumII(root, sum, cur, ret);
		return ret;
	}

	public void pathSumII(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> ret) {
		if (root == null) {
			return;
		}
		cur.add(root.val);
		if (root.left == null && root.right == null && root.val == sum) {
			ret.add(new ArrayList<Integer>(cur));
		} else {
			pathSumII(root.left, sum - root.val, cur, ret);
			pathSumII(root.right, sum - root.val, cur, ret);
		}
		cur.remove(cur.size() - 1);
	}
}
