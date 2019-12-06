import java.util.*;

public class Calculator {

	public int calculate(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int result = 0;
		int number = 0;
		int sign = 1;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				number = 10 * number + (int) (c - '0');
			} else if (c == '+') {
				result += sign * number;
				number = 0;
				sign = 1;
			} else if (c == '-') {
				result += sign * number;
				number = 0;
				sign = -1;
			} else if (c == '(') {
				// we push the result first, then sign;
				stack.push(result);
				stack.push(sign);
				// reset the sign and result for the value in the parenthesis
				sign = 1;
				result = 0;
			} else if (c == ')') {
				result += sign * number;
				number = 0;
				result *= stack.pop(); // stack.pop() is the sign before the parenthesis
				result += stack.pop(); // stack.pop() now is the result calculated before the parenthesis

			}
		}
		if (number != 0)
			result += sign * number;
		return result;
	}

	public int calculateII(String s) {
		int len;
		if (s == null || (len = s.length()) == 0)
			return 0;
		Stack<Integer> stack = new Stack<Integer>();
		int num = 0;
		char sign = '+';
		for (int i = 0; i < len; i++) {
			if (Character.isDigit(s.charAt(i))) {
				num = num * 10 + s.charAt(i) - '0';
			}
			if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == len - 1) {
				if (sign == '-') {
					stack.push(-num);
				}
				if (sign == '+') {
					stack.push(num);
				}
				if (sign == '*') {
					stack.push(stack.pop() * num);
				}
				if (sign == '/') {
					stack.push(stack.pop() / num);
				}
				sign = s.charAt(i);
				num = 0;
			}
		}

		int result = 0;
		for (int i : stack) {
			result += i;
		}
		return result;
	}

}
