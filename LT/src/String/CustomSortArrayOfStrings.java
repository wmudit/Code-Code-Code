package String;

import java.util.*;

public class CustomSortArrayOfStrings {
	
	static class MyComparator implements Comparator<String> {
		
		Map<Character, Integer> map;
		
		public MyComparator(Map<Character, Integer> map) {
			this.map = map;
		}
		
		public int compare(String s1, String s2) {
			int l1 = s1.length(), l2 = s2.length(), i = 0, j = 0;
			
			while(s1.charAt(i) == s2.charAt(j) && i < l1 && j < l2) {
				i++;
				j++;
			}
			if(i == l1 - 1 && j == l2 - 1) 
				return 0;
			else if(i == l1 - 1 || j == l2 - 1) 
				return i - j;
			else 
				return map.get(s1.charAt(i)) - map.get(s2.charAt(j));
				
		}

	}
	
	public static void sort(String[] arr, String str) {
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < str.length(); i++) {
			map.put(str.charAt(i), i + 1);
		}
		Arrays.sort(arr, new MyComparator(map));
	}
	
	public static void main(String[] args) {
		String[] arr = {"geeksforgeeks", "is", "the", "best", "place", "for", "learning"};
		String str = "fguecbdavwyxzhijklmnopqrst";
		String[] arr1 = {"rainbow", "consists", "of", "colors"};
		String str1 = "avdfghiwyxzjkecbmnopqrstul";
		sort(arr1, str1);
		for(String s : arr1)
			System.out.print(s + " ");
	}

}
