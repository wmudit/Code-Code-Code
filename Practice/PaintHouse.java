
public class PaintHouse {

	/*
	 * There are a row of n houses, each house can be painted with one of the three
	 * colors: red, blue or green. The cost of painting each house with a certain
	 * color is different. You have to paint all the houses such that no two
	 * adjacent houses have the same color. The cost of painting each house with a
	 * certain color is represented by a n x 3 cost matrix. For example, costs[0][0]
	 * is the cost of painting house 0 with color red; costs[1][2] is the cost of
	 * painting house 1 with color green, and so on... Find the minimum cost to
	 * paint all houses.
	 */

	public int minCost(int[][] costs) {
		if (costs == null || costs.length == 0)
			return 0;

		for (int i = 1; i < costs.length; i++) {
			costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
			costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
			costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
		}

		int m = costs.length - 1;
		return Math.min(Math.min(costs[m][0], costs[m][1]), costs[m][2]);
	}

	public int minCostII(int[][] costs) {
		if (costs == null || costs.length == 0) {
			return 0;
		}

		int n = costs.length;
		int k = costs[0].length;

		// dp[i][j] means the min cost painting for house i, with color j
		int[][] dp = new int[n][k];

		// Initialization
		for (int i = 0; i < k; i++) {
			dp[0][i] = costs[0][i];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < k; j++) {
				dp[i][j] = Integer.MAX_VALUE;
				for (int m = 0; m < k; m++) {
					if (m != j) {
						dp[i][j] = Math.min(dp[i - 1][m] + costs[i][j], dp[i][j]);
					}
				}
			}
		}

		// Final state
		int minCost = Integer.MAX_VALUE;
		for (int i = 0; i < k; i++) {
			minCost = Math.min(minCost, dp[n - 1][i]);
		}

		return minCost;
	}

}
