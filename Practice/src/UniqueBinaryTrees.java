import java.util.ArrayList;
import java.util.List;

public class UniqueBinaryTrees {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int numTrees(int n) {
		int[] G = new int[n + 1];
		G[0] = G[1] = 1;

		for (int i = 2; i <= n; ++i) {
			for (int j = 1; j <= i; ++j) {
				G[i] += G[j - 1] * G[i - j];
			}
		}

		return G[n];
	}
	
	public List<TreeNode> generateTrees(int n) {
	    return genTreeList(1,n);
	}

	private List<TreeNode> genTreeList (int start, int end) {
	    List<TreeNode> list = new ArrayList<TreeNode>(); 
	    if (start > end) {
	        list.add(null);
	    }
	    for(int idx = start; idx <= end; idx++) {
	        List<TreeNode> leftList = genTreeList(start, idx - 1);
	        List<TreeNode> rightList = genTreeList(idx + 1, end);
	        for (TreeNode left : leftList) {
	            for(TreeNode right: rightList) {
	                TreeNode root = new TreeNode(idx);
	                root.left = left;
	                root.right = right;
	                list.add(root);
	            }
	        }
	    }
	    return list;
	}

}
