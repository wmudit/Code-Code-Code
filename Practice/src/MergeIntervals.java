import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

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

	private class IntervalComparator implements Comparator<Interval> {
		public int compare(Interval a, Interval b) {
			return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
		}
	}

	public List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, new IntervalComparator());

		LinkedList<Interval> merged = new LinkedList<Interval>();
		for (Interval interval : intervals) {
			// if the list of merged intervals is empty or if the current
			// interval does not overlap with the previous, simply append it.
			if (merged.isEmpty() || merged.getLast().end < interval.start) {
				merged.add(interval);
			}
			// otherwise, there is overlap, so we merge the current and previous
			// intervals.
			else {
				merged.getLast().end = Math.max(merged.getLast().end, interval.end);
			}
		}
		return merged;
	}

	//Insert and Merge
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new LinkedList<>();
		int i = 0;
		// add all the intervals ending before newInterval starts
		while (i < intervals.size() && intervals.get(i).end < newInterval.start)
			result.add(intervals.get(i++));
		// merge all overlapping intervals to one considering newInterval
		while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
			newInterval = new Interval( // we could mutate newInterval here also
					Math.min(newInterval.start, intervals.get(i).start),
					Math.max(newInterval.end, intervals.get(i).end));
			i++;
		}
		result.add(newInterval); // add the union of intervals we got
		// add all the rest
		while (i < intervals.size())
			result.add(intervals.get(i++));
		return result;
	}

	// Inserting without extra memory
	public List<Interval> insert1(List<Interval> intervals, Interval newInterval) {
        int i=0;
        while(i<intervals.size() && intervals.get(i).end<newInterval.start) i++;
        while(i<intervals.size() && intervals.get(i).start<=newInterval.end){
            newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start), Math.max(intervals.get(i).end, newInterval.end));
            intervals.remove(i);
        }
        intervals.add(i,newInterval);
        return intervals;
	}

}
