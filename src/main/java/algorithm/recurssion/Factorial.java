package algorithm.recurssion;

public class Factorial {

    public static void main(String[] args) {
        int tar = 6;
        System.out.println(factorial(tar));
    }

    private static int factorial(int target) {
        if(target > 0) return target * factorial(target - 1);
        return 1;
    }
}
