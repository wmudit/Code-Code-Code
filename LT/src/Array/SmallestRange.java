package Array;

import java.util.*;

public class SmallestRange {
	
	public static int[] smallestRange(List<List<Integer>> nums) {
		int[] res = {Integer.MAX_VALUE, Integer.MIN_VALUE};
		int[] idx = new int[nums.size()];
		Queue<int[]> minPQ = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});
		Queue<int[]> maxPQ = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return b[0] - a[0];
			}
		});	
		
		//int i = 0;
		for(int j = 0; j < nums.size(); j++) {
			minPQ.add(new int[] {nums.get(j).get(0), j});
			maxPQ.add(new int[] {nums.get(j).get(0), j});
		}
		int minRange = Integer.MAX_VALUE;
		while(minPQ.size() == nums.size()) {
			int[] min = minPQ.poll();
			int[] max = maxPQ.peek();
			int range = max[0] - min[0];
			if(range < minRange) {
				res[0] = min[0];
				res[1] = max[0];
				minRange = range;
			}
			if(idx[min[1]] + 1 < nums.get(min[1]).size()) {
				idx[min[1]]++;
				minPQ.add(new int[] {nums.get(min[1]).get(idx[min[1]]), min[1]});
				maxPQ.add(new int[] {nums.get(min[1]).get(idx[min[1]]), min[1]});
			}
		}
		
		return res;
	}

	/*[	[4,10,15,24,26], 
	 * 	[0,9,12,20], 
	 * 	[5,18,22,30] ]
	 */
	
	public static void main(String[] args) {
		List<List<Integer>> lists = new ArrayList<>();
		List<Integer> temp1 = new ArrayList<>();
		temp1.add(4);
		temp1.add(10);
		temp1.add(15);
		temp1.add(24);
		temp1.add(26);
		lists.add(temp1);
		
		List<Integer> temp2 = new ArrayList<>();
		temp2.add(0);
		temp2.add(9);
		temp2.add(12);
		temp2.add(20);
		lists.add(temp2);
		
		List<Integer> temp3 = new ArrayList<>();
		temp3.add(5);
		temp3.add(18);
		temp3.add(22);
		temp3.add(30);
		lists.add(temp3);
		
		int[] res = smallestRange(lists);
		System.out.println(res[0] + " " + res[1]);
		
	}

}
