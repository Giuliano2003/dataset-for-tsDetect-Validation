import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import LightSim.Snell;

import org.junit.jupiter.api.DisplayName;


public class PathTesting {

private static final double DELTA = 1e-2; // tolerance for floating point comparisons
    
    @Test
    @DisplayName("Test Invalid Valid Values Out of Range Index 2")
    public void testInvalidIndex2() {
        Snell snellTest = new Snell(30, 45, 3, 5);
        assertEquals(-1, snellTest.calculateIndex1(), DELTA);
        assertEquals(-1, snellTest.calculateTheta1(), DELTA);
        assertEquals(-1, snellTest.calculateTheta2(), DELTA);
    }
    
    @Test
    @DisplayName("Test Invalid Valid Values Out of Range Theta 1")
    public void testInvalidTheta1() {
        Snell snellTest = new Snell(-1, 45, 2, 2);
        assertEquals(-1, snellTest.calculateIndex1(), DELTA);
        assertEquals(-1, snellTest.calculateIndex2(), DELTA);
        assertEquals(-1, snellTest.calculateTheta2(), DELTA);
    }
}