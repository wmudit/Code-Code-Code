package DP;

public class ChampagneTower {
	
	public static double champagneTower(int poured, int row, int col) {
		double[][] dp = new double[102][102];
		dp[0][0] = poured;
		for(int i = 0; i <= row; i++) {
			for(int j = 0; j <= col; j++) {
				if(dp[i][j] > 1) {
					double rem = dp[i][j] - 1;
					dp[i][j] = 1;
					dp[i + 1][j] += (rem / 2);
					dp[i + 1][j + 1] += (rem / 2);
				}
			}
		}
		return Math.min(1, dp[row][col]);
	}
	
    public double champagneTower1(int poured, int query_row, int query_glass) {
        double[] res = new double[query_row + 2];
        res[0] = poured;
        for (int row = 1; row <= query_row; row++)
            for (int i = row; i >= 0; i--)
                res[i + 1] += res[i] = Math.max(0.0, (res[i] - 1) / 2);
        return Math.min(res[query_glass], 1.0);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] p = {1, 2, 1, 1};
		int[] r = {1, 1, 0, 1};
		int[] c = {1, 1, 0, 0};
		for(int i = 0; i < p.length; i++) {
			System.out.println(champagneTower(p[i], r[i], c[i]));
		}
	}

}
