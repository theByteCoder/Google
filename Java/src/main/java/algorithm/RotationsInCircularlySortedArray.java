package algorithm;

import java.util.logging.Logger;

public class RotationsInCircularlySortedArray {

    public static void main(String[] args) {

        Logger logger = Logger.getLogger(RotationsInCircularlySortedArray.class.getName());
        int[] arr = {12, 14, 16, 18, 20, 2, 4, 6, 8, 10};
        String rotationCount = String.valueOf(findRotationCount(arr));
        logger.info(rotationCount);
    }

    private static int findRotationCount(int[] arr) {
        int length = arr.length;
        int left = 0;
        int right = length - 1;

        while (left <= right) {
            if (arr[left] <= arr[right]) {
                return left;
            }
            int mid = left + ((right - left) / 2);
            int next = (mid + 1) % length;
            int prev = (mid - 1 + length) % length;

            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) {
                return mid;
            } else if (arr[mid] <= arr[right]) {
                right = mid - 1;
            } else if (arr[mid] >= arr[left]) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
