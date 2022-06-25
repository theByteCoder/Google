package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DuplicatesInArray {

    public static void main(String[] args) {
        int[] a = {11, 5, 89, 3, 4, 8, 6, 7, 8, 5, 11};
        ArrayList<Integer> res = findDuplicates(a);
        System.out.println(Arrays.toString(res.toArray()));
    }

    private static ArrayList<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int itemLeft = arr[left];
            int itemRight = arr[right];

            // if left item present in hashmap
            if (hashMap.containsKey(itemLeft)) {
                int itemVal = hashMap.get(itemLeft) + 1;
                hashMap.put(itemLeft, itemVal);
            } else hashMap.put(itemLeft, 1);

            // if right item present in hashmap
            if (hashMap.containsKey(itemRight)) {
                int itemVal = hashMap.get(itemRight) + 1;
                hashMap.put(itemRight, itemVal);
            } else hashMap.put(itemRight, 1);

            left++;
            right--;
        }
        for (Map.Entry<Integer, Integer> pair : hashMap.entrySet()) {
            if (pair.getValue() > 1) {
                res.add(pair.getKey());
            }
        }
        return res;
    }
}
