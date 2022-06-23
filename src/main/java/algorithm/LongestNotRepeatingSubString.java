package algorithm;

public class LongestNotRepeatingSubString {

    public static void main(String[] args) {
        String s = "abccddabbccd";
        System.out.println(findLongestNotRepeatingSubString(s));
    }

    private static int findLongestNotRepeatingSubString(String str) {
        int res = 0;
        boolean[] visited = new boolean[256];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (visited[str.charAt(j)] == true) {
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
