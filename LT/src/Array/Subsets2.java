package Array;

import java.util.*;

public class Subsets2 {

	public static void backtrack(int[] nums, List<Integer> curr, List<List<Integer>> res, int idx) {
		res.add(new ArrayList<>(curr));
		for(int i = idx; i < nums.length; i++) {
			if(i > idx && nums[i] == nums[i - 1])
				continue;
			curr.add(nums[i]);
			backtrack(nums, curr, res, i + 1);
			curr.remove(curr.size() - 1);
		}
	}

	public static List<List<Integer>> subsets(int[] nums) {	
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		backtrack(nums, new ArrayList<Integer>(), res, 0);
		return res;
	}
	
	public static void main(String[] args) {
		int[] input = {1, 2, 2};
		List<List<Integer>> subset = subsets(input);
		for(int i = 0; i < subset.size(); i++) {
			for(int j = 0; j < subset.get(i).size(); j++) {
				System.out.print(subset.get(i).get(j) + " ");
			}
			System.out.print("\n");
		}
		
	}
	
}
