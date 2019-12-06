package Array;

import java.util.*;

public class SubarraySumDivisibleByK {

	public static int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, sum = 0;
        for(int a : A) {
            sum = (sum + a) % K;
            if(sum < 0) sum += K;  // Because -1 % 5 = -1, but we need the positive mod 4
            count += map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
	
	public static void main(String[] args) {
		int[] a = {4, 5, 0, -2, -3, 1};
		int[] b = {2, 7, 6, 1, 4, 5};
		System.out.println(subarraysDivByK(a, 3));
		System.out.println(subarraysDivByK(b, 5));
	}
	
}
