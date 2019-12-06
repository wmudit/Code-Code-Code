package Array;

public class TrappingRainWater {
	
	public static int trap(int[] height) {
		int left = 0, right = height.length - 1, ans = 0;
		int leftMax = height[0], rightMax = height[right];
		while(left < right) {
			if(height[left] < height[right]) {
				if(height[left] > leftMax)
					leftMax = height[left];
				else {
					ans += leftMax - height[left];
				}
				left++;
			} else {
				if(height[right] > rightMax)
					rightMax = height[right];
				else {
					ans += rightMax - height[right];
				}
				right--;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] h = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(h));
	}

}
