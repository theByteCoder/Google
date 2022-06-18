package algorithm;

import java.util.Arrays;
import java.util.logging.Logger;

public class MergeSort {

    public static void main(String[] args) {

        Logger logger = Logger.getLogger(MergeSort.class.getName());
        int[] arr = {12, 11, 13, 5, 6, 7, 9, 0, 1, 2, 12};

        sort(arr, 0, arr.length - 1);

        String res = Arrays.toString(arr);

        logger.info(res);
    }

    static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2; // find the middle point
            sort(arr, left, mid); // sort first halve
            sort(arr, mid + 1, right); // sort second halve
            merge(arr, left, mid, right); // merge the sorted halves
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        // Find sizes of two sub-arrays to be merged
        int leftSubArraySize = mid - left + 1;
        int rightSubArraySize = right - mid;

        /* Create temp arrays */
        int[] leftArray = new int[leftSubArraySize];
        int[] rightArray = new int[rightSubArraySize];

        /*Copy data to temp arrays*/
        System.arraycopy(arr, left, leftArray, 0, leftSubArraySize);

        System.arraycopy(arr, mid + 1, rightArray, 0, rightSubArraySize);

        /* Merge the temp arrays */
        // Initial indexes of first and second sub-arrays
        int i = 0;
        int j = 0;

        // Initial index of merged sub-array array
        int k = left;

        while (i < leftSubArraySize && j < rightSubArraySize) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < leftSubArraySize) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < rightSubArraySize) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}