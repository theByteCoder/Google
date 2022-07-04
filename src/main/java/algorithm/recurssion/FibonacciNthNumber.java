package algorithm.recurssion;

import java.util.logging.Logger;

public class FibonacciNthNumber {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(FibonacciNthNumber.class.getName());
        String fib = String.valueOf(findNthFibonacciNumber(9));
        logger.info(fib);
    }

    private static int findNthFibonacciNumber(int n) {
        if (n == 0) {
            return  0;
        } else if (n == 1 || n == 2) {
            return  1;
        } else {
            return findNthFibonacciNumber(n - 1) + findNthFibonacciNumber(n - 2);
        }
    }
}
