package cse41321.container;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class Homework8Test {

    private Homework8.Graph<Character, Integer> maze1;
    private Homework8.Graph<Character, Integer> maze2;

    @BeforeMethod
    public void setUp() {
        // Maze #1
        maze1 = new Homework8.Graph<Character, Integer>();
        maze1.insertVertex('A');
        maze1.insertVertex('B');
        maze1.insertVertex('C');
        maze1.insertVertex('D');
        maze1.insertVertex('E');
        maze1.insertVertex('F');
        maze1.insertVertex('G');
        maze1.insertEdge('A', 'C', 0);
        maze1.insertEdge('C', 'A', 0);
        maze1.insertEdge('A', 'D', 0);
        maze1.insertEdge('D', 'A', 0);
        maze1.insertEdge('B', 'D', 0);
        maze1.insertEdge('D', 'B', 0);
        maze1.insertEdge('C', 'F', 0);
        maze1.insertEdge('F', 'C', 0);
        maze1.insertEdge('D', 'E', 0);
        maze1.insertEdge('D', 'G', 0);
        maze1.insertEdge('E', 'D', 0);
        maze1.insertEdge('G', 'D', 0);
        maze1.insertEdge('E', 'G', 0);
        maze1.insertEdge('G', 'E', 0);
        maze1.insertEdge('F', 'G', 0);
        maze1.insertEdge('G', 'F', 0);
        // Maze #2
        maze2 = new Homework8.Graph<Character, Integer>();
        maze2.insertVertex('A');
        maze2.insertVertex('B');
        maze2.insertVertex('C');
        maze2.insertVertex('D');
        maze2.insertVertex('E');
        maze2.insertVertex('F');
        maze2.insertVertex('G');
        maze2.insertEdge('A', 'C', 0);
        maze2.insertEdge('C', 'A', 0);
        maze2.insertEdge('A', 'D', 0);
        maze2.insertEdge('D', 'A', 0);
        maze2.insertEdge('B', 'D', 0);
        maze2.insertEdge('D', 'B', 0);
        maze2.insertEdge('C', 'F', 0);
        maze2.insertEdge('F', 'C', 0);
        maze2.insertEdge('E', 'G', 0);
        maze2.insertEdge('G', 'E', 0);
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test
    public void howManyVerticesInMaze1() {
        assertEquals(7, maze1.getNumVertices());
        maze1.removeEdge('E', 'D');
        maze1.removeEdge('D', 'E');
        maze1.removeEdge('E', 'G');
        maze1.removeEdge('G', 'E');
        maze1.removeVertex('E');
        assertEquals(6, maze1.getNumVertices());
    }

    @Test
    public void howManyEdgesInMaze1() {
        assertEquals(16, maze1.getNumEdges());
    }

    @Test
    public void howManyVerticesInMaze2() {
        assertEquals(7, maze2.getNumVertices());
        maze2.removeEdge('E', 'G');
        maze2.removeEdge('G', 'E');
        maze2.removeVertex('E');
        assertEquals(6, maze2.getNumVertices());
    }

    @Test
    public void howManyEdgesInMaze2() {
        assertEquals(10, maze2.getNumEdges());
    }

    @Test
    public void setVertexColor() {
        Homework8.Graph.Vertex vertex;
        vertex = maze1.getVertex('A');
        vertex.setColor(Homework8.VertexColor.GRAY);
        assertEquals(Homework8.VertexColor.GRAY, maze1.getVertex('A').getColor());
        assertEquals(Homework8.VertexColor.WHITE, maze1.getVertex('G').getColor());
    }

    @Test
    public void testIsExitReachable() {
        assertTrue(Homework8.isExitReachable(maze1, 'A', 'G'));
        assertFalse(Homework8.isExitReachable(maze2, 'A', 'G'));
    }
}