
public class CountSquaresInARectangle {

	static int countSquares(int m, int n) {
		// If n is smaller, swap m and n
		if (n < m) {
			// swap(m,n)
			int temp = m;
			m = n;
			n = temp;
		}

		// Now n is greater dimension, apply formula
		return m * (m + 1) * (2 * m + 1) / 6 + (n - m) * m * (m + 1) / 2;
	}

}
