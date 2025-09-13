import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import LightSim.Snell;

public class boundaryValueTests {

    private static final double DELTA = 1e-2; // tolerance for floating point comparisons

   
    @Test
    public void testCalculateTheta1_AllCases() {
        Snell snell;

        // Case 1: Min, Nom, Nom
        snell = new Snell(0, 0, 1.75, 1.5);
        assertEquals(0, snell.calculateTheta1(), DELTA);

        // Case 2: Min+, Nom, Nom
        snell = new Snell(0, 1, 1.75, 1.5);
        assertEquals(0.85, snell.calculateTheta1(), DELTA);

        // Case 3: Min-, Nom, Nom
        snell = new Snell(0, -1, 1.75, 1.5);
        assertEquals(-1.0, snell.calculateTheta1(), DELTA);

        // Case 4: Max, Nom, Nom
        snell = new Snell(0, 90, 1.75, 1.5);
        assertEquals(59.0, snell.calculateTheta1(), DELTA);

        // Case 5: Max-, Nom, Nom
        snell = new Snell(0, 89, 1.75, 1.5);
        assertEquals(58.98, snell.calculateTheta1(), DELTA);

        // Case 6: Max+, Nom, Nom
        snell = new Snell(0, 91, 1.75, 1.5);
        assertEquals(-1, snell.calculateTheta1(), DELTA);

        // Case 7: Nom, Min, Nom
        snell = new Snell(0, 45, 1.0, 1.0);
        assertEquals(45.0, snell.calculateTheta1(), DELTA);

        // Case 8: Nom, Min+, Nom
        snell = new Snell(0, 45, 2.0, 1.5);
        assertEquals(32.03, snell.calculateTheta1(), DELTA);

        // Case 9: Nom, Min-, Nom
        snell = new Snell(0, 45, -1.0, 1.5);
        assertEquals(-1.0, snell.calculateTheta1(), DELTA);

        // Case 10: Nom, Max, Nom
        snell = new Snell(0, 45, 4.0, 1.5);
        assertEquals(15.38, snell.calculateTheta1(), DELTA);

        // Case 11: Nom, Max-, Nom
        snell = new Snell(0, 45, 3.0, 1.5);
        assertEquals(20.70, snell.calculateTheta1(), DELTA);

        // Case 12: Nom, Max+, Nom
        snell = new Snell(0, 45, 5.0, 1.5);
        assertEquals(-1.0, snell.calculateTheta1(), DELTA);

        // Case 13: Nom, Nom, Min
        snell = new Snell(0, 45, 1.5, 1.0);
        assertEquals(28.12, snell.calculateTheta1(), DELTA);

        // Case 14: Nom, Nom, Min+
        snell = new Snell(0, 45, 1.5, 2.0);
        assertEquals(70.53, snell.calculateTheta1(), DELTA);

        // Case 15: Nom, Nom, Min-
        snell = new Snell(0, 45, 1.5, -1.0);
        assertEquals(-1.0, snell.calculateTheta1(), DELTA);

        // Case 16: Nom, Nom, Max
        snell = new Snell(0, 45, 4.0, 4.0);
        assertEquals(45.0, snell.calculateTheta1(), DELTA);

        // Case 17: Nom, Nom, Max-
        snell = new Snell(0, 45, 4.0, 3.0);
        assertEquals(32.03, snell.calculateTheta1(), DELTA);

        // Case 18: Nom, Nom, Max+
        snell = new Snell(0, 45, 1.5, 5.0);
        assertEquals(-1.0, snell.calculateTheta1(), DELTA);

        // Case 19: Nom, Nom, Nom
        snell = new Snell(0, 25, 3.0, 2.0);
        assertEquals(16.36, snell.calculateTheta1(), DELTA);
    }
    
    

}