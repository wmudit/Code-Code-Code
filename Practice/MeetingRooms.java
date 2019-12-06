
/*Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] 
 * (si < ei), determine if a person could attend all meetings. */
import java.util.*;

public class MeetingRooms {

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

	public boolean canAttendMeetings(Interval[] intervals) {

		if (intervals == null || intervals.length == 0) {
			return true;
		}

		// Sort according to the start time
		Arrays.sort(intervals, new IntervalComparator());

		Interval prev = intervals[0];
		for (int i = 1; i < intervals.length; i++) {
			Interval curr = intervals[i];
			if (isOverlapped(prev, curr)) {
				return false;
			}
			prev = curr;
		}

		return true;
	}

	public class IntervalComparator implements Comparator<Interval> {
		public int compare(Interval a, Interval b) {
			return a.start - b.start;
		}
	}

	private boolean isOverlapped(Interval a, Interval b) {
		return a.end > b.start;
	}

	//Minimum number of meeting rooms required
	public int minMeetingRooms(Interval[] intervals) {
		int n = intervals.length;
		Arrays.sort(intervals, new IntervalComparator());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			if (i > 0 && intervals[i].start >= pq.peek())
				pq.poll();
			pq.add(intervals[i].end);
		}
		return pq.size();
	}

}
