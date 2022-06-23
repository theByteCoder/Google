package algorithm;

import java.util.logging.Logger;

public class LongestNotRepeatingSubString {

    public static void main(String[] args) {
        String s = "abccddabbccd";
        Logger logger = Logger.getLogger(LongestNotRepeatingSubString.class.getName());
        String res = String.valueOf(findLongestNotRepeatingSubString(s));
        logger.info(res);
    }

    private static int findLongestNotRepeatingSubString(String str) {
        int res = 0;
        boolean[] visited = new boolean[256];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (visited[str.charAt(j)]) {
                    break;
                } else {
                    res = Math.max(res, j - i + 1);
                    visited[str.charAt(j)] = true;
                }
            }
            visited[str.charAt(i)] = false;
        }
        return res;
    }

}
