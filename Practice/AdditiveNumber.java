
public class AdditiveNumber {

	private String add(String a, String b) {
		StringBuilder rst = new StringBuilder();
		int i = a.length() - 1, j = b.length() - 1, carry = 0;
		while (i >= 0 || j >= 0 || carry > 0) {
			int sum = carry + (i >= 0 ? a.charAt(i--) - '0' : 0) + (j >= 0 ? b.charAt(j--) - '0' : 0);
			rst.insert(0, sum % 10);
			carry = sum / 10;
		}
		return rst.toString();
	}

	private boolean check(String a, String b, String c) {
		if (a.length() > 1 && a.charAt(0) == '0' || b.length() > 1 && b.charAt(0) == '0')
			return false;
		String sum = add(a, b);
		if (sum.equals(c))
			return true;
		if (c.length() <= sum.length() || !c.substring(0, sum.length()).equals(sum))
			return false;
		return check(b, sum, c.substring(sum.length()));
	}

	public boolean isAdditiveNumber(String num) {
		for (int i = 1; i <= (num.length() >> 1); i++) {
			for (int j = 1; j <= ((num.length() - i) >> 1); j++) {
				if (check(num.substring(0, i), num.substring(i, i + j), num.substring(i + j)))
					return true;
			}
		}
		return false;
	}

}
