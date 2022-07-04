package algorithm.slidingwindow;

import java.util.logging.Logger;

public class SlidingWindow {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(SlidingWindow.class.getName());
        int[] arr = {0, 1, 2, 3, 4};
        int k = 2;
        int n = arr.length;
        String res = String.valueOf(maxSum(arr, n, k));
        logger.info(res);
    }

    private static int maxSum(int[] arr, int n, int k) {
        int maxSum = 0;
        if (n > k) {
            // first k terms
            for (int i = 0; i < k; i++) {
                maxSum += arr[i];
            }
            int windowSum = maxSum;
            // from k to n terms
            for (int j = k; j < n; j++) {
                int prev = arr[j - k];
                int next = arr[j];
                windowSum += next - prev;
                maxSum = Math.max(windowSum, maxSum);
            }
        }
        return maxSum;
    }

}