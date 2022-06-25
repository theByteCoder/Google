package leetcode.blind;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumUnSortedArray {

    public static void main(String[] args) {
        int[] a = {8, 0, 2, 7, 15, 11};
        int targetSum = 15;
        int[] res = findTwoSumUnSortedArray(a, targetSum);
        System.out.println(Arrays.toString(res));
    }

    public static int[] findTwoSumUnSortedArray(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        int[] res = new int[2];
        HashMap<Integer, Integer> complementMap = new HashMap<>();

        while (left < right) {
            int item = nums[left];
            if (complementMap.containsKey(item)) {
                int indexOfComplement = complementMap.get(item);
                res[0] = left;
                res[1] = indexOfComplement;
                break;
            } else {
                int complementMapKey = target - nums[left];
                int indexOfComplement = left;
                complementMap.put(complementMapKey, indexOfComplement);
            }
            left++;
        }
        return res;
    }
}
