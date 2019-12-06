package Array;

import java.util.*;

public class TopKFrequentElements {

	public static List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int n : nums)
			map.put(n, map.getOrDefault(n, 0) + 1);
		int[][] arr = new int[map.size()][2];
		int idx = 0;
		for(Map.Entry<Integer, Integer> e : map.entrySet()) {
			arr[idx][0] = e.getKey();
			arr[idx][1] = e.getValue();
			idx++;
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1] - o1[1];
			}
		});
		List<Integer> res = new ArrayList<>();
		for(int i = 0; i < k; i++) {
			res.add(arr[i][0]);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = {1,1,1,2,2,3};
		int k = 3;
		System.out.println(topKFrequent(arr, k));
	}
}
