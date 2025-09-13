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


    /**
     * Test the addNodes() method with arrays of different lengths (Edge case):
     */
    @Test
    public void testAddNodesDifferentLengthArrays() {
        String[] names = {"A", "B"};
        String[] data = {"apple", "banana", "cherry"};
        testGraph.addNodes(names, data);
    }

    /**
     * Test the addEdge() method
     */
    @Test
    public void testAddEdge() {
        testGraph.addNode("A", "apple");
        testGraph.addNode("B", "banana");
        assertTrue(testGraph.addEdge("A", "B"));
        assertFalse(testGraph.addEdge("C", "D")); // Should be false because no such nodes exist in the graph
        assertFalse(testGraph.addEdge("D", "E")); // Should be false because no such nodes exist in the graph
        testGraph.addNode("C", "cherry");
        testGraph.addNode("D", "data");
        assertTrue(testGraph.addEdge("A", "D"));
        assertTrue(testGraph.addEdge("B", "D"));
        assertTrue(testGraph.addEdge("A", "C"));
        assertTrue(testGraph.addEdge("C", "D"));
        assertFalse(testGraph.addEdge("C", "D")); // Should be false because the edges already exist
        assertFalse(testGraph.addEdge(null, null)); // Should be false because the key is null
        assertFalse(testGraph.addEdge("E", null)); // Should be false because the key is null
        assertFalse(testGraph.addEdge(null, "F")); // Should be false because the key is null
    }



}