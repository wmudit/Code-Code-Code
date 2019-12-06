
public class MaximumProductOfWordLengths {

	/*
	 * Each integer in an array is of size 32 bits long(which is >26). So in short
	 * we are just setting every bit of an integer. So for example “abcw”: set
	 * 0,1,2,23 bit. (1<<(‘a’-‘a’)) = 1<<0 which is 1, (1<<(‘w’-‘a’))==2^23 and so
	 * on
	 */
	
	public static int maxProduct(String[] words) {
		if (words == null || words.length == 0)
			return 0;
		int len = words.length;
		int[] value = new int[len];
		for (int i = 0; i < len; i++) {
			String tmp = words[i];
			value[i] = 0;
			for (int j = 0; j < tmp.length(); j++) {
				value[i] |= 1 << (tmp.charAt(j) - 'a');
			}
		}
		int maxProduct = 0;
		for (int i = 0; i < len; i++)
			for (int j = i + 1; j < len; j++) {
				if ((value[i] & value[j]) == 0 && (words[i].length() * words[j].length() > maxProduct))
					maxProduct = words[i].length() * words[j].length();
			}
		return maxProduct;
	}

}
