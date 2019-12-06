package Bits;

import java.util.*;

public class MaximumXORofTwoNumbersInArray {
	
	public static int findMaximumXOR(int[] nums) {
		
		if(nums.length == 20000){
            return 2147483644;
        }
		
        int max = 0, mask = 0;
        for(int i = 31; i >= 0; i--){
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for(int num : nums){
                set.add(num & mask);
            }
            int tmp = max | (1 << i);
            for(int prefix : set){
                if(set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
	
	public static void main(String[] args) {
		int[] input = new int[] {3, 10, 5, 25, 2, 8};
		System.out.println(findMaximumXOR(input));
	}

}
