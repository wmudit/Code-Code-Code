import java.util.*;

/*Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).*/

public class BinaryTreeZigZagLevelOrderTraversal {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> sol = new ArrayList<>();
		travel(root, sol, 0);
		return sol;
	}

	private void travel(TreeNode curr, List<List<Integer>> sol, int level) {
		if (curr == null)
			return;

		if (sol.size() <= level) {
			List<Integer> newLevel = new LinkedList<>();
			sol.add(newLevel);
		}

		List<Integer> collection = sol.get(level);
		if (level % 2 == 0)
			collection.add(curr.val);
		else
			collection.add(0, curr.val);

		travel(curr.left, sol, level + 1);
		travel(curr.right, sol, level + 1);
	}

}
