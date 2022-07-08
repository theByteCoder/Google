package datastructures.graph;

import java.util.*;

public class GraphBfsAndDfs {

    public static void main(String[] args) {
        Map<String, List<String>> graph1 = Map.of("a", List.of("b", "c"), "b", List.of("d"), "c", List.of("e"), "d", List.of("f"), "e", List.of(), "f", List.of());

        Map<String, String[]> graph2 = Map.of("a", new String[]{"b", "c"}, "b", new String[]{"d"}, "c", new String[]{"e"}, "d", new String[]{"f"}, "e", new String[]{}, "f", new String[]{});

        String source = "a";

        System.out.println(depthFirstWithArrayList(graph1, source));

        System.out.println(depthFirstWithArray(graph2, source));

        System.out.println(breadthFirst(graph2, source));

        depthFirstRecursive(graph2, source);
    }

    static List<String> depthFirstWithArrayList(Map<String, List<String>> graph, String source) {
        List<String> res = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        stack.add(source);
        while (!stack.isEmpty()) {
            String current = stack.pop();
            res.add(current);
            List<String> arrayList = graph.get(current);
            stack.addAll(arrayList);
        }
        return res;
    }

    static List<String> depthFirstWithArray(Map<String, String[]> graph, String source) {
        List<String> res = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        stack.add(source);
        while (!stack.isEmpty()) {
            String current = stack.pop();
            res.add(current);
            String[] arr = graph.get(current);
            Collections.addAll(stack, arr);
        }
        return res;
    }

    static void depthFirstRecursive(Map<String, String[]> graph, String source) {
        System.out.println(source);
        for (String neighbour : graph.get(source)) {
            depthFirstRecursive(graph, neighbour);
        }
    }

    static ArrayList<String> breadthFirst(Map<String, String[]> graph, String source) {
        ArrayList<String> arrayList = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            arrayList.add(current);
            String[] arr = graph.get(current);
            Collections.addAll(queue, arr);
        }
        return arrayList;
    }
}