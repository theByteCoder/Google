package datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class DFS {

    public static void main(String[] args) throws Exception {
        int v = 6, e = 5;
        Graph graph = new Graph(v, e);
        graph.addEdges(0, 1);
        graph.addEdges(0, 2);
        graph.addEdges(1, 2);
        graph.addEdges(1, 3);
        graph.addEdges(4, 5);

        DFS DFS = new DFS();
        DFS.dfsTraversal(graph.adjacencyList);
        System.out.println(Arrays.toString(DFS.dfsTraversalList.toArray()));
    }

    ArrayList<Integer> dfsTraversalList = new ArrayList<>();

    void dfsTraversal(LinkedList<Integer>[] adj) {
        boolean[] isVisited = new boolean[adj.length];
        for (int i = 0; i < adj.length; i++) {
            if (!isVisited[i]) dfs(i, isVisited, adj);
        }
    }

    void dfs(int source, boolean[] isVisited, LinkedList<Integer>[] adj) {
        dfsTraversalList.add(source);
        isVisited[source] = true;
        for (int neighbour : adj[source]) {
            if (!isVisited[neighbour]) {
                isVisited[neighbour] = true;
                dfs(neighbour, isVisited, adj);
            }
        }
    }
}
