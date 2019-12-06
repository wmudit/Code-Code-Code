package Misc;

public class OutOfBoundaryPaths {
	
	static int mod = 1_000_000_007;

	public static int dfs(int n, int m, int N, int i , int j, int steps) {
		int count = 0;
		if(steps <= N && (i >= n || j >= m || i < 0 || j < 0))
			return 1;
		else if(steps >= N && i < n && j < m)
			return 0;
		else {
			count += dfs(n, m, N, i + 1, j, steps + 1) % mod;
			count += dfs(n, m, N, i - 1, j, steps + 1) % mod;
			count += dfs(n, m, N, i, j + 1, steps + 1) % mod;
			count += dfs(n, m, N, i, j - 1, steps + 1) % mod;
		}
		return count;
	}
	
	public static int findPaths(int n, int m, int N, int i, int j) {
		return dfs(n, m, N, i, j, 0);
	}
	
	public static void main(String[] args) {
		System.out.println(findPaths(2,2,2,0,0));
		System.out.println(findPaths(1,3,3,0,1));
	}

}
