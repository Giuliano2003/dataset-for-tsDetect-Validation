import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import LightSim.Snell;

public class snellintegrationTest {

    private static final double DELTA = 1e-3; // tolerance for floating point comparisons

    @Test
    public void testCalculateIndex1AndIndex2() {
        Snell snell = new Snell(30, 45, 1.5, 1.0);

        // Calculate Index1 with initial values
        double index1 = snell.calculateIndex1();
        assertEquals(1.414, index1, DELTA);

        // Update the Snell object with new values and check Index2
        snell = new Snell(30, 45, index1, 1.5);
        double index2 = snell.calculateIndex2();
        assertEquals(1, index2, DELTA);
    }

    @Test
    public void testCalculateTheta1AndTheta2() {
        Snell snell = new Snell(30, 45, 1.5, 1.0);

        // Calculate Theta1 with initial values
        double theta1 = snell.calculateTheta1();
        assertEquals(28.125, theta1, DELTA);

        // Update the Snell object with new values and check Theta2
        snell = new Snell(30, theta1, 1.5, 1.0);
        double theta2 = snell.calculateTheta2();
        assertEquals(48.59, theta2, DELTA);
    }

    @Test
    public void testCalculateWithInvalidValues() {
        // Test with invalid values for theta1, theta2, index1, and index2
        Snell snell = new Snell(-30, -45, -1.5, -1.0);

        // Test invalid values for calculations
        assertEquals(-1.0, snell.calculateIndex1(), DELTA);
        assertEquals(-1.0, snell.calculateIndex2(), DELTA);
        assertEquals(-1.0, snell.calculateTheta1(), DELTA);
        assertEquals(-1.0, snell.calculateTheta2(), DELTA);
    }

    
    @Test
    public void testCalculateWithValidValues() {
        // Test with Valid values for theta1, theta2, index1, and index2
        Snell snell = new Snell(30, 45, 1.5, 1.0);

        // Test invalid values for calculations
        assertEquals(1.414, snell.calculateIndex1(), DELTA);
        assertEquals(1, snell.calculateIndex2(), DELTA);
        assertEquals(30, snell.calculateTheta1(), DELTA);
        assertEquals(45, snell.calculateTheta2(), DELTA);
    }

   
}