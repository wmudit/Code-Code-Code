
public class PowerOfFour {

	/*
	 * F = 0x55555555 = 01010101010101010101010101010101 
	 * T = 0x33333333 = 00110011001100110011001100110011 
	 * O = 0x0f0f0f0f = 00001111000011110000111100001111
	 */

	public boolean isPowerOfFour(int num) {
		return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
		// 0x55555555 is to get rid of those power of 2 but not power of 4
		// so that the single 1 bit always appears at the odd position
	}

}
