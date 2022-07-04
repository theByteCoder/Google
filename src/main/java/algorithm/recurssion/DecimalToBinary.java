package algorithm.recurssion;

public class DecimalToBinary {

    public static void main(String[] args) {
        int d = 233;
        System.out.println(decimalToBinary(d, ""));
    }

    private static String decimalToBinary(int decimal, String result) {
        if (decimal == 0) return result;
        result += decimal % 2;
        return decimalToBinary(decimal / 2, result);
    }
}
