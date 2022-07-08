package algorithm.recurssion;

import java.util.Stack;

public class SumInStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);

        System.out.println(sum(stack));
    }

    private static int sum(Stack<Integer> stack) {
        if (stack.isEmpty()) return 0;
        return stack.pop() + sum(stack);
    }
}
