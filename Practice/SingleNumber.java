
public class SingleNumber {

	int singleNumber(int A[]) {
		int result = 0;
		for (int i = 0; i < A.length; i++) {
			result ^= A[i];
		}
		return result;
	}

	/*
	 * Given an array of integers, every element appears three times except for one,
	 * which appears exactly once. Find that single one.
	 */
	public int singleNumber2(int[] A) {
		int ones = 0, twos = 0;
		for (int i = 0; i < A.length; i++) {
			ones = (ones ^ A[i]) & ~twos;
			twos = (twos ^ A[i]) & ~ones;
		}
		return ones;
	}

	/*
	 * Given an array of numbers nums, in which exactly two elements appear only
	 * once and all the other elements appear exactly twice. Find the two elements
	 * that appear only once
	 */
	public int[] singleNumber3(int[] nums) {
		// Pass 1 :
		// Get the XOR of the two numbers we need to find
		int diff = 0;
		for (int num : nums) {
			diff ^= num;
		}
		// Get its last set bit
		diff &= -diff;

		// Pass 2 :
		int[] rets = { 0, 0 }; // this array stores the two numbers we will return
		for (int num : nums) {
			if ((num & diff) == 0) // the bit is not set
			{
				rets[0] ^= num;
			} else // the bit is set
			{
				rets[1] ^= num;
			}
		}
		return rets;
	}
}
