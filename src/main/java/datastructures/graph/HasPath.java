package datastructures.graph;

import java.util.*;

public class HasPath {

    public static void main(String[] args) {
        Map<Integer, Integer[]> graph = Map.of(
                1, new Integer[]{2, 3},
                2, new Integer[]{4},
                3, new Integer[]{5},
                4, new Integer[]{6},
                5, new Integer[]{},
                6, new Integer[]{}
        );

        int src = 1;

        System.out.println(hasPathDepthFirst(graph, src, 5));
        System.out.println(hasPathDepthFirst(graph, src, 6));

        System.out.println(hasPathDepthFirstRecursive(graph, src, 6));

        System.out.println(hasPathDepthFirstRecursive(graph, src, 7));

        System.out.println(hasPathDepthFirstRecursive(graph, src, 4));

        System.out.println(hasPathDepthBreadthFirst(graph, src, 8));
        System.out.println(hasPathDepthBreadthFirst(graph, src, 1));
    }

    private static boolean hasPathDepthFirst(Map<Integer, Integer[]> graph, int source, int destination) {
        if (source == destination) return true;
        Stack<Integer> stack = new Stack<>();
        stack.add(source);
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (current == destination) return true;
            Collections.addAll(stack, graph.get(current));
        }
        return false;
    }

    private static boolean hasPathDepthFirstRecursive(Map<Integer, Integer[]> graph, int source, int destination) {
        if (source == destination) return true;
        Integer[] neighbours = graph.get(source);
        for (int neighbour : neighbours) {
            if (neighbour == destination) {
                return true;
            }
            return hasPathDepthFirstRecursive(graph, neighbour, destination);
        }
        return false;
    }

    private static boolean hasPathDepthBreadthFirst(Map<Integer, Integer[]> graph, int source, int destination) {
        if (source == destination) return true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            Integer[] neighbours = graph.get(current);
            for (int neighbour : neighbours) {
                if (neighbour == destination) return true;
                Collections.addAll(queue, neighbours);
            }
        }
        return false;
    }
}
