package Array;

public class SplitArrayLargestSum {
	
	public static int splitArray(int[] nums, int m) {
        long sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i : nums) {
            if(i > max)
                max = i;
            sum += i;
        }
        long l = max, r = sum;
        while(l <= r) {
            long mid = (l + r) / 2;
            if(isValid(mid, nums, m))
                r = mid - 1;
            else 
                l = mid + 1;
        }
        return (int) l;
    }
    public static boolean isValid(long mid, int[] nums, int m) {
        int count = 1;
        int sum = 0;
        for(int i : nums) {
            sum += i;
            if(sum > mid) {
                count++;
                sum = i;
                if(count > m)
                    return false;
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		
		int[] input = {1,3,2,4,7};
		int m = 2;
		System.out.println(splitArray(input, m));
		
	}
}
