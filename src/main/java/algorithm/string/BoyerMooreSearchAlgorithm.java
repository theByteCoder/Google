package algorithm.string;

import java.util.ArrayList;
import java.util.Arrays;

public class BoyerMooreSearchAlgorithm {

    public static void main(String[] args) {
        String txt = "ABAAABCDABC";
        String pat = "ABC";
        System.out.println("Patterns occur at shift = " + Arrays.toString(search(txt, pat).toArray()));
    }

    static ArrayList<Integer> search(String text, String pattern) {
        ArrayList<Integer> indexes = new ArrayList<>();

        char[] txt = text.toCharArray();
        char[] pat = pattern.toCharArray();

        int n = txt.length;
        int m = pat.length;

        int noOfChars = 256;
        int[] badChars = new int[noOfChars];

        for (int i = 0; i < noOfChars; i++)
            badChars[i] = -1;

        for (int i = 0; i < m; i++)
            badChars[pat[i]] = i;

        int s = 0;
        while (s <= (n - m)) {
            int j = m - 1;

            while (j >= 0 && pat[j] == txt[s + j]) j--;

            if (j < 0) {
                indexes.add(s);
                s += (s + m < n) ? m - badChars[txt[s + m]] : 1;
            } else s += Math.max(1, j - badChars[txt[s + j]]);
        }
        return indexes;
    }
}
