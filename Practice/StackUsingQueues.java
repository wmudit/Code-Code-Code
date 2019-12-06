import java.util.*;

public class StackUsingQueues {

	private Queue<Integer> q1 = new LinkedList<>();
	private Queue<Integer> q2 = new LinkedList<>();
	private int top;

	public boolean empty() {
		return q1.isEmpty();
	}

	// push - O(1), pop O(n)
	public void push(int x) {
		q1.add(x);
		top = x;
	}

	public void pop() {
		while (q1.size() > 1) {
			top = q1.remove();
			q2.add(top);
		}
		q1.remove();
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
	}

	// push - O(n), pop O(1)
	public void pushI(int x) {
		q2.add(x);
		top = x;
		while (!q1.isEmpty()) {
			q2.add(q1.remove());
		}
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
	}

	public void popI() {
		q1.remove();
		if (!q1.isEmpty()) {
			top = q1.peek();
		}
	}

	// Using 1 Queue Push - O(n) Pop - O(1)
	public void pushII(int x) {
		q1.add(x);
		int sz = q1.size();
		while (sz > 1) {
			q1.add(q1.remove());
			sz--;
		}
	}

	public void popII() {
		q1.remove();
	}

}
