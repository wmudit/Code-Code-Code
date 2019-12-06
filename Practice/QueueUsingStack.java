import java.util.*;

public class QueueUsingStack {

	private int front;
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();

	// Push - O(n) Pop - O(1)
	public void push(int x) {
		if (s1.empty())
			front = x;
		while (!s1.isEmpty())
			s2.push(s1.pop());
		s2.push(x);
		while (!s2.isEmpty())
			s1.push(s2.pop());
	}

	public void pop() {
		s1.pop();
		if (!s1.empty())
			front = s1.peek();
	}

	public int peek() {
		return front;
	}

	public boolean empty() {
		return s1.isEmpty();
	}

}
