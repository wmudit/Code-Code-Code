package Array;

import java.util.*;

public class SortByFrequency {
	
	static class MyComparator implements Comparator<Integer> {
		Map<Integer, Integer> map;
		
		public MyComparator(Map<Integer, Integer> map) {
			this.map = map;
		}
		
		public int compare(Integer a, Integer b) {
			int freq1 = map.get(a), freq2 = map.get(b);
			if(freq1 == freq2)
				return a - b;
			return freq2 - freq1;
		}
	}
	
	public static void frequencySort(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		Integer[] array = new Integer[arr.length];
		for(int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
			array[i] = arr[i];
		}
		Arrays.sort(array, new MyComparator(map));
		for(int i = 0; i < array.length; i++) 
			arr[i] = array[i];
	}

	public static void main(String[] args) {
		int[] arr = { 4, 4, 2, 2, 2, 2, 3, 3, 1, 1, 6, 7, 5 };
		frequencySort(arr);
		for(int i : arr) 
			System.out.print(i + " ");
	}

}
