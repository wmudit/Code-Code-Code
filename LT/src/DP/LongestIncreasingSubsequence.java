package DP;

public class LongestIncreasingSubsequence {
	
	public static int ceilIndex(int[] A, int low, int high, int key) {
		
		while(high - low > 1) {
			int mid = low + (high - low) / 2;
			if(A[mid] >= key)
				high = mid;
			else
				low = mid;
		}
		return high;
		
	}
	
	public static int LISnlgn(int[] A) {
		int[] arr = new int[A.length];
		int len = 0;
		
		arr[0] = A[0];
		len = 1;
		
		for(int i = 1; i < A.length; i++) {
			if(A[i] < arr[0]) {
				arr[0] = A[i];
			} else if(A[i] > arr[len - 1]) {
				arr[len++] = A[i];
			} else {
				int idx = ceilIndex(A, -1, len - 1, A[i]);
				arr[idx] = A[i];
			}
		}
		
		return len;
		
	}

	public static void main(String[] args) {
		int[] input = {2, 5, 3, 7, 11, 8, 10, 13, 6};
		System.out.println(LISnlgn(input));
	}
	
}
