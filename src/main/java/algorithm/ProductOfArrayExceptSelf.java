package algorithm;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] a = {2, 6, 0, 4};
        System.out.println(Arrays.toString(productExceptSelf(a)));
    }

    public static int[] productExceptSelf(int[] arr) {
        int length = arr.length;
        int[] res = new int[length];
        int product = 1;
        for (int i = 0; i < length; i++) {
            product *= arr[i];
            res[i] = product;
        }
        product = 1;
        for (int i = length - 1; i > 0; i--) {
            res[i] = res[i - 1] * product;
            product *= arr[i];
        }
        res[0] = product;
        return res;
    }
}
