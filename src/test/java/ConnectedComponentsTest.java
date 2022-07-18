import datastructures.graph.ConnectedComponents;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ConnectedComponentsTest {

    @BeforeAll
    static void setup() {
        System.out.println("Connected Components Test");
    }

    @Test
    public void testConnectedComponents() throws Exception {
        ConnectedComponents.UndirectedGraph graph = new ConnectedComponents.UndirectedGraph(5, 6);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(0, 3);
        graph.addEdge(2, 4);

        Assertions.assertTrue(graph.isConnected(0, 4));

        Throwable exception = Assertions.assertThrows(Exception.class, () -> graph.addEdge(0, 4));

        Assertions.assertEquals(exception.getMessage(), "EdgeOutOfBoundException");
    }
}
