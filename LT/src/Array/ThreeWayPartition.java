package Array;

public class ThreeWayPartition {
	
	public static void partition(int[] arr, int k) {
		int start = 0, end = arr.length - 1, mid = 0;
		while(mid < end) {
			if(arr[mid] < k) {
				int temp = arr[start];
				arr[start] = arr[mid];
				arr[mid] = temp;
				start++;
			} else if (arr[mid] > k) {
				int temp = arr[end];
				arr[end] = arr[mid];
				arr[mid] = temp;
				end--;
			} else {
				
			}
			mid++;
		}
	}

	//[3, 4, 5, 6, 4, 7, 5] k = 5
	//[3, 4, 4, 5, 5, 6, 7]
	
	public static void main(String[] args) {
		int[] arr = {3, 4, 5, 6, 4, 7, 5, 3};
		partition(arr, 5);
		for(int a : arr)
			System.out.print(a + " ");
	}
}
