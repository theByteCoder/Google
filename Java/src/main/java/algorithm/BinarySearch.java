package algorithm;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int left = 0;
        int right = arr.length;
        int target = 3;

        System.out.println(binarySearch(arr, left, right, target));
    }

    private static int binarySearch(int[] arr, int left, int right, int target) {
        while (left < right) {
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
