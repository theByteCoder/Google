import algorithm.sorting.TopologicalSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TopologicalSortTest {

    @BeforeAll
    static void setup() {
        System.out.println("Topological sort test");
    }

    @Test
    public void test1() throws Exception {
        TopologicalSort.DirectedGraph graph = new TopologicalSort.DirectedGraph(7, 9);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);

        graph.addEdge(1, 4);

        graph.addEdge(2, 1);
        graph.addEdge(2, 3);

        graph.addEdge(3, 1);

        graph.addEdge(5, 1);
        graph.addEdge(5, 4);
        graph.addEdge(5, 6);

        Assertions.assertEquals(Arrays.toString(graph.topologicalSort(0)), "[5, 6, 0, 2, 3, 1, 4]");

    }

    @Test
    public void test2() throws Exception {
        TopologicalSort.DirectedGraph graph = new TopologicalSort.DirectedGraph(5, 3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        Throwable exception = Assertions.assertThrows(Exception.class, () -> graph.addEdge(3, 4));
        Assertions.assertEquals(exception.getMessage(), "EdgeOutOfBoundsException");

    }
}
