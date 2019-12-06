
public class HIndex {

	public int hIndex(int[] citations) {
		int length = citations.length;
		if (length == 0) {
			return 0;
		}

		int[] array2 = new int[length + 1];
		for (int i = 0; i < length; i++) {
			if (citations[i] > length) {
				array2[length] += 1;
			} else {
				array2[citations[i]] += 1;
			}
		}
		int t = 0;
		int result = 0;

		for (int i = length; i >= 0; i--) {
			t = t + array2[i];
			if (t >= i) {
				return i;
			}
		}
		return 0;
	}

	// Citations array is sorted in ascending order
	int hIndexII(int[] citations) {
		int left = 0, len = citations.length, right = len - 1, mid;
		while (left <= right) {
			mid = (left + right) >> 1;
			if (citations[mid] == (len - mid))
				return citations[mid];
			else if (citations[mid] > (len - mid))
				right = mid - 1;
			else
				left = mid + 1;
		}
		return len - (right + 1);
	}
}
