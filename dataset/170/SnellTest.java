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
     * Test the addNode() method
     */
    @Test
    public void testAddNode() {
        assertTrue(testGraph.addNode("A", "apple"));
        assertFalse(testGraph.addNode("A", "apple")); // Should be false because the node already exists
        assertTrue(testGraph.addNode("B", "banana"));
        assertFalse(testGraph.addNode("B", "bruh")); // Should be false because the key already exists
        assertTrue(testGraph.addNode("C", "cherry"));
        assertFalse(testGraph.addNode(null, "null"));
    }

    /**
     * Test the addNodes() method
     */
    @Test
    public void testAddNodes() {
        System.out.println("Extra testing the addNodes() method with printGraph():");
        String[] names = {"A", "B", "C"};
        String[] data = {"apple", "banana", "cherry"};
        assertTrue(testGraph.addNodes(names, data));
        String[] names1 = {"A", "C"};
        String[] data1 = {"apple", "cherry"};
        assertFalse(testGraph.addNodes(names1, data1)); // Should be false because the node C already exists
        String[] names2 = {"D", "E", "F"};
        String[] data2 = {"Data", "Egg", "Fruit"};
        assertTrue(testGraph.addNodes(names2, data2));
        String[] names3 = {null, "G", "H"};
        String[] data3 = {"null", "Guitar", "Hat"};
        assertTrue(testGraph.addNodes(names3, data3));
        testGraph.printGraph();
        System.out.println();
    }

}