package Graph;

import java.util.*;

public class KthSmallestInLexicographicalOrder {
	
	static int count = 0;
	
	public static int KthSmallest(int n, int k) {
		Deque<Integer> q = new LinkedList<>();
		for(int i = 1; i <= 9; i++) {
			if(count + 1 <= k) {
				count++;
				q.offer(i);
				dfs(q, n, k);
			}
		}
		//System.out.println(q);
		return q.peekLast();
	}
	
	public static void dfs(Deque<Integer> q, int n, int k) {
		int last = q.peekLast();
		for(int i = 0; i <= 9; i++) {
			int newNum = last * 10 + i;
			if(newNum <= n && count + 1 <= k) {
				q.offer(newNum);
				count++;
				dfs(q, n, k);
			} else {
				return;
			}
		}
	}
	
	public int findKthNumber(int n, int k) {
        int curr = 1;
        k = k - 1;
        while (k > 0) {
            int steps = calSteps(n, curr, curr + 1);
            if (steps <= k) {
                curr += 1;
                k -= steps;
            } else {
                curr *= 10;
                k -= 1;
            }
        }
        return curr;
    }

    public int calSteps(int n, long n1, long n2) {
        int steps = 0;
        while (n1 <= n) {
            steps += Math.min(n + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return steps;
    }
	 
	public static void main(String[] args) {
		System.out.println(KthSmallest(100, 10));
		//KthSmallest(100, 10);
	}

}
