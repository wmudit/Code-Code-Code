package Array;

public class ArithmeticSlices {

	public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        if(n < 3)
            return 0;
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 2; j < n; j++) {
                if(isValidSlice(A, i, j))
                    count++;
            }
        }
        return count;
    }
    public boolean isValidSlice(int[] A, int start, int end) {
        int diff = A[start + 1] - A[start];
        for(int i = start + 2; i <= end; i++) {
            int d = A[i] - A[i - 1];
            if(d != diff)
                return false;
        }
        return true;
    }
    
    public int numberOfArithmeticSlices1(int[] A) {
        int count = 0;
        int sum = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                count++;
            } else {
                sum += (count + 1) * (count) / 2;
                count = 0;
            }
        }
        return sum += count * (count + 1) / 2;
    }
    public int numberOfArithmeticSlices2(int[] A) {
        int dp = 0;
        int sum = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp = 1 + dp;
                sum += dp;
            } else
                dp = 0;
        }
        return sum;
    }
}
