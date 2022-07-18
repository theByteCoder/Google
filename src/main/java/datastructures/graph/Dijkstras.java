package datastructures.graph;

import java.util.LinkedList;

public class Dijkstras {

    static class WeightedGraph {

        int totalEdges;
        int edges;
        LinkedList<Integer>[] adj;

        @SuppressWarnings("unchecked")
        WeightedGraph(int vertices, int edges) {
            this.totalEdges = edges;
            this.adj = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                this.adj[i] = new LinkedList<>();
            }
        }

        public void addEdges(int source, int destination) throws Exception {
            if (this.edges < this.totalEdges) {
                edges++;
                this.adj[source].add(destination);
                this.adj[destination].add(source);
            } else throw new Exception("EdgeOutOfBoundsException");
        }
    }

    public static void main(String[] args) throws Exception {
        WeightedGraph graph = new WeightedGraph(6, 8);
        graph.addEdges(0, 2);
        graph.addEdges(0, 3);
        graph.addEdges(1, 4);
        graph.addEdges(2, 1);
        graph.addEdges(2, 3);
        graph.addEdges(2, 5);
        graph.addEdges(3, 5);
        graph.addEdges(4, 5);
    }
}
