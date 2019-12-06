
public class EliminationGame {

	/*
	 * Input: n = 9, 
	 * 1 2 3 4 5 6 7 8 9 
	 * 2 4 6 8 
	 * 2 6 
	 * 6
	 * 
	 * Output: 6
	 */
	
	public int lastRemaining(int n) {
		boolean left = true;
		int remaining = n;
		int step = 1;
		int head = 1;
		while (remaining > 1) {
			if (left || remaining % 2 == 1) {
				head = head + step;
			}
			remaining = remaining / 2;
			step = step * 2;
			left = !left;
		}
		return head;
	}

}
