
public class WiggleSort {

	void swap(int arr[], int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	void wiggleSort(int arr[], int n) {
		for (int i = 0; i < n; i += 2) {
			// If current even element is smaller
			// than previous
			if (i > 0 && arr[i - 1] > arr[i])
				swap(arr, i - 1, i);

			// If current even element is smaller
			// than next
			if (i < n - 1 && arr[i] < arr[i + 1])
				swap(arr, i, i + 1);
		}
	}

}
