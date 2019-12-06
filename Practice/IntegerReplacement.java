
public class IntegerReplacement {

	/*If n is even, replace n with n/2
	 * If n is odd, you can replace n with either n + 1 or n - 1 */
	
	public int integerReplacement(int n) {
		int c = 0;
		while (n != 1) {
			if ((n & 1) == 0) {
				n >>>= 1;
			} else if (n == 3 || ((n >>> 1) & 1) == 0) {
				--n;
			} else {
				++n;
			}
			++c;
		}
		return c;
	}

}
