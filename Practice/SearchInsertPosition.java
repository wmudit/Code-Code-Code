
public class SearchInsertPosition {

	int searchInsert(int[] nums, int target) {
		int mid, low = 0, high = nums.length;
		while(low<high) {
			mid=low+(high-low)/2; // low<=mid, mid<high
			if (nums[mid]>=target) high=mid; // high always decreases (even high-low==1)
			else low=mid+1; // low always increases
		}
		return low;
	}
}
