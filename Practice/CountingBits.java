
public class CountingBits {

	/*Given a non negative integer number num. For every numbers i in the range 
	 * 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return 
	 * them as an array. */
	
	
	/*
	 * Take number X for example, 10011001. Divide it in 2 parts: 
	 * <1>the last digit ( 1 or 0, which is " i&1 ", equivalent to " i%2 " ) 
	 * <2>the other digits ( the number of 1, which is " f[i >> 1] ", equivalent to " f[i/2] " )
	 */
	public int[] countBits(int num) {
		int[] f = new int[num + 1];
		for (int i = 1; i <= num; i++)
			f[i] = f[i >> 1] + (i & 1);
		return f;
	}

}
