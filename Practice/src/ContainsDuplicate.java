import java.util.*;

public class ContainsDuplicate {

	public boolean containsDuplicate(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; ++i) {
			if (nums[i] == nums[i + 1])
				return true;
		}
		return false;
	}
	
	/*public boolean containsDuplicate(int[] nums) {
	    Set<Integer> set = new HashSet<>(nums.length);
	    for (int x: nums) {
	        if (set.contains(x)) return true;
	        set.add(x);
	    }
	    return false;
	}*/
	
	/* Given an array of integers and an integer k, find out whether there are two distinct indices 
	 * i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k */
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (i > k)
				set.remove(nums[i - k - 1]);
			if (!set.add(nums[i]))
				return true;
		}
		return false;
	}

	/*  Given an array of integers, find out whether there are two distinct indices i and j 
	 * in the array such that the absolute difference between nums[i] and nums[j] is at most t 
	 * and the absolute difference between i and j is at most k */
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0 || k <= 0) {
			return false;
		}

		final TreeSet<Integer> values = new TreeSet<>();
		for (int ind = 0; ind < nums.length; ind++) {

			final Integer floor = values.floor(nums[ind] + t);
			final Integer ceil = values.ceiling(nums[ind] - t);
			if ((floor != null && floor >= nums[ind]) || (ceil != null && ceil <= nums[ind])) {
				return true;
			}

			values.add(nums[ind]);
			if (ind >= k) {
				values.remove(nums[ind - k]);
			}
		}

		return false;
	}
	
}
