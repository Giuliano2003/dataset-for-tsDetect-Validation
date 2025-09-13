
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import LightSim.Snell;

import org.junit.jupiter.api.DisplayName;


public class PathTesting {

    private static final double DELTA = 1e-2; // tolerance for floating point comparisons
    
    @Test
    public void testInvalidTheta2() {
        Snell snellTest = new Snell(30, -1, 2, 2);
        assertEquals(-1, snellTest.calculateIndex1(), DELTA);
        assertEquals(-1, snellTest.calculateIndex1(), DELTA);
        assertEquals(-1, snellTest.calculateTheta1(), DELTA);
    }
  
}