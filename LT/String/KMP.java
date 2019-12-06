package String;

public class KMP {
	
	public static void lpsArray(String p, int[] lps) {
		int len = 0, i = 1;
		lps[0] = 0;
		while(i < p.length()) {
			if(p.charAt(i) == p.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if(len != 0) 
					len = lps[len - 1];
				else {
					lps[i] = len;
					i++;
				}
			}
		}
	}
	
	public static void lps(String t, String p) {
		int[] l = new int[p.length()];
		lpsArray(p, l);
		int i = 0, j = 0;
		while(i < t.length()) {
			if(t.charAt(i) == p.charAt(j)) {
				i++;
				j++;
			}
			if(j == p.length()) {
				System.out.println("Pattern found at " + (i - j));
				j = l[j - 1];
			}
			else if(i < t.length() && t.charAt(i) != p.charAt(j)) {
				if(j != 0)
					j = l[j - 1];
				else
					i++;
			}
		}
	}
	
	public static void main(String[] args) {
		lps("ABABDABACDABABCABAB", "ABABCABAB");
	}
	
}
