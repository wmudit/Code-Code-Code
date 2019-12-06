import java.util.*;

public class PalindromePartitioning {

	public List<List<String>> partition(String s) {
		List<List<String>> list = new ArrayList<>();
		backtrack(list, new ArrayList<>(), s, 0);
		return list;
	}

	public void backtrack(List<List<String>> list, List<String> tempList, String s, int start) {
		if (start == s.length())
			list.add(new ArrayList<>(tempList));
		else {
			for (int i = start; i < s.length(); i++) {
				if (isPalindrome(s, start, i)) {
					tempList.add(s.substring(start, i + 1));
					backtrack(list, tempList, s, i + 1);
					tempList.remove(tempList.size() - 1);
				}
			}
		}
	}

	public boolean isPalindrome(String s, int low, int high) {
		while (low < high)
			if (s.charAt(low++) != s.charAt(high--))
				return false;
		return true;
	}

	/*
	 * The definition of ‘cut’ array is the minimum number of cuts of a sub string.
	 * More specifically, cut[n] stores the cut number of string s[0, n-1].
	 * 
	 * Here is the basic idea of the solution:
	 * 
	 * 1. Initialize the ‘cut’ array: For a string with n characters s[0, n-1], it
	 * needs at most n-1 cut. Therefore, the ‘cut’ array is initialized as cut[i] =
	 * i-1 2. Use two variables in two loops to represent a palindrome: The external
	 * loop variable ‘i’ represents the center of the palindrome. The internal loop
	 * variable ‘j’ represents the ‘radius’ of the palindrome. Apparently, j <= i is
	 * a must. This palindrome can then be represented as s[i-j, i+j]. If this
	 * string is indeed a palindrome, then one possible value of cut[i+j] is
	 * cut[i-j] + 1, where cut[i-j] corresponds to s[0, i-j-1] and 1 correspond to
	 * the palindrome s[i-j, i+j];
	 * 
	 * When the loops finish, you’ll get the answer at cut[s.length]
	 */

	// Minimum cuts needed
	public int minCut(String s) {
		if (s.length() == 0)
			return 0;
		int[] c = new int[s.length() + 1];
		for (int i = 0; i < s.length(); i++)
			c[i] = Integer.MAX_VALUE;
		c[s.length()] = -1;
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int a = i, b = i; a >= 0 && b < s.length() && s.charAt(a) == s.charAt(b); a--, b++)
				c[a] = Math.min(c[a], 1 + c[b + 1]);
			for (int a = i, b = i + 1; a >= 0 && b < s.length() && s.charAt(a) == s.charAt(b); a--, b++)
				c[a] = Math.min(c[a], 1 + c[b + 1]);
		}
		return c[0];
	}
}
