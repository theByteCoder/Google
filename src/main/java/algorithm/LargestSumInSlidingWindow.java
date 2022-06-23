package algorithm;

import java.util.Map;
import java.util.logging.Logger;

public class LargestSumInSlidingWindow {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(LargestSumInSlidingWindow.class.getName());
        int[] arr = {0, 1, 1, 1, 0};
        int k = 3;
        String res = String.valueOf(findMaxSumInSubArray(arr, k));
        logger.info(res);
    }

    private static Map<String, Integer> findMaxSumInSubArray(int[] array, int kTerm) {
        int length = array.length;
        int maxSum = 0;
        int minSum = -1;
        if (kTerm < length) {
            for (int i = 0; i < kTerm; i++) {
                maxSum += array[i];
            }
            int windowSum = maxSum;
            for (int j = kTerm; j < length; j++) {
                int next = array[j];
                int prev = array[j - kTerm];
                windowSum += next - prev;
                maxSum = Math.max(windowSum, maxSum);
                minSum = Math.min(windowSum, maxSum);
            }
        }
        return Map.ofEntries(Map.entry("maxSum", maxSum), Map.entry("minSum", minSum));
    }
}
