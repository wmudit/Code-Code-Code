package Array;

import java.util.*;

public class ThirdMaximumNumber {

	public int thirdMax(int[] nums) {
        long firstMax = Long.MIN_VALUE,secondMax = Long.MIN_VALUE,thirdMax = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = nums[i];
            } else if(nums[i] > secondMax && nums[i] < firstMax) {
                thirdMax = secondMax;
                secondMax = nums[i];
            } else if( nums[i] > thirdMax && nums[i] < secondMax) {
                thirdMax = nums[i];
            }
        }
        return (int)(thirdMax == Long.MIN_VALUE ? firstMax: thirdMax);
    }
	
	public int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;
        for(int j = low; j < high; j++) {
            if(nums[j] <= pivot) {
                i++;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        int temp = nums[i + 1];
        nums[i + 1] = nums[high];
        nums[high] = temp;
        return (i + 1);
    }
    
    public int randomPartition(int[] nums, int low, int high) {
        Random random = new Random();
        int randomIdx = low + random.nextInt(high - low);
        int temp = nums[randomIdx];
        nums[randomIdx] = nums[high];
        nums[high] = temp;
        return partition(nums, low, high);
    }
    
    public int thirdMax1(int[] nums) {
        if(nums.length < 3) {
            int max = Integer.MIN_VALUE;
            for(int num : nums) {
                if(num > max)
                    max = num;
            }
            return max;
        }
            
        int k = nums.length - 3;
        int low = 0, high = nums.length - 1;
        int pivotIdx = randomPartition(nums, low, high); 
        while(low <= high) {
            if((pivotIdx) == k)
                return nums[pivotIdx];
            else if(pivotIdx < k) {
                low = pivotIdx + 1;
                pivotIdx = randomPartition(nums, low, high);
            } else {
                high = pivotIdx - 1;
                pivotIdx = randomPartition(nums, low, high);
            }
        }
        return -1;
    }
}
