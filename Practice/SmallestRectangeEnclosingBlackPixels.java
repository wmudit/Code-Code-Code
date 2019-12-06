
public class SmallestRectangeEnclosingBlackPixels {

	private int top;
	private int bottom;
	private int left;
	private int right;
	private int area = 0;

	public int minArea(char[][] image, int x, int y) {
		if (image == null || image.length == 0) {
			return 0;
		}
		this.top = y;
		this.bottom = y;
		this.left = x;
		this.right = x;
		int m = image.length;
		int n = image[0].length;
		boolean[][] visited = new boolean[m][n];
		minAreaHelper(image, x, y, visited);
		return area;
	}

	private void minAreaHelper(char[][] image, int x, int y, boolean[][] visited) {
		int m = image.length;
		int n = image[0].length;
		if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) {
			return;
		}
		if (image[x][y] == '0') {
			return;
		}

		visited[x][y] = true;

		top = Math.min(top, y);
		bottom = Math.max(bottom, y);
		left = Math.min(left, x);
		right = Math.max(right, x);

		int curArea = (bottom - top + 1) * (right - left + 1);
		area = Math.max(area, curArea);

		minAreaHelper(image, x, y - 1, visited);
		minAreaHelper(image, x, y + 1, visited);
		minAreaHelper(image, x - 1, y, visited);
		minAreaHelper(image, x + 1, y, visited);
	}

}
