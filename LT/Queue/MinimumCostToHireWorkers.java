package Queue;

import java.util.*;

public class MinimumCostToHireWorkers {

	public static double mincostToHireWorkers(int[] q, int[] w, int K) {
		double[][] workers = new double[q.length][2];
		for (int i = 0; i < q.length; ++i)
			workers[i] = new double[] { (double) (w[i]) / q[i], (double) q[i] };
		Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
		double res = Double.MAX_VALUE, qsum = 0;
		PriorityQueue<Double> pq = new PriorityQueue<>();
		for (double[] worker : workers) {
			qsum += worker[1];
			pq.add(-worker[1]);
			if (pq.size() > K)
				qsum += pq.poll();
			if (pq.size() == K)
				res = Math.min(res, qsum * worker[0]);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(mincostToHireWorkers(new int[] { 10, 20, 5 }, new int[] { 70, 50, 30 }, 2));
		System.out.println(mincostToHireWorkers(new int[] { 3, 1, 10, 10, 1 }, new int[] { 4, 8, 2, 2, 7 }, 3));
	}

}
