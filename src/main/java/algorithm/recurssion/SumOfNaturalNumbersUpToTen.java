package algorithm.recurssion;

public class SumOfNaturalNumbersUpToTen {

    public static void main(String[] args) {
        System.out.println(sum(10));
    }

    private static int sum(int input) {
        if (input <= 1) return input;
        return input + sum(input - 1);
    }
}
