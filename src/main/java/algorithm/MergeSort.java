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
            int mid = left + (right - left) / 2;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int leftArrSize = mid - left + 1;
        int rightArrSize = right - mid;

        int[] leftArr = new int[leftArrSize];
        int[] rightArr = new int[rightArrSize];

        System.arraycopy(arr, left, leftArr, 0, leftArrSize);
        System.arraycopy(arr, mid + 1, rightArr, 0, rightArrSize);

        int i = 0;
        int j = 0;
        int k = left;

        while (i < leftArrSize && j < rightArrSize) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < leftArrSize) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < rightArrSize) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}