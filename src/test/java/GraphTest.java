import datastructures.graph.Graph;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

public class GraphTest {

    int vertices, edges;

    Graph graph;

    @Rule
    private final ExpectedException expectedException = ExpectedException.none();

    @BeforeAll
    static void setup() {
        System.out.println("Graph Tests");
    }

    @Test
    public void test1() throws Exception {
        vertices = 5;
        edges = 6;
        graph = new Graph(vertices, edges);

        graph.addEdges(0, 1);
        graph.addEdges(1, 2);
        graph.addEdges(2, 3);
        graph.addEdges(3, 4);
        graph.addEdges(0, 4);
        graph.addEdges(2, 4);

        int distance1 = graph.bfs(0, 3).size();
        int distance2 = graph.bfs(1, 3).size();

        Assertions.assertEquals(distance1, 2);
        Assertions.assertEquals(distance2, 2);
    }

    @Test
    void test2() throws Exception {
        vertices = 7;
        edges = 8;
        graph = new Graph(vertices, edges);

        graph.addEdges(0, 1);
        graph.addEdges(1, 2);
        graph.addEdges(2, 3);
        graph.addEdges(3, 4);
        graph.addEdges(0, 4);
        graph.addEdges(2, 4);
        graph.addEdges(4, 5);
        graph.addEdges(5, 6);

        int distance3 = graph.bfs(0, 6).size();

        Assertions.assertEquals(distance3, 3);
    }

    @Test
    void test3() throws Exception {
        vertices = 3;
        edges = 1;
        graph = new Graph(vertices, edges);

        /* expectedException.expect(Exception.class);
        expectedException.expectMessage("Number of allocated edges exhausted"); */

        graph.addEdges(0, 1);

        Throwable exception = Assertions.assertThrows(Exception.class, () -> graph.addEdges(1, 2));

        Assertions.assertEquals(exception.getMessage(), "Number of allocated edges exhausted");
    }

    @Test
    void test4() throws Exception {
        vertices = 7;
        edges = 8;
        graph = new Graph(vertices, edges);

        graph.addEdges(0, 1);
        graph.addEdges(1, 2);
        graph.addEdges(2, 3);
        graph.addEdges(3, 4);
        graph.addEdges(0, 4);
        graph.addEdges(2, 4);
        graph.addEdges(4, 5);
        graph.addEdges(5, 6);

        Assertions.assertTrue(graph.dfsIsConnected(1, 5));
    }

    @Test
    void test5() throws Exception {
        vertices = 7;
        edges = 8;
        graph = new Graph(vertices, edges);

        graph.addEdges(0, 1);
        graph.addEdges(1, 2);
        graph.addEdges(2, 3);
        graph.addEdges(3, 4);
        graph.addEdges(0, 4);
        graph.addEdges(2, 4);
        graph.addEdges(4, 5);
        graph.addEdges(5, 6);

        Assertions.assertTrue(graph.dfsIteration(1, 5));
        Assertions.assertTrue(graph.dfsIteration(1, 6));
        Assertions.assertFalse(graph.dfsIteration(1, 7));
    }
}
