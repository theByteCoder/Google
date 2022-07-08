package algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class AllTripletsInSumZero {

    public static void main(String[] args) {
        int[] arr = {9, 0, -1, 2, -18, -3, 1, 9};
        System.out.println(Arrays.toString(arr));
        System.out.println(findAllTripletsInSumZero(arr));
    }

    private static ArrayList<ArrayList<Integer>> findAllTripletsInSumZero(int[] array) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        for (int counter = 0; counter < array.length; counter++) {
            int left = counter + 1;
            int right = array.length - 1;
            while (left < right) {
                int sum = array[counter] + array[left] + array[right];
                if (sum == 0) {
                    res.add(new ArrayList<>(Arrays.asList(array[counter], array[left], array[right])));
                    break;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
