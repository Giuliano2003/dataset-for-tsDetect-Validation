
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import LightSim.Snell;

import org.junit.jupiter.api.DisplayName;


public class PathTesting {

private static final double DELTA = 1e-2; // tolerance for floating point comparisons

    @Test
    @DisplayName("Test Valid Values for calculateIndex1 ")
    public void testValidValues() {
        Snell snellTest = new Snell(30, 45, 2, 3);
        assertEquals(4.24, snellTest.calculateIndex1(), DELTA);
        
    }
    
    @Test
    @DisplayName("Test Valid Values for calculateIndex2")
    public void testValidValues2() {
        Snell snellTest = new Snell(30, 45, 2, 3);
        assertEquals(1.41, snellTest.calculateIndex2(), DELTA);
        
    }
    
    @Test
    @DisplayName("Test Valid Values for calculateTheta1")
    public void testValidValues3() {
        Snell snellTest = new Snell(30, 45, 3, 2);
        assertEquals(28.13, snellTest.calculateTheta1(), DELTA);
        
    }
    
    @Test
    @DisplayName("Test Valid Values for calculateTheta2")
    public void testValidValues4() {
        Snell snellTest = new Snell(30, 45, 3, 2);
        assertEquals(48.59, snellTest.calculateTheta2(), DELTA);
        
    }
    
    @Test
    @DisplayName("Test Invalid Valid Values Out of Range Index 1")
    public void testInvalidIndex1() {
        Snell snellTest = new Snell(30, 45, 5, 3);
        assertEquals(-1, snellTest.calculateIndex2(), DELTA);
        assertEquals(-1, snellTest.calculateTheta1(), DELTA);
        assertEquals(-1, snellTest.calculateTheta2(), DELTA);
    }
}