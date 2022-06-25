package leetcode.blind;

import java.util.HashSet;

public class TwoSumUnSortedArray {

    public static void main(String[] args) {
        int[] a = {8, 0, 2, 7, 15, 11};
        int targetSum = 15;
        boolean res = findTwoSumUnSortedArray(a, targetSum);
        System.out.println(res);
    }

    private static Boolean findTwoSumUnSortedArray(int[] arr, int targetSum) {
        HashSet<Integer> hashSet = new HashSet<>();
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            if (hashSet.contains(arr[left])) {
                return true;
            } else hashSet.add(targetSum - arr[left]);
            left++;
        }
        return false;
    }
}
