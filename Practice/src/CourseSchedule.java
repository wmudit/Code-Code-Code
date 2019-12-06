
// Equivalent to doing Topological sorting

import java.util.*;

public class CourseSchedule {

	public boolean canFinish(int num, int[][] prereq) {
		List<Integer>[] adj = new List[num];
		int[] indegree = new int[num];
		for (int i = 0; i < num; i++)
			adj[i] = new ArrayList<>();
		for (int[] req : prereq) {
			adj[req[1]].add(req[0]);
			indegree[req[0]]++;
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < num; i++)
			if (indegree[i] == 0)
				q.offer(i);

		int cnt = 0;
		for (; !q.isEmpty(); cnt++)
			for (int crs : adj[q.poll()])
				if (--indegree[crs] == 0)
					q.offer(crs);
		return cnt == num;
	}

}
