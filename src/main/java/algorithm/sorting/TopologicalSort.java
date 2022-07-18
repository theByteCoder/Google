package algorithm.sorting;

import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {

    public static class DirectedGraph {

        int totalVertices;
        int totalEdges;
        int edges;
        LinkedList<Integer>[] adj;

        @SuppressWarnings("unchecked")
        public DirectedGraph(int totalVertices, int totalEdges) {
            this.totalVertices = totalVertices;
            this.totalEdges = totalEdges;
            this.adj = new LinkedList[totalVertices];
            for (int i = 0; i < totalVertices; i++) {
                this.adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination) throws Exception {
            if (this.edges < this.totalEdges) {
                this.edges++;
                this.adj[source].add(destination);
            } else throw new Exception("EdgeOutOfBoundsException");
        }

        public int[] topologicalSort(int vertex) {
            int[] sorted = new int[this.totalVertices];
            boolean[] isVisited = new boolean[this.totalVertices];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < totalVertices; i++) {
                if (!isVisited[i]) {
                    isVisited[i] = true;
                    this.dfs(i, stack, isVisited);
                }
            }

            int i = 0;
            while (!stack.isEmpty()) {
                sorted[i++] = stack.pop();
            }
            return sorted;
        }

        private void dfs(int vertex, Stack<Integer> stack, boolean[] isVisited) {
            for (int neighbour : this.adj[vertex])
                if (!isVisited[neighbour]) {
                    isVisited[neighbour] = true;
                    dfs(neighbour, stack, isVisited);
                }
            stack.push(vertex);
        }
    }
}
