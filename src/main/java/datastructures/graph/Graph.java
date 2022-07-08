package datastructures.graph;

import java.util.LinkedList;

public class Graph {

    private final LinkedList<Integer>[] adjList;

    public Graph(int v) {
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjList[source].add(destination);
        adjList[destination].add(source);
    }

    public static void main(String[] args) {
        int nodes = 10;

        int source1 = 0;
        int source2 = 1;
        int source3 = 2;
        int source4 = 3;
        int source5 = 4;

        int destination1 = 5;
        int destination2 = 6;
        int destination3 = 7;
        int destination4 = 8;
        int destination5 = 9;

        Graph al = new Graph(nodes);
        al.addEdge(source1, destination1);
        al.addEdge(source2, destination2);
        al.addEdge(source3, destination3);
        al.addEdge(source4, destination4);
        al.addEdge(source5, destination5);
    }
}
