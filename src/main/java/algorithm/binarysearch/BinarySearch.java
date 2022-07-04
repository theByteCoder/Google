package algorithm.binarysearch;

import java.util.logging.Logger;

public class BinarySearch {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(BinarySearch.class.getName());
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int left = 0;
        int right = arr.length;
        int target = 3;
        String result = String.valueOf(binarySearch(arr, left, right, target));
        logger.info(result);
    }

    private static int binarySearch(int[] arr, int left, int right, int target) {
        while (left < right ) {
            int mid = (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                left = mid + 1;
            } else if (arr[mid] < target) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
