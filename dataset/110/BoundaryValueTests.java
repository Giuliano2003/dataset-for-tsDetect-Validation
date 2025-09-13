import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import LightSim.Snell;

public class boundaryValueTests {

    private static final double DELTA = 1e-2; // tolerance for floating point comparisons

   
    @Test
    public void testCalculateTheta2_AllCases() {
        Snell snell;

        // Case 1: Min, Nom, Nom
        snell = new Snell(0, 0, 1.75, 1.5);
        assertEquals(0, snell.calculateTheta2(), DELTA);

        // Case 2: Min+, Nom, Nom
        snell = new Snell(1, 0, 1.75, 1.5);
        assertEquals(1.16, snell.calculateTheta2(), DELTA);

        // Case 3: Min-, Nom, Nom
        snell = new Snell(-1, 0, 1.75, 1.5);
        assertEquals(-1.0, snell.calculateTheta2(), DELTA);

        // Case 4: Max, Nom, Nom
        snell = new Snell(90, 0, 1.75, 1.5);
        assertTrue(Double.isNaN(snell.calculateTheta2()));

        // Case 5: Max-, Nom, Nom
        snell = new Snell(89, 0, 1.75, 1.5);
        assertTrue(Double.isNaN(snell.calculateTheta2()));

        // Case 6: Max+, Nom, Nom
        snell = new Snell(91, 0, 1.75, 1.5);
        assertEquals(-1, snell.calculateTheta2(), DELTA);

        // Case 7: Nom, Min, Nom
        snell = new Snell(45, 0, 1.0, 1.0);
        assertEquals(45.0, snell.calculateTheta2(), DELTA);

        // Case 8: Nom, Min+, Nom
        snell = new Snell(45, 0, 2.0, 1.5);
        assertEquals(70.52, snell.calculateTheta2(), DELTA);

        // Case 9: Nom, Min-, Nom
        snell = new Snell(45, 0, -1.0, 1.5);
        assertEquals(-1.0, snell.calculateTheta2(), DELTA);

        // Case 10: Nom, Max, Nom
        snell = new Snell(45, 0, 4.0, 1.5);
        assertTrue(Double.isNaN(snell.calculateTheta2()));

        // Case 11: Nom, Max-, Nom
        snell = new Snell(45, 0, 3.0, 1.5);
        assertTrue(Double.isNaN(snell.calculateTheta2()));

        // Case 12: Nom, Max+, Nom
        snell = new Snell(45, 0, 5.0, 1.5);
        assertEquals(-1.0, snell.calculateTheta2(), DELTA);

        // Case 13: Nom, Nom, Min
        snell = new Snell(45, 0, 1.5, 1.0);
        assertTrue(Double.isNaN(snell.calculateTheta2()));

        // Case 14: Nom, Nom, Min+
        snell = new Snell(45, 0, 1.5, 2.0);
        assertEquals(32.02, snell.calculateTheta2(), DELTA);

        // Case 15: Nom, Nom, Min-
        snell = new Snell(45, 0, 1.5, -1.0);
        assertEquals(-1.0, snell.calculateTheta2(), DELTA);

        // Case 16: Nom, Nom, Max
        snell = new Snell(45, 0, 4.0, 4.0);
        assertEquals(45.0, snell.calculateTheta2(), DELTA);

        // Case 17: Nom, Nom, Max-
        snell = new Snell(45, 0, 4.0, 3.0);
        assertEquals(70.52, snell.calculateTheta2(), DELTA);

        // Case 18: Nom, Nom, Max+
        snell = new Snell(45, 0, 1.5, 5.0);
        assertEquals(-1.0, snell.calculateTheta2(), DELTA);

        // Case 19: Nom, Nom, Nom
        snell = new Snell(25, 0, 3.0, 2.0);
        assertEquals(39.34, snell.calculateTheta2(), DELTA);
    }
    
    

}