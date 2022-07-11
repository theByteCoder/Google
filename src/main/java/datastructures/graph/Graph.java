package datastructures.graph;

import java.util.*;

public class Graph {

    private static final HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();


    public static void main(String[] args) {
        int nodes = 5;

        buildGraph(nodes);
    }

    private static void buildGraph(int n) {
        for (int i = 1; i <= n; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
        adjacencyList.put(1, Collections.singletonList(2));
        adjacencyList.put(2, Arrays.asList(1, 3, 4));
        adjacencyList.put(3, Collections.singletonList(1));
        adjacencyList.put(4, Arrays.asList(2, 3));
        adjacencyList.put(5, Arrays.asList(1, 3));

        System.out.println(adjacencyList.values());
    }


}
