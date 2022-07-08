package algorithm;

public class MaxMinWhichIsDivisibleByKInArray {


    public static void main(String[] args) {
        int[] arr = {10, 1230, 45, 67, 1};
        int k = 5;

        System.out.println(findMax(arr, k));
        System.out.println(findMin(arr, k));
    }

    public static int findMax(int[] array, int k) {
        int res = Integer.MIN_VALUE;

        for (int a : array) {
            if (a % k == 0) {
                res = Math.max(res, a);
            }
        }
        return res;
    }

    public static int findMin(int[] array, int k) {
        int res = Integer.MAX_VALUE;
        for (int a : array) {
            if (a % k == 0) {
                res = Math.min(res, a);
            }
        }
        return res;
    }
}
