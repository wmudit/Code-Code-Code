
public class BestTimeToBuyAndSellStock {

	// One Transaction Allowed
	public int maxProfit(int prices[]) {
		int minprice = Integer.MAX_VALUE;
		int maxprofit = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minprice)
				minprice = prices[i];
			else if (prices[i] - minprice > maxprofit)
				maxprofit = prices[i] - minprice;
		}
		return maxprofit;
	}

	// As many transactions allowed
	public int maxProfitII(int[] prices) {
		int maxprofit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1])
				maxprofit += prices[i] - prices[i - 1];
		}
		return maxprofit;
	}

	// k transactions allowed
	public int maxProfit(int k, int[] prices) {
		int len = prices.length;
		if (k >= len / 2)
			return quickSolve(prices);		// Because one transaction is of two parts - buy and sell

		int[][] t = new int[k + 1][len];
		for (int i = 1; i <= k; i++) {
			int tmpMax = -prices[0];
			for (int j = 1; j < len; j++) {
				t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
				tmpMax = Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
			}
		}
		return t[k][len - 1];
	}

	private int quickSolve(int[] prices) {
		int len = prices.length, profit = 0;
		for (int i = 1; i < len; i++)
			// as long as there is a price gap, we gain a profit.
			if (prices[i] > prices[i - 1])
				profit += prices[i] - prices[i - 1];
		return profit;
	}
}
