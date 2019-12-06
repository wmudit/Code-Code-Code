package Array;

import java.util.*;

public class SortOnlyNonPrimes {

	public static void sieve(boolean[] arr) {
		//int max = arr.length - 1;
		for(int i = 2; i * i < arr.length; i++) {
			if(arr[i] == true) {
				for(int j = i * 2; j < arr.length; j += i)
					arr[j] = false;
			}
		}
	}
	
	public static void sortNonPrimes(int[] arr) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > max)
				max = arr[i];
		}
		boolean[] primes = new boolean[max + 1];
		for(int i = 1; i <= max; i++)
			primes[i] = true;
		primes[1] = false;
		sieve(primes);
		List<Integer> list = new ArrayList<>();
		for(int a : arr) {
			if(primes[a] == false)
				list.add(a);
		}
		Collections.sort(list);
		int idx = 0;
		for(int i = 0; i < arr.length; i++) {
			if(primes[arr[i]])
				continue;
			else {
				arr[i] = list.get(idx);
				idx++;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr1 = {10, 7, 6};
		int[] arr2 = {100, 11, 500, 2, 17, 1};
		sortNonPrimes(arr1);
		sortNonPrimes(arr2);
		for(int a : arr1)
			System.out.print(a + " ");
		System.out.println();
		for(int a : arr2)
			System.out.print(a + " ");
	}
	
}
