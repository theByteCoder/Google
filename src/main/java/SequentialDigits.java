import java.util.ArrayList;
import java.util.Arrays;

public class SequentialDigits {

    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        int low = 100;
        int high = 300;

        while (low <= high) {
            getSequentialNumber(low);
            low++;
        }
        System.out.println(Arrays.toString(arrayList.toArray()));
    }

    private static void getSequentialNumber(int num) {
        int[] arr = new int[String.valueOf(num).length()];
        int idx = 0;
        int original = num;
        while (num > 0) {
            arr[idx++] = num % 10;
            num = num / 10;
        }
        isSequential(original, arr);
    }

    private static void isSequential(int original, int[] numArr) {
        boolean res = true;
        for (int counter = numArr.length - 1; counter > 0; counter--) {
            int curr = numArr[counter];
            int next = numArr[counter - 1];
            if (curr + 1 != next) {
                res = false;
                break;
            }
        }
        if (res) arrayList.add(original);
    }

}
