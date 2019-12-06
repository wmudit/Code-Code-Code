package Array;

import java.util.*;

public class SubarrayWithKDifferentIntegers {

	public int subarraysWithKDistinct(int[] A, int K) {
		int count = 0;
		Set<Integer> set = new HashSet<>();
		int head = 0, tail = 0;
		while(head < A.length) {
			if(set.size() < K) {
				set.add(A[tail++]);
			}
			if(set.size() == K) {
				count++;
				if(set.contains(tail)) {
					count++;
					tail++;
				} else {
					set.remove(A[head++]);
				}
			}
		}

		return count;
	}
	
	public int subarraysWithKDistinct1(int[] A, int K) {
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		int head = 0, tail = 0, n = A.length;
		while(head < n) {
			if(map.size() == K) {
				while(map.containsKey(A[tail])) {
					map.put(A[tail], map.get(A[tail]) + 1);
					tail++;
					count++;
				}
			} else if (map.size() < K) {
				map.put(A[tail], map.getOrDefault(A[tail], 0) + 1);
				tail++;
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		//int[] input1 = { 1, 2, 1, 2, 3 }; // 1,2  1,2,1  1,2,1,2  1,2  2,1  2,3
		//int[] input2 = { 1, 2, 1, 3, 4 };
	}

}
