package algorithm;

import java.util.logging.Logger;

public class FibonacciNthNumber {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(FibonacciNthNumber.class.getName());
        String fib = String.valueOf(findNthFibonacciNumber(9));
        logger.info(fib);
    }

    private static int findNthFibonacciNumber(int n) {
        int res;
        if (n == 0) {
            res = 0;
        } else if (n == 1 || n == 2) {
            res = 1;
        } else {
            res = findNthFibonacciNumber(n - 1) + findNthFibonacciNumber(n - 2);
        }
        return res;
    }
}
