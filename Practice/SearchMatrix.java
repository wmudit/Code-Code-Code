
/* Use binary search.
 * n * m matrix convert to an array => matrix[x][y] => a[x * m + y]
 * an array convert to n * m matrix => a[x] =>matrix[x / m][x % m]
 */

public class SearchMatrix {

	/*
	 * Integers in each row are sorted from left to right The first integer of each
	 * row is greater than the last integer of the previous row
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		int n = matrix.length;
		int m = matrix[0].length;
		int l = 0, r = m * n - 1;
		while (l != r) {
			int mid = (l + r - 1) >> 1;
			if (matrix[mid / m][mid % m] < target)
				l = mid + 1;
			else
				r = mid;
		}
		return matrix[r / m][r % m] == target;
	}

	/*
	 * Integers in each row are sorted in ascending from left to right. Integers in
	 * each column are sorted in ascending from top to bottom.
	 */
	public boolean searchMatrixII(int[][] matrix, int target) {
		if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
			return false;
		}
		int col = matrix[0].length - 1;
		int row = 0;
		while (col >= 0 && row <= matrix.length - 1) {
			if (target == matrix[row][col]) {
				return true;
			} else if (target < matrix[row][col]) {
				col--;
			} else if (target > matrix[row][col]) {
				row++;
			}
		}
		return false;
	}
}
