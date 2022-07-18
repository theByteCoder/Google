package datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void main(String[] args) throws Exception {
        Graph graph = new Graph(10, 10);
        graph.addEdges(0, 2);
        graph.addEdges(0, 3);

        graph.addEdges(1, 2);
        graph.addEdges(1, 4);

        graph.addEdges(2, 3);
        graph.addEdges(2, 5);

        graph.addEdges(3, 5);

        graph.addEdges(4, 5);

        graph.addEdges(6, 7);
        graph.addEdges(8, 9);

        BFS BFS = new BFS();
        BFS.bfsTraversal(graph.adjacencyList);
        System.out.println(Arrays.toString(BFS.bfsTraversalList.toArray()));
    }

    ArrayList<Integer> bfsTraversalList = new ArrayList<>();

    void bfsTraversal(LinkedList<Integer>[] adj) {
        boolean[] isVisited = new boolean[adj.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < adj.length; i++) {
            if (!isVisited[i]) {
                queue.add(i);
                isVisited[i] = true;
                while (!queue.isEmpty()) {
                    int curr = queue.poll();
                    bfsTraversalList.add(curr);
                    for (int neighbour : adj[curr]) {
                        if (!isVisited[neighbour]) {
                            isVisited[neighbour] = true;
                            queue.add(neighbour);
                        }
                    }
                }
            }
        }
    }
}
