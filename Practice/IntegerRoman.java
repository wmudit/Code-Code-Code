
public class IntegerRoman {

	String intToRoman(int num) {
		String M[] = { "", "M", "MM", "MMM" };
		String C[] = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String X[] = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String I[] = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
		return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
	}

	int romanToInt(String s) {
		int sum = 0;
		if (s.indexOf("IV") != -1) {
			sum -= 2;
		}
		if (s.indexOf("IX") != -1) {
			sum -= 2;
		}
		if (s.indexOf("XL") != -1) {
			sum -= 20;
		}
		if (s.indexOf("XC") != -1) {
			sum -= 20;
		}
		if (s.indexOf("CD") != -1) {
			sum -= 200;
		}
		if (s.indexOf("CM") != -1) {
			sum -= 200;
		}

		char c[] = s.toCharArray();
		int count = 0;

		for (; count <= s.length() - 1; count++) {
			if (c[count] == 'M')
				sum += 1000;
			if (c[count] == 'D')
				sum += 500;
			if (c[count] == 'C')
				sum += 100;
			if (c[count] == 'L')
				sum += 50;
			if (c[count] == 'X')
				sum += 10;
			if (c[count] == 'V')
				sum += 5;
			if (c[count] == 'I')
				sum += 1;
		}
		return sum;

	}
}
