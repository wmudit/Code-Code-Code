
public class MoveZeroes {

	void moveZeroes(int[] nums) {
		int lastNonZeroFoundAt = 0;
		// If the current element is not 0, then we need to
		// append it just in front of last non 0 element we found.
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[lastNonZeroFoundAt++] = nums[i];
			}
		}
		// After we have finished processing new elements,
		// all the non-zero elements are already at beginning of array.
		// We just need to fill remaining array with 0's.
		for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
			nums[i] = 0;
		}
	}

	void moveZeroesII(int[] nums) {
		for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++) {
			if (nums[cur] != 0) {
				int temp = nums[lastNonZeroFoundAt];
				nums[lastNonZeroFoundAt] = nums[cur];
				nums[cur] = temp;
				lastNonZeroFoundAt++;
			}
		}
	}

}
