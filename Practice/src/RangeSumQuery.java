
public class RangeSumQuery {

	private int[][] dp;
	private int[] sum;

	// 1D Immutable
	public void NumArray(int[] nums) {
		sum = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			sum[i + 1] = sum[i] + nums[i];
		}
	}

	public int sumRange(int i, int j) {
		return sum[j + 1] - sum[i];
	}

	// 2D Immutable
	// Sum(ABCD) = Sum(OD) - Sum(OB) - Sum(OC) + Sum(OA)
	public void NumMatrix(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return;
		dp = new int[matrix.length + 1][matrix[0].length + 1];
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++) {
				dp[r + 1][c + 1] = dp[r + 1][c] + dp[r][c + 1] + matrix[r][c] - dp[r][c];
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
	}

	// 1D Mutable
	private int[] b;
	private int len;
	private int[] nums;

	public void NumArrayIII(int[] nums) {
	    this.nums = nums;
	    double l = Math.sqrt(nums.length);
	    len = (int) Math.ceil(nums.length/l);
	    b = new int [len];
	    for (int i = 0; i < nums.length; i++)
	        b[i / len] += nums[i];
	}

	public int sumRangeIII(int i, int j) {
	    int sum = 0;
	    int startBlock = i / len;
	    int endBlock = j / len;
	    if (startBlock == endBlock) {
	        for (int k = i; k <= j; k++)
	            sum += nums[k];
	    } else {
	        for (int k = i; k <= (startBlock + 1) * len - 1; k++)
	            sum += nums[k];
	        for (int k = startBlock + 1; k <= endBlock - 1; k++)
	            sum += b[k];
	        for (int k = endBlock * len; k <= j; k++)
	            sum += nums[k];
	    }
	    return sum;
	}

	public void update(int i, int val) {
	    int b_l = i / len;
	    b[b_l] = b[b_l] - nums[i] + val;
	    nums[i] = val;
	}
}
