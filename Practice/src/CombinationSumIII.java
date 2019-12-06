// Find all possible combinations of k numbers that add up to a number n, given 
// that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers

import java.util.*;

public class CombinationSumIII {

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> ans = new ArrayList<>();
		combination(ans, new ArrayList<Integer>(), k, 1, n);
		return ans;
	}

	private static void combination(List<List<Integer>> ans, List<Integer> comb, int k, int start, int n) {
		if (comb.size() > k) {
			return;
		}
		if (comb.size() == k && n == 0) {
			List<Integer> li = new ArrayList<Integer>(comb);
			ans.add(li);
			return;
		}
		for (int i = start; i <= n && i <= 9; i++) {

			comb.add(i);
			combination(ans, comb, k, i + 1, n - i);
			comb.remove(comb.size() - 1);

		}
	}

}
