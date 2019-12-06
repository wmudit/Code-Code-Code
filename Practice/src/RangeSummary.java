import java.util.*;

public class RangeSummary {

	public List<String> summaryRanges(int nums[]) {
		List<String> list = new ArrayList<String>();
		if (nums.length == 1) {
			list.add(nums[0] + "");
			return list;
		}
		for (int i = 0; i < nums.length; i++) {
			int a = nums[i];
			while (i + 1 < nums.length && (nums[i + 1] - nums[i]) == 1) {
				i++;
			}
			if (a != nums[i]) {
				list.add(a + "->" + nums[i]);
			} else {
				list.add(a + "");
			}
		}
		return list;
	}

	public class SummaryRanges {

		public class Interval {
			int start;
			int end;

			Interval() {
				start = 0;
				end = 0;
			}

			Interval(int s, int e) {
				start = s;
				end = e;
			}
		}

		TreeMap<Integer, Interval> tree;

		public SummaryRanges() {
			tree = new TreeMap<>();
		}

		public void addNum(int val) {
			if (tree.containsKey(val))
				return;
			Integer l = tree.lowerKey(val);
			Integer h = tree.higherKey(val);
			if (l != null && h != null && tree.get(l).end + 1 == val && h == val + 1) {
				tree.get(l).end = tree.get(h).end;
				tree.remove(h);
			} else if (l != null && tree.get(l).end + 1 >= val) {
				tree.get(l).end = Math.max(tree.get(l).end, val);
			} else if (h != null && h == val + 1) {
				tree.put(val, new Interval(val, tree.get(h).end));
				tree.remove(h);
			} else {
				tree.put(val, new Interval(val, val));
			}
		}

		public List<Interval> getIntervals() {
			return new ArrayList<>(tree.values());
		}
	}
}
