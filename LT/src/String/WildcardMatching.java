package String;

public class WildcardMatching {

	boolean comparison(String str, String pattern) {
		int s = 0, p = 0, match = 0, starIdx = -1;
		while (s < str.length()) {
			// advancing both pointers
			if (p < pattern.length() && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))) {
				s++;
				p++;
			}
			// * found, only advancing pattern pointer
			else if (p < pattern.length() && pattern.charAt(p) == '*') {
				starIdx = p;
				match = s;
				p++;
			}
			// last pattern pointer was *, advancing string pointer
			else if (starIdx != -1) {
				p = starIdx + 1;
				match++;
				s = match;
			}
			// current pattern pointer is not star, last patter pointer was not *
			// characters do not match
			else
				return false;
		}

		// check for remaining characters in pattern
		while (p < pattern.length() && pattern.charAt(p) == '*')
			p++;

		return p == pattern.length();
	}

	public static boolean isMatch(String s, String p) {
		boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
		match[s.length()][p.length()] = true;
		for (int i = p.length() - 1; i >= 0; i--) {
			if (p.charAt(i) != '*')
				break;
			else
				match[s.length()][i] = true;
		}
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = p.length() - 1; j >= 0; j--) {
				if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
					match[i][j] = match[i + 1][j + 1];
				else if (p.charAt(j) == '*')
					match[i][j] = match[i + 1][j] || match[i][j + 1];
				else
					match[i][j] = false;
			}
		}
		return match[0][0];
	}
	
	public static boolean isMatch1(String s, String p) {
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();

        //replace multiple * with one *
        //e.g a**b***c --> a*b*c
        int writeIndex = 0;
        boolean isFirst = true;
        for ( int i = 0 ; i < pattern.length; i++) {
            if (pattern[i] == '*') {
                if (isFirst) {
                    pattern[writeIndex++] = pattern[i];
                    isFirst = false;
                }
            } else {
                pattern[writeIndex++] = pattern[i];
                isFirst = true;
            }
        }

        boolean T[][] = new boolean[str.length + 1][writeIndex + 1];

        if (writeIndex > 0 && pattern[0] == '*') {
            T[0][1] = true;
        }

        T[0][0] = true;

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (pattern[j-1] == '?' || str[i-1] == pattern[j-1]) {
                    T[i][j] = T[i-1][j-1];
                } else if (pattern[j-1] == '*'){
                    T[i][j] = T[i-1][j] || T[i][j-1];
                }
            }
        }

        return T[str.length][writeIndex];
	}

	public static void main(String[] args) {
		System.out.println(isMatch1("ho", "*ho"));
	}

}
