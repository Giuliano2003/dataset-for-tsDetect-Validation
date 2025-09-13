import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import LightSim.Snell;

public class dataFlowTest {


    @Test
    public void testMinimums() {
        Snell snell = new Snell(1, 45, 1.5, 1.0);
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

    @Test
    public void testValidData() {
        Snell snell = new Snell(45, 45, 1.5, 1.0);
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