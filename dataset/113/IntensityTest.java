import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import LightSim.Intensity;

public class intensityTest {
	private static final double DELTA = 1e-2; // tolerance for floating point comparisons

	@Test
	public void testIntensity() {
		Intensity intensity = new Intensity(0, 1000, 10, 20);
		double result = intensity.calculateIntensity(1000, 10, 20);
        assertEquals(5.0, result);
        
        result = intensity.calculateIntensity(100, 20);
        assertEquals(5.0, result);
        
        result = intensity.calculateIntensity(500, 49);
        assertEquals(10.20, result, DELTA);
        
        result = intensity.calculateIntensity(100, 20, 45);
        assertEquals(0.11, result, DELTA);
        
        result = intensity.calculateIntensity(1000, 10, 0);
        assertEquals(-1, result);
        
        
        result = intensity.calculateIntensity(1000, 0);
        assertEquals(-1, result);
        
        result = intensity.calculateIntensity(1000, 0, 20);
        assertEquals(-1, result);
        
        result = intensity.calculateIntensity(-1000, 10, 20);
        assertEquals(-1, result);
        
        result = intensity.calculateIntensity(-100, 20);
        assertEquals(-1, result);
        
	}

}