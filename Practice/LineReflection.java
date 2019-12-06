import java.util.*;

public class LineReflection {

	public boolean isReflected(int[][] points) {
		if (points == null || points.length < 2)
			return true;

		HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int[] arr : points) {
			min = Math.min(min, arr[0]);
			max = Math.max(max, arr[0]);
			HashSet<Integer> set = map.get(arr[0]);
			if (set == null) {
				set = new HashSet<Integer>();
				map.put(arr[0], set);
			}

			set.add(arr[1]);

		}

		int y = min + max;

		for (int[] arr : points) {
			int left = arr[0];
			int right = y - left;
			if (map.get(right) == null || !map.get(right).contains(arr[1])) {
				return false;
			}
		}

		return true;
	}

}
