import java.util.*;

public class MaximumSizeSubarraySumEqualsK {

	public int maxSubArrayLen(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int maxLen = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1); // IMPOARTANT
		int sum = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}

			if (map.containsKey(sum - k)) {
				maxLen = Math.max(maxLen, i - map.get(sum - k));
			}
		}

		return maxLen;
	}

}
