package Array;

import java.util.*;

public class DailyTemperatures {
	
	public static int[] dailyTemperatures(int[] T) {
		int[] res = new int[T.length];
		Stack<Integer> s = new Stack<>();
		for(int i = T.length - 1; i >= 0; i--) {
			while(!s.isEmpty() && T[s.peek()] <= T[i])
				s.pop();
			res[i] = (s.isEmpty()) ? 0 : s.peek() - i;
			s.push(i);
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
		T = dailyTemperatures(T);
		for(int t : T)
			System.out.print(t + " ");
		
	}

}
