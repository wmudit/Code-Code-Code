package String;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

	public static int longestSubstring(String s) {
		int max = 0;
		char[] ch = s.toCharArray();
		Set<Character> set = new HashSet<>();
		int currLength = 0;
		int i = 0, j = 0;
		while(i < ch.length && j < ch.length) {
			if(set.add(ch[j])) {
				currLength = j - i + 1;
				if(currLength > max) {
					max = currLength;
				}
				j++;
			} else {
				currLength -= 1;
				set.remove(ch[i]);
				i++;
			}
		}
		// n i m i s h a
		
		return max;
	}
	
	public static void main(String[] args) {
		//System.out.println(longestSubstring("geeksforgeeks"));
		//System.out.println(longestSubstring("ABDEFGABEF"));
		//System.out.println(longestSubstring("AAAAAA"));
		//System.out.println(longestSubstring("nimisha"));
		System.out.println(longestSubstring(" "));
	}
	
}
