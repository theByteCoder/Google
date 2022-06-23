package algorithm;


import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Logger;

public class FirstNegativeNumberInEverySlidingWindow {

    static StopWatch watch;

    static {
        watch = new StopWatch();
    }

    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int kTerm = 3;

        Logger logger = Logger.getLogger(FirstNegativeNumberInEverySlidingWindow.class.getName());
        String brute;
        String sliding;
        String res;

        watch.start();
        brute = String.valueOf(findFirstNegativeBruteForce(arr, kTerm));
        watch.stop();
        res = String.format("%s %s", brute, watch.getNanoTime());
        logger.info(res);

        watch.reset();

        watch.start();
        sliding = String.valueOf(String.valueOf(findFirstNegative(arr, kTerm)));
        watch.stop();
        res = String.format("%s %s", sliding, watch.getNanoTime());
        logger.info(res);
    }

    private static ArrayList<Integer> findFirstNegativeBruteForce(int[] array, int kTerm) {
        ArrayList<Integer> res = new ArrayList<>();
        int length = array.length;
        for (int i = 0; i < length - kTerm + 1; i++) {
            boolean foundNegativeInWindow = false;
            for (int j = i; j < length && j < i + kTerm; j++) {
                if (array[j] < 0) {
                    res.add(array[j]);
                    foundNegativeInWindow = true;
                    break;
                }
            }
            if (!foundNegativeInWindow) {
                res.add(0);
            }
        }
        return res;
    }

    private static ArrayList<Integer> findFirstNegative(int[] array, int kTerm) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        int length = array.length;
        for (int i = 0; i < kTerm; i++) {
            if (array[i] < 0) {
                linkedList.add(i);
            }
        }
        for (int i = kTerm; i < length; i++) {
            if (!linkedList.isEmpty()) {
                arrayList.add(array[linkedList.peek()]);
            } else {
                arrayList.add(0);
            }
            while ((!linkedList.isEmpty()) && linkedList.peek() < (i - kTerm + 1)) {
                linkedList.remove();
            }
            if (array[i] < 0) {
                linkedList.add(i);
            }
        }
        if (!linkedList.isEmpty()) {
            arrayList.add(array[linkedList.peek()]);
        } else {
            arrayList.add(0);
        }

        return arrayList;
    }
}
