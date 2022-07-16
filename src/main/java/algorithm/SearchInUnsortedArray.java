package algorithm;

public class SearchInUnsortedArray {

    public static void main(String[] args) {
        int[] arr = {4, 6, 1, 5, 8};
        int t1 = 5;
        int t2 = 0;
        int t3 = 4;
        System.out.println(new SearchInUnsortedArray().search(arr, t1));
        System.out.println(new SearchInUnsortedArray().search(arr, t2));
        System.out.println(new SearchInUnsortedArray().search(arr, t3));
    }

    private int search(int[] array, int target) {
        int len = array.length;
        if (array[len - 1] == target) return len - 1;
        int temp = array[len - 1];
        array[len - 1] = target;

        for (int i = 0; ; i++) {
            if (array[i] == target) {
                array[len - 1] = temp;

                if (i < len - 1) return i;

                return -1;
            }
        }
    }
}
