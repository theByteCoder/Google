package datastructures.graph;

import java.util.LinkedList;
import java.util.Stack;

public class ConnectedComponents {

    public static class UndirectedGraph {

        int totalEdges;
        int edges;
        public LinkedList<Integer>[] adj;

        @SuppressWarnings("unchecked")
        public UndirectedGraph(int totalVertices, int totalEdges) {
            this.totalEdges = totalEdges;
            this.adj = new LinkedList[totalVertices];
            for (int i = 0; i < totalVertices; i++) {
                this.adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination) throws Exception {
            if (this.edges < this.totalEdges) {
                edges++;
                this.adj[source].add(destination);
                this.adj[destination].add(source);
            } else throw new Exception("EdgeOutOfBoundException");
        }

        public boolean isConnected(int source, int destination) {
            boolean[] isVisited = new boolean[this.adj.length];
            Stack<Integer> stack = new Stack<>();
            stack.add(source);
            isVisited[source] = true;
            while (!stack.isEmpty()) {
                int cur = stack.pop();
                if (cur == destination) return true;
                for (int neighbour : this.adj[cur]) {
                    if(!isVisited[neighbour]) {
                        isVisited[neighbour] = true;
                        stack.add(neighbour);
                    }
                }
            }
            return false;
        }
    }

}
