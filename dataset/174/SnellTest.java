import java.io.IOException;
import java.io.ByteArrayInputStream;

import java.time.LocalDate;
import java.time.Month;

import java.util.Scanner;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

/**
 * A class that represents and performs the function as the JUnit 4 Tester for all the Homework 6 classes and methods.
 *
 * @author David Nguyen
 * @since 04/30/2023
 * @version 1.0
 */
public class Tester {

    // A field that represents a test graph
    private Graph<String, String> testGraph;

    // A field that represents a wordLadder for testing
    private WordLadders wordLadders;

    /**
     * Sets up the test for Graph and WordLadder
     */
    @Before
    public void setUp() {
        testGraph = new Graph<String, String>();
        wordLadders = new WordLadders();
    }





    @Test
    public void testRemoveNode() {
        testGraph.addNode("A", "apple");
        testGraph.addNode("B", "bruh");
        testGraph.addNode("C", "cheers");
        testGraph.addNode("D", "data");
        assertTrue(testGraph.removeNode("A"));
        assertFalse(testGraph.removeNode("A")); // Should be false because node is already removed
        assertTrue(testGraph.removeNode("B"));
        assertTrue(testGraph.removeNode("C"));
        assertTrue(testGraph.removeNode("D"));
        assertFalse(testGraph.removeNode("C")); // Should be false because node is already removed
        assertFalse(testGraph.removeNode(null));
    }

    /**
     * Test the removeNodes() method
     */
    @Test
    public void testRemoveNodes() {
        testGraph.addNode("A", "apple");
        testGraph.addNode("B", "banana");
        testGraph.addNode("C", "cherry");
        assertTrue(testGraph.removeNodes("A", "B"));
        assertFalse(testGraph.removeNode("A"));  // Should be false because node is already removed
        assertFalse(testGraph.removeNode("B"));  // Should be false because node is already removed
        assertFalse(testGraph.removeNodes("A")); // Should be false because node is already removed
        assertTrue(testGraph.removeNodes("C"));
        testGraph.addNode("D", "data");
        testGraph.addNode("E", "eggs");
        testGraph.addNode("F", "fintech");
        testGraph.addEdges("D", "E", "F");
        assertTrue(testGraph.removeNodes("D", "E", "F"));
        assertFalse(testGraph.removeNodes(null, null, null));
        testGraph.addNode("G","guitar");
        assertFalse(testGraph.removeNodes("G", null, null));
    }

    /**
     * Test the DFS() method
     */
    @Test
    public void testDFS() {
        testGraph.addNode("A", "apple");
        testGraph.addNode("B", "banana");
        testGraph.addNode("C", "cherry");
        testGraph.addEdge("A", "B");
        testGraph.addEdge("B", "C");
        Object[] dfsPath = testGraph.DFS("A", "C"); // Test the expected path of DFS between A and C
        String[] castedPath = Arrays.copyOf(dfsPath, dfsPath.length, String[].class);
        assertNotNull(castedPath);
        assertEquals(3, castedPath.length);
        assertEquals("A", castedPath[0]);
        assertEquals("B", castedPath[1]);
        assertEquals("C", castedPath[castedPath.length - 1]);
        testGraph.addNode("D", "data");
        testGraph.addNode("E", "egg");
        Object[] dfsPath1 = testGraph.DFS("D", "E"); // Test the expected path of DFS between D and E
        assertEquals(0, dfsPath1.length);
        Object[] dfsPath2 = testGraph.DFS("F", "G"); // Test the expected path of DFS between F and G
        assertEquals(0, dfsPath2.length);
        Object[] dfsPath3 = testGraph.DFS("D", "H"); // Test the expected path of DFS between D and H
        assertEquals(0, dfsPath3.length);
        assertNotNull(dfsPath3);
    }

}