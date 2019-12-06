package DP;

public class EditDistance {

	public static int minDistance(String w1, String w2) {
		int m = w1.length(), n = w2.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for(int i = 1; i <= m; i++)
            dp[i][0] = i;
        for(int j = 1; j <= n; j++)
            dp[0][j] = j;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(w1.charAt(i - 1) == w2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                	dp[i][j]++;
                }
            }
        }
        return dp[m][n];
    }
	
	public static void main(String[] args) {
		System.out.println(minDistance("horsa", "a"));
	}
}
