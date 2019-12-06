
public class PaintFence {

	public int numWays(int n, int k) {
		if (n <= 0 || k <= 0)
			return 0;
		if (n == 1)
			return k;
		// i -1 and i -2 with the same color
		int[] dp1 = new int[n];
		// i - 1 and i - 2 with diff. color
		int[] dp2 = new int[n];
		// Initializaiton
		dp1[0] = 0;
		dp2[0] = k;
		for (int i = 1; i < n; i++) {
			dp1[i] = dp2[i - 1];
			dp2[i] = (k - 1) * (dp1[i - 1] + dp2[i - 1]);
		}
		// Final state
		return dp1[n - 1] + dp2[n - 1];
	}

	// Using constant space
	public int numWaysII(int n, int k) {
		if (n <= 0 || k <= 0)
			return 0;
		if (n == 1)
			return k;
		int preSame = 0;
		int preDiff = k;
		for (int i = 1; i < n; i++) {
			int same = preDiff;
			int diff = (k - 1) * (preSame + preDiff);
			preSame = same;
			preDiff = diff;
		}
		return preSame + preDiff;
	}

}
