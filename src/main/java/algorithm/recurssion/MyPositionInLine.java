package algorithm.recurssion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MyPositionInLine {

    public static void main(String[] args) {
        String[] peopleBeforeMe = {"Subhasish", "Piyu", "Samarendranath", "Lipika", "Rimi", "Partha", "Rina"};
        Queue<String> peopleQueue = new LinkedList<>(Arrays.asList(peopleBeforeMe));
        System.out.println(getMyPositionInLine(peopleQueue));
    }

    private static int getMyPositionInLine(Queue<String> peopleInQueue) {
        if (peopleInQueue.isEmpty()) return 1;
        peopleInQueue.remove();
        return 1 + getMyPositionInLine(peopleInQueue);
    }
}
