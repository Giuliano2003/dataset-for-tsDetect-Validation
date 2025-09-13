import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import LightSim.Snell;

class dataFlowTest {

    @Test
    public void testTheta1Data() {
        Snell snell = new Snell(0, 45, 1.5, 1.0);
        double theta1 = snell.calculateTheta1();
        // Verify the expected value
        assertEquals(28.1255, theta1, 1e-4);
    }

    @Test
    public void testTheta2Data() {
        Snell snell = new Snell(45, 0, 1.5, 1.0);
        double theta2 = snell.calculateTheta2();
        // Verify the expected value
        assertTrue(Double.isNaN(snell.calculateTheta2()));
    }

    @Test
    public void testIndex1Data() {
        Snell snell = new Snell(45, 45, 0, 1.0);
        double index1 = snell.calculateIndex1();
        // Verify the expected value
        assertEquals(1.0, index1, 1e-4);
    }

    @Test
    public void testIndex2Data() {
        Snell snell = new Snell(45, 45, 1.5, 0);
        double index2 = snell.calculateIndex2();
        // Verify the expected value
        assertEquals(1.5, index2, 1e-4);
    }

    @Test
    public void testMaximums() {
        Snell snell = new Snell(90, 45, 1.5, 1.0);
        double theta1 = snell.calculateTheta1();
        double theta2 = snell.calculateTheta2();
        double index1 = snell.calculateIndex1();
        double index2 = snell.calculateIndex2();
        // Verify that the values are within the expected range
        assertNotNull(theta1);
        assertNotNull(theta2);
        assertNotNull(index1);
        assertNotNull(index2);
    }
}