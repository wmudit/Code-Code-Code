package Misc;

public class IslandCount {

	static void dfs(int[][] m, boolean[][] visited, int i, int j) {
		if (i >= m.length || i < 0 || j >= m[0].length || j < 0)
			return;
		if (m[i][j] == 1 && visited[i][j] == false) {
			// System.out.println(i + " " + j);
			visited[i][j] = true;
			dfs(m, visited, i + 1, j);
			dfs(m, visited, i - 1, j);
			dfs(m, visited, i, j + 1);
			dfs(m, visited, i, j - 1);
		}
	}

	static int getNumberOfIslands(int[][] binaryMatrix) {
		int count = 0;
		boolean[][] visited = new boolean[binaryMatrix.length][binaryMatrix[0].length];
		for (int i = 0; i < binaryMatrix.length; i++) {
			for (int j = 0; j < binaryMatrix[0].length; j++) {
				if (binaryMatrix[i][j] == 1 && visited[i][j] == false) {
					// visited[i][j] = true;
					dfs(binaryMatrix, visited, i, j);
					count++;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
	    /*int[][] input = {
	      {0,    1,    0,    1,    0},
	      {0,    0,    1,    1,    1},
	      {1,    0,    0,    1,    0},
	      {0,    1,    1,    0,    0},
	      {1,    0,    1,    0,    1}
	    };*/
	    int[][] input = {{1,0,1,0}};
	    System.out.println(getNumberOfIslands(input));
	  }
}
