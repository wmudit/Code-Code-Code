import java.util.*;

public class SortTransformedArray {

	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (a * nums[i] * nums[i]) + (b * nums[i]) + c;
			q.offer(nums[i]);
		}
		int i = 0;
		while (!q.isEmpty()) {
			nums[i++] = q.poll();
		}
		return nums;
	}

}
