package Hard;

import java.util.*;

public class TrappingRainWater {

	public static int trap(int[] height) {
        int ans = 0, curr = 0;
        Stack<Integer> s = new Stack<>();
        while(curr < height.length) {
            while(!s.isEmpty() && height[curr] > height[s.peek()]) {
                int top = s.pop();
                if(s.isEmpty())
                    break;
                int distance = curr - s.peek() - 1;
                int ht = Math.min(height[curr], height[s.peek()]) - height[top];
                ans += distance * ht;
            }
            s.push(curr++);
        }
        return ans;
    }
	
	public static void main(String[] args) {
		int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(input));
	}
	
}
