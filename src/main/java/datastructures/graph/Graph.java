package datastructures.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    public boolean dfsIteration(int source, int destination) {
        if (source == destination) return true;
        boolean[] isVisited = new boolean[adjacencyList.length];
        isVisited[source] = true;
        @SuppressWarnings({"unchecked", "rawtypes"}) Stack<Integer> stack = new Stack();
        stack.push(source);
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (curr == destination) return true;
            for (int neighbour : adjacencyList[curr]) {
                if (!isVisited[neighbour]) {
                    stack.push(neighbour);
                    isVisited[neighbour] = true;
                }
            }
        }
        return false;
    }


    private boolean dfsRecursion(int source, int destination, boolean[] isVisited) {
        if (source == destination) return true;
        for (int neighbour : adjacencyList[source]) {
            if (!isVisited[neighbour]) {
                isVisited[neighbour] = true;
                boolean isConnected = dfsRecursion(neighbour, destination, isVisited);
                if (isConnected) return true;
            }
        }
        return false;
    }

    public boolean dfsIsConnected(int source, int destination) {
        if (source == destination) return true;
        boolean[] isVisited = new boolean[adjacencyList.length];
        return dfsRecursion(source, destination, isVisited);
    }
}
