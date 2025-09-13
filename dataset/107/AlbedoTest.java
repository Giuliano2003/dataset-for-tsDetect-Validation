import static org.junit.Assert.assertEquals;
import org.junit.Test;

import LightSim.Albedo;

public class albedoTest {

    private static final double DELTA = 1e-6; // tolerance for floating point comparisons

    @Test
    public void testCalculateAlbedo() {

        Albedo albedo = new Albedo(500, 1);
        assertEquals(500, albedo.calculateAlbedo(), DELTA);


        albedo = new Albedo(500, 0);
        assertEquals(-1.0, albedo.calculateAlbedo(), DELTA);


        albedo = new Albedo(500, 500);
        assertEquals(1, albedo.calculateAlbedo(), DELTA);


        albedo = new Albedo(500, 1000);
        assertEquals(0.5, albedo.calculateAlbedo(), DELTA);


        albedo = new Albedo(500, 999);
        assertEquals(0.5005, albedo.calculateAlbedo(), DELTA);


        albedo = new Albedo(999, 500);
        assertEquals(1.998, albedo.calculateAlbedo(), DELTA);


        albedo = new Albedo(1000, 500);
        assertEquals(2, albedo.calculateAlbedo(), DELTA);


        albedo = new Albedo(0, 500);
        assertEquals(-1, albedo.calculateAlbedo(), DELTA);


        albedo = new Albedo(1, 500);
        assertEquals(0.002, albedo.calculateAlbedo(), DELTA);

        albedo = new Albedo(250, 250);
        assertEquals(1, albedo.calculateAlbedo(), DELTA);


        albedo = new Albedo(501, 501);
        assertEquals(1, albedo.calculateAlbedo(), DELTA);


        albedo = new Albedo(599, 99);
        assertEquals(6.05, albedo.calculateAlbedo(), DELTA);


        albedo = new Albedo(97, 7600);
        assertEquals(0.012, albedo.calculateAlbedo(), DELTA);


        albedo = new Albedo(700, 499);
        assertEquals(1.402, albedo.calculateAlbedo(), DELTA);


        albedo = new Albedo(9, 12);
        assertEquals(0.75, albedo.calculateAlbedo(), DELTA);


        albedo = new Albedo(456, 333);
        assertEquals(1.369, albedo.calculateAlbedo(), DELTA);


        albedo = new Albedo(333, 500);
        assertEquals(0.666, albedo.calculateAlbedo(), DELTA);


        albedo = new Albedo(333333, 500);
        assertEquals(666.666, albedo.calculateAlbedo(), DELTA);
    }
}