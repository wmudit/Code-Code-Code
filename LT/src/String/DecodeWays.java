package String;

public class DecodeWays {
	
	public static int numDecodings(String s) {
        // int[i] M represents the total number of way to decode s.substring(i)
        int[] M = new int[s.length() + 1];
        char[] array = s.toCharArray();
        // M[i] = for (i-2 -> i - 1) M[j] + if right is a complete word, ie -'A' = 0-25
        M[0] = 1;
        M[1] = array[0]  != '0' ? 1: 0;
        for (int i = 2; i < M.length; i++) {
            int first = (array[i-2] - '0')*10 + (array[i-1] - '0');
            if (first >= 10 && first <= 26) {
                M[i] += M[i - 2];
            }
            int second = array[i-1] - '0';
            if (second != 0) {
                M[i] += M[i - 1];
            }
        }
        return M[M.length - 1];
    }
	
	public static void main(String[] args) {
		System.out.println((char) 97);
	}

}
