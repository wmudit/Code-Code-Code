import java.util.*;

public class KPairsWithSmallestSum {

	/*
	 * You are given two integer arrays nums1 and nums2 sorted in ascending order
	 * and an integer k.
	 * 
	 * Define a pair (u,v) which consists of one element from the first array and
	 * one element from the second array.
	 * 
	 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums
	 */
	
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
		List<int[]> res = new ArrayList<>();
		if (nums1.length == 0 || nums2.length == 0 || k == 0)
			return res;
		for (int i = 0; i < nums1.length && i < k; i++)
			que.offer(new int[] { nums1[i], nums2[0], 0 });
		while (k-- > 0 && !que.isEmpty()) {
			int[] cur = que.poll();
			res.add(new int[] { cur[0], cur[1] });
			if (cur[2] == nums2.length - 1)
				continue;
			que.offer(new int[] { cur[0], nums2[cur[2] + 1], cur[2] + 1 });
		}
		return res;
	}

}
