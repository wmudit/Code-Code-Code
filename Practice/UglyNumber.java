import java.util.*;

/* Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
 * For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7 */

public class UglyNumber {

	public boolean isUgly(int num) {
		for (int i = 2; i < 6 && num > 0; i++)
			while (num % i == 0)
				num /= i;
		return num == 1;
	}

	/*
	 * We have an array k of first n ugly number. We only know, at the beginning,
	 * the first one, which is 1. Then k[1] = min( k[0]x2, k[0]x3, k[0]x5). The
	 * answer is k[0]x2. So we move 2’s pointer to 1. Then we test: k[2] = min(
	 * k[1]x2, k[0]x3, k[0]x5). And so on. Be careful about the cases such as 6, in
	 * which we need to forward both pointers of 2 and 3.
	 */

	int nthUglyNumber(int n) {
		if (n <= 0)
			return -1; // get rid of corner cases
		if (n == 1)
			return 1; // base case
		int t2 = 0, t3 = 0, t5 = 0; // pointers for 2, 3, 5
		int[] k = new int[n];
		k[0] = 1;
		for (int i = 1; i < n; i++) {
			k[i] = Math.min(k[t2] * 2, Math.min(k[t3] * 3, k[t5] * 5));
			if (k[i] == k[t2] * 2)
				t2++;
			if (k[i] == k[t3] * 3)
				t3++;
			if (k[i] == k[t5] * 5)
				t5++;
		}
		return k[n - 1];
	}

	// Super ugly number
	public int nthSuperUglyNumber(int n, int[] primes) {
		int[] ugly = new int[n];
		int[] idx = new int[primes.length];
		int[] val = new int[primes.length];
		Arrays.fill(val, 1);

		int next = 1;
		for (int i = 0; i < n; i++) {
			ugly[i] = next;

			next = Integer.MAX_VALUE;
			for (int j = 0; j < primes.length; j++) {
				// skip duplicate and avoid extra multiplication
				if (val[j] == ugly[i])
					val[j] = ugly[idx[j]++] * primes[j];
				// find next ugly number
				next = Math.min(next, val[j]);
			}
		}

		return ugly[n - 1];
	}

}
