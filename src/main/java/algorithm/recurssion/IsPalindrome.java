package algorithm.recurssion;

public class IsPalindrome {

    public static void main(String[] args) {
        String str = "Kayak";
        System.out.println(isPalindrome(str));
        str = "racecar";
        System.out.println(isPalindrome(str));
    }

    private static boolean isPalindrome(String string) {
        string = string.toLowerCase();
        if (string.length() == 0 || string.length() == 1) return true;
        if (string.charAt(0) == string.charAt(string.length() - 1)) {
            return isPalindrome(string.substring(1, string.length() - 1));
        }
        return false;
    }

}
