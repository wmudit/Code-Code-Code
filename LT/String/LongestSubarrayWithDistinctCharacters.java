package String;

import java.util.*;

public class LongestSubarrayWithDistinctCharacters {
	
	public static String longestSubarrayWithDistinctCharacters(String s, String c) {
		char[] string = s.toCharArray();
		char[] chars = c.toCharArray();
		
		Map<Character, Integer> map = new HashMap<>();
		int head = 0, count = 0;
		String res = "";
		
		for(char ch : chars) {
			map.put(ch, 0);
		}
		
		for(int tail = 0; tail < string.length; tail++) {
			if(!map.containsKey(string[tail]))
				continue;
			
			int tailCount = map.get(string[tail]);
			if(tailCount == 0)
				count += 1;
			
			map.put(string[tail], tailCount + 1);
			
			while(count == chars.length) {
				int tempLen = tail - head + 1;
				
				if(tempLen == chars.length)
					return s.substring(head, tail + 1);
				
				if(res == "" || tempLen < res.length())
					res = s.substring(head, tail + 1);
				
				if(map.containsKey(string[head])) {
					int headCount = map.get(string[head]) - 1;
					if(headCount == 0)
						count--;
					map.put(string[head], headCount);
				}
				
				head++;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		//System.out.println(longestSubarrayWithDistinctCharacters("ABAACBAB","ABC"));
		//System.out.println(longestSubarrayWithDistinctCharacters("ADOBECODEBANC","ABC"));
		System.out.println(longestSubarrayWithDistinctCharacters("aa","aa"));
	}

}
