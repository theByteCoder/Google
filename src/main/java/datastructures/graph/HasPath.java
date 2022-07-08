package datastructures.graph;

import java.util.*;

public class HasPath {

    public static void main(String[] args) {
        Map<String, String[]> graph = Map.of("a", new String[]{"b", "c"}, "b", new String[]{"d"}, "c", new String[]{"e"}, "d", new String[]{"f"}, "e", new String[]{}, "f", new String[]{});

        String src = "a";

        System.out.println(hasPathDepthFirst(graph, src, "e"));
        System.out.println(hasPathDepthFirst(graph, src, "f"));

        System.out.println(hasPathDepthFirstRecursive(graph, src, "f"));

        System.out.println(hasPathDepthFirstRecursive(graph, src, "x"));

        System.out.println(hasPathDepthFirstRecursive(graph, src, "d"));

        System.out.println(hasPathDepthBreadthFirst(graph, src, "z"));
        System.out.println(hasPathDepthBreadthFirst(graph, src, "a"));
    }

    private static boolean hasPathDepthFirst(Map<String, String[]> graph, String source, String destination) {
        if (source.equals(destination)) return true;
        Stack<String> stack = new Stack<>();
        stack.add(source);
        while (!stack.isEmpty()) {
            String current = stack.pop();
            if (current.equals(destination)) return true;
            Collections.addAll(stack, graph.get(current));
        }
        return false;
    }

    private static boolean hasPathDepthFirstRecursive(Map<String, String[]> graph, String source, String destination) {
        if (source.equals(destination)) return true;
        String[] neighbours = graph.get(source);
        for (String neighbour : neighbours) {
            if (neighbour.equals(destination)) {
                return true;
            }
            if (neighbour.length() > 0)
                return hasPathDepthFirstRecursive(graph, neighbour, destination);
        }
        return false;
    }

    private static boolean hasPathDepthBreadthFirst(Map<String, String[]> graph, String source, String destination) {
        if (source.equals(destination)) return true;
        Queue<String> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            String[] neighbours = graph.get(current);
            for (String neighbour : neighbours) {
                if (neighbour.equals(destination)) return true;
                Collections.addAll(queue, neighbours);
            }
        }
        return false;
    }
}
