package algorithm.anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] a = {"cat", "etst", "tac", "toe", "test", "act"};
        System.out.println(findGroupAnagrams(a));
    }

    private static ArrayList<ArrayList<String>> findGroupAnagrams(String[] words) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String str : words) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);
            if (map.containsKey(key)) {
                ArrayList<String> group = map.get(key);
                group.add(str);
                map.put(key, group);
            } else map.put(key, new ArrayList<>(List.of(str)));
        }
        return new ArrayList<>(map.values());
    }
}
