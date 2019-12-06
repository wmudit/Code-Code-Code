enum Index {
	GOOD, BAD, UNKNOWN
}

public class JumpGame {

	// DP Approach
	public boolean canJump(int[] nums) {
		Index[] memo = new Index[nums.length];
		for (int i = 0; i < memo.length; i++) {
			memo[i] = Index.UNKNOWN;
		}
		memo[memo.length - 1] = Index.GOOD;

		for (int i = nums.length - 2; i >= 0; i--) {
			int furthestJump = Math.min(i + nums[i], nums.length - 1);
			for (int j = i + 1; j <= furthestJump; j++) {
				if (memo[j] == Index.GOOD) {
					memo[i] = Index.GOOD;
					break;
				}
			}
		}
		return memo[0] == Index.GOOD;
	}

	// Greedy Approach
	public boolean canJump1(int[] nums) {
		int lastPos = nums.length - 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (i + nums[i] >= lastPos) {
				lastPos = i;
			}
		}
		return lastPos == 0;
	}

	public int jump(int[] A) {
		int step_count = 0;
		int last_jump_max = 0;
		int current_jump_max = 0;
		for (int i = 0; i < A.length - 1; i++) {
			System.out.println("i = " + i);
			current_jump_max = Math.max(current_jump_max, i + A[i]);
			System.out.println("Curr jump max = " + current_jump_max);
			if (i == last_jump_max) {
				step_count++;
				last_jump_max = current_jump_max;
				System.out.println("Step count = " + step_count + " last jump max = " + last_jump_max);
			}
		}
		return step_count;
	}
	
	public static void main(String[] args) {
		JumpGame j = new JumpGame();
		int[] array = {2, 3, 1, 1, 4};
		int res = j.jump(array);
		System.out.println(res);
	}
}
