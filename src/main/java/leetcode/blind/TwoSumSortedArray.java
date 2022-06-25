package leetcode.blind;

import java.util.Arrays;

public class TwoSumSortedArray {

    public static void main(String[] args) {
        int[] a = {0, 2, 7, 11, 15};
        int targetSum = 15;
        int[] res = findTwoSumSortedArray(a, targetSum);
        System.out.println(Arrays.toString(res));
    }

    private static int[] findTwoSumSortedArray(int[] arr, int targetSum) {
        int[] res = new int[2];
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == targetSum) {
                res[0] = left;
                res[1] = right;
                break;
            } else if (sum < targetSum) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
