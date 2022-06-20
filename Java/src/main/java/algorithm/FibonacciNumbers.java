package algorithm;

import java.util.Arrays;
import java.util.logging.Logger;

public class FibonacciNumbers {

    public static void main(String[] args) {

        Logger logger = Logger.getLogger(FibonacciNumbers.class.getName());

        int terms = 10;
        int[] fib = generateFibonacciNumber(terms);

        String arrStr = Arrays.toString(fib);

        logger.info(arrStr);

    }

    private static int[] generateFibonacciNumber(int terms) {
        int[] arr = new int[terms];
        arr[0] = 0;
        arr[1] = 1;
        int n1 = 0;
        int n2 = 1;
        int counter = 2;

        while (counter < terms) {
            int fib = n1 + n2;
            n1 = n2;
            n2 = fib;
            arr[counter] = fib;
            counter++;
        }

        return arr;
    }
}
