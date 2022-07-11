package leetcode.blind;

// Largest Sum Continuous SubArray
public class KadensAlgorithm {

    public static void main(String[] args) {
        int[] arr1 = {-1, 8, -7, 6, 9, 5, -1, 3};
        int[] arr2 = {-2, -3, 4, -1, -2, 1, 5, -3};
        int[] arr3 = {-2, -3, -10, -2, -3};
        System.out.println(getSum(arr1));
        System.out.println(getSum(arr2));
        System.out.println(getSum(arr3));
    }

    private static int getSum(int[] array) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int j : array) {
            currentSum += j;
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }
}
