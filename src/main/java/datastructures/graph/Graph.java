package datastructures.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    LinkedList<Integer>[] adjacencyList;
    private final int totalEdges;
    private int edges;

    @SuppressWarnings("unchecked")
    public Graph(int vertices, int totalEdges) {
        this.adjacencyList = new LinkedList[vertices];
        this.totalEdges = totalEdges;
        for (int i = 0; i < vertices; i++) this.adjacencyList[i] = new LinkedList<>();
    }

    public void addEdges(int source, int destination) throws Exception {
        if (this.edges < this.totalEdges) {
            this.edges++;
            this.adjacencyList[source].add(destination);
            this.adjacencyList[destination].add(source);
        } else throw new Exception("Number of allocated edges exhausted");
    }

    public ArrayList<Integer> bfs(int source, int destination) {
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] isVisited = new boolean[this.adjacencyList.length];
        int[] parent = new int[this.adjacencyList.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        parent[source] = -1;
        isVisited[source] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == destination) break;
            for (int neighbour : this.adjacencyList[current]) {
                if (!isVisited[neighbour]) {
                    queue.add(neighbour);
                    isVisited[neighbour] = true;
                    parent[neighbour] = current;
                }
            }
        }
        int curr = destination;
        while (parent[curr] != -1) {
            res.add(curr);
            curr = parent[curr];
        }
        return res;
    }
}
