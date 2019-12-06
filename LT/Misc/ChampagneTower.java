package Misc;

public class ChampagneTower {

	public static double champagneTower(int poured, int query_row, int query_glass) {
		double res = 0;
		int[] sum = new int[101];
		for(int i = 1; i <= 100; i++)
			sum[i] = sum[i - 1] + i;
		/*
		for(int i : sum)
			System.out.print(i + " ");*/
		
		int low = 0, high = 100, idx = 0;
		while(low < high) {
			int mid = low + (high - low) / 2;
			if(sum[mid] == poured) {
				idx = mid;
				break;
			} else if(sum[mid] > poured)
				high = mid;
			else
				low = mid + 1;
		}
		
		if(idx == 0)
			idx = low;
		
		int remaining = poured - sum[idx - 1];
		int flow = 2 * (idx - 1);
		res = (double) remaining / flow;
		if(query_glass == 0 || query_glass == query_row)
			return res;
		else
			return res * 2;
	}
	
	public static void main(String[] args) {
		double a = champagneTower(7, 3, 0); 
		System.out.println(a);
	}
	
}
