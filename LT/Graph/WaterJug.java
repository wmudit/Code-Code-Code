package Graph;

import java.util.*;

public class WaterJug {
	
	public static int gcd(int a, int b) {
		while(b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
	
	public static boolean canMeasureWaterGCD(int x, int y, int z) {
		if (x + y < z)
			return false;
		if (x == z || y == z || x + y == z)
			return true;
		return z % gcd(x, y) == 0;
	}
	
	public static boolean canMeasureWater(int x, int y, int z) {
		if (z == 0) {
			return true;
		} else if (z > x + y) {
			return false;
		}
		final Queue<Integer> q = new LinkedList<>();
		final Set<Integer> visited = new HashSet<>();
		int[] options = new int[] { x, y, -x, -y };
		q.offer(0);
		visited.add(0);
		while (!q.isEmpty()) {
			int state = q.poll();
			for (int option : options) {
				int newState = state + option;
				if (newState == z) {
					return true;
				} else if (newState >= 0 && !visited.contains(newState) && newState < x + y) {
					q.offer(newState);
					visited.add(newState);
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(canMeasureWater(2,6,5));
		System.out.println(canMeasureWater(4,3,2));
	}

}
