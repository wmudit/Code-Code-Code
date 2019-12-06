import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i + 2 < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) // skip same result
				continue;
			int j = i + 1, k = nums.length - 1;
			int target = -nums[i];
			while (j < k) {
				if (nums[j] + nums[k] == target) {
					res.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++;
					k--;
					while (j < k && nums[j] == nums[j - 1])
						j++; // skip same result
					while (j < k && nums[k] == nums[k + 1])
						k--; // skip same result
				} else if (nums[j] + nums[k] > target)
					k--;
				else
					j++;
			}
		}
		return res;
	}

	public int threeSumClosest(int[] num, int target) {
		int result = num[0] + num[1] + num[num.length - 1];
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			int start = i + 1, end = num.length - 1;
			while (start < end) {
				int sum = num[i] + num[start] + num[end];
				if (sum > target) // implement skip duplicates
					end--;
				else // implement skip duplicates
					start++;
				if (Math.abs(sum - target) < Math.abs(result - target))
					result = sum;
			}
		}
		return result;
	}

	/*
	 * Given an array of n integers nums and a target, find the number of index
	 * triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] +
	 * nums[j] + nums[k] < target
	 */
	public int threeSumSmaller(int[] nums, int target) {
		if (nums == null || nums.length < 3) {
			return 0;
		}

		int result = 0;
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				if (nums[i] + nums[j] + nums[k] < target) {
					result += (k - j);
					j++;
				} else {
					k--;
				}
			}
		}

		return result;
	}

}
