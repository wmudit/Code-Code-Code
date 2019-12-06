
public class RegularExpressionMatching {

	public boolean isMatch(String text, String pattern) {
		boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
		dp[text.length()][pattern.length()] = true;

		for (int i = text.length(); i >= 0; i--) {
			for (int j = pattern.length() - 1; j >= 0; j--) {
				boolean first_match = (i < text.length()
						&& (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));
				if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
					dp[i][j] = dp[i][j + 2] || first_match && dp[i + 1][j];
				} else {
					dp[i][j] = first_match && dp[i + 1][j + 1];
				}
			}
		}
		return dp[0][0];
	}

	/*
	 * public boolean isMatch1(String s, String p) { if(s == null || p == null) {
	 * return false; } boolean[][] state = new boolean[s.length() + 1][p.length() +
	 * 1]; state[0][0] = true; for (int j = 1; j < state[0].length; j++) { if
	 * (p.charAt(j - 1) == '*') { if (state[0][j - 1] || (j > 1 && state[0][j - 2]))
	 * { state[0][j] = true; } } } for (int i = 1; i < state.length; i++) { for (int
	 * j = 1; j < state[0].length; j++) { if (s.charAt(i - 1) == p.charAt(j - 1) ||
	 * p.charAt(j - 1) == '.') { state[i][j] = state[i - 1][j - 1]; } if (p.charAt(j
	 * - 1) == '*') { if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) !=
	 * '.') { state[i][j] = state[i][j - 2]; } else { state[i][j] = state[i - 1][j]
	 * || state[i][j - 1] || state[i][j - 2]; } } } } return
	 * state[s.length()][p.length()]; }
	 */

	public boolean comparison(String str, String pattern) {
		int s = 0, p = 0, match = 0, starIdx = -1;
		while (s < str.length()) {
			// advancing both pointers
			if (p < pattern.length() && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))) {
				s++;
				p++;
			}
			// * found, only advancing pattern pointer
			else if (p < pattern.length() && pattern.charAt(p) == '*') {
				starIdx = p;
				match = s;
				p++;
			}
			// last pattern pointer was *, advancing string pointer
			else if (starIdx != -1) {
				p = starIdx + 1;
				match++;
				s = match;
			}
			// current pattern pointer is not star, last patter pointer was not *
			// characters do not match
			else
				return false;
		}

		// check for remaining characters in pattern
		while (p < pattern.length() && pattern.charAt(p) == '*')
			p++;

		return p == pattern.length();
	}

}
