package algorithm.recurssion;

public class ReverseString {

    public static void main(String[] args) {
        String str = "hello my friend";
        System.out.println(reverse(str));
    }

    private static String reverse(String string) {
        if (string.equals("")) return "";
        return reverse(string.substring(1)) + string.charAt(0);
    }
}
