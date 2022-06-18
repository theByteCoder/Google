package algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class FlatMap {

    public static void main(String[] args) {
        Object[] arr = new Object[]{1, 2, new Object[]{3, new Object[]{4, 5}}, new Object[]{6, new Object[]{7, 8, new Object[]{9, 10}}}};

        System.out.println(flattenMap(arr));
    }

    private static ArrayList<Integer> flattenMap(Object[] arr) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Arrays.stream(arr).forEach(item -> {
            if (item instanceof Object[]) {
                arrayList.addAll(flattenMap((Object[]) item));
            } else arrayList.add((int) item);
        });
        return arrayList;
    }
}
