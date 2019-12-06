
public class UniquePaths {

	int uniquePaths(int m, int n) {
		if (m > n)
			return uniquePaths(n, m);
		int[] cur = new int[m];
		for (int k = 0; k < m; k++)
			cur[k] = 1;
		for (int j = 1; j < n; j++)
			for (int i = 1; i < m; i++)
				cur[i] += cur[i - 1];
		return cur[m - 1];
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int width = obstacleGrid[0].length;
		int[] dp = new int[width];
		dp[0] = 1;
		for (int[] row : obstacleGrid) {
			for (int j = 0; j < width; j++) {
				if (row[j] == 1)
					dp[j] = 0;
				else if (j > 0)
					dp[j] += dp[j - 1];
			}
		}
		return dp[width - 1];
	}
}
