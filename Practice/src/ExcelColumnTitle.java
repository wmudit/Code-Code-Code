
public class ExcelColumnTitle {

	public String convertToTitle(int n) {
		return n == 0 ? "" : convertToTitle(--n / 26) + (char) ('A' + (n % 26));
	}

	public int titleToNumber(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); result = result * 26 + (s.charAt(i) - 'A' + 1), i++)
			;
		return result;
	}
}
