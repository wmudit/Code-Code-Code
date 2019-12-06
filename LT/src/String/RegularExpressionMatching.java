package String;

public class RegularExpressionMatching {

	public static boolean regex(String s, String p) {
		int n = s.length(), m = p.length();
		boolean[][] dp = new boolean[n + 1][m + 1];

		dp[0][0] = true;
		for(int k = 1; k <= m; k++) {
			if(p.charAt(k - 1) == '*')
				dp[0][k] = dp[0][k - 2];
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')
					dp[i][j] = dp[i - 1][j - 1];
				else if(p.charAt(j - 1) == '*') {
					dp[i][j] = dp[i][j - 2];
					if(s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') 
						dp[i][j] = dp[i][j] || dp[i - 1][j];
				}
			}
		}
		
		return dp[n][m];
	}
	
	public static void main(String[] args) {
		System.out.println(regex("mississippi", "mis*is*p*."));
	}
	
}
