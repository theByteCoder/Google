package algorithm.recurssion;

public class RecursiveBinarySearch {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(recursiveBinarySearch(arr, 0, arr.length, 1));
        System.out.println(recursiveBinarySearch(arr, 0, arr.length, 0));
        System.out.println(recursiveBinarySearch(arr, 0, arr.length, 9));
    }

    private static int recursiveBinarySearch(int[] array, int left, int right, int target) {
        if (left > right) return -1;

        int mid = (left + right) / 2;

        if (array[mid] == target) return mid;
        else if (array[mid] < target) left = mid + 1;
        else right = mid - 1;
        return recursiveBinarySearch(array, left, right, target);
    }

}
