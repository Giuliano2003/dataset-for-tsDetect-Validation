

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import LightSim.Snell;

import org.junit.jupiter.api.DisplayName;

/* 
 * Theta1 -> (-inf,0], [T1], [91,inf)
 * T1 = degree between 0-90
 * 
 * Theta2 -> (-inf,0], [T2], [91,inf)
 * T2 = degree between 0-90
 *
 * Index1 -> (-inf,1],[I1],[4.1,inf) 
 * I1 = index between 1-4
 * 
 * Index2 -> (-inf,1],[I2],[4.1,inf) 
 * I2 = index between 1-4
 * 
 * */

/* https://github.com/Conner-Williams/Reflection-Refraction-Light-Simulator/blob/937b37d9c27fd5062f8e53fa5898d67049246fed/LightSimulator/LightSimulatorTest/EquivalenceClassTest.java */

class EquivalenceClassTest{
	
	private static final double DELTA = 1e-2; // tolerance for floating point comparisons

	@Test
	@DisplayName("Test all cases for calculateIndex1")
	void testCalculateIndex1() {
		
		Snell snellTest;
		//theta1, theta2, idnex1, index2
		
		//case 1: 	(-inf,0]	(-inf,0]	(-inf,1]
		snellTest = new Snell(-1,-1,0,-1);
		assertEquals(-1, snellTest.calculateIndex1(), DELTA);
	
		//case 2: (-inf,0]	[T2]	(-inf,1]
		snellTest = new Snell(-1,45,0,-1);
		assertEquals(-1, snellTest.calculateIndex1(), DELTA);
		
		//case 3: (-inf,0]	[91,inf)	(-inf,1]
		snellTest = new Snell(-1,91,0,-1);
		assertEquals(-1, snellTest.calculateIndex1(), DELTA);
		
		//case 4:[T1]	(-inf,0]	(-inf,1]
		snellTest = new Snell(45,-1,0,-1);
		assertEquals(-1, snellTest.calculateIndex1(), DELTA);
		
		//case 5:[T1]	[T2]	(-inf,1]
		snellTest = new Snell(45,45,0,-1);
		assertEquals(-1, snellTest.calculateIndex1(), DELTA);
		
		//case 6:[T1]	[91,inf)	(-inf,1]
		snellTest = new Snell(45,91,0,-1);
		assertEquals(-1, snellTest.calculateIndex1(), DELTA);
		
		//case 7:[91,inf)	(-inf,0]	(-inf,1]
		snellTest = new Snell(91,-1,0,-1);
		assertEquals(-1, snellTest.calculateIndex1(), DELTA);
		
		//case 8:[91,inf)	[T2]	(-inf,1]
		snellTest = new Snell(91,45,0,-1);
		assertEquals(-1, snellTest.calculateIndex1(), DELTA);
		
		//case 9:[91,inf)	[91,inf)	(-inf,1]
		snellTest = new Snell(91,91,0,-1);
		assertEquals(-1, snellTest.calculateIndex1(), DELTA);
		
		//case 10:(-inf,0]	(-inf,0]	[I2]
		snellTest = new Snell(-1,-1,0,2);
		assertEquals(-1, snellTest.calculateIndex1(), DELTA);
		
		//case 11:(-inf,0]	[T2]	[I2]
		snellTest = new Snell(-1,45,0,2);
		assertEquals(-1, snellTest.calculateIndex1(), DELTA);
		
		//case 12:(-inf,0]	[91,inf)	[I2]
		snellTest = new Snell(-1,91,0,2);
		assertEquals(-1, snellTest.calculateIndex1(), DELTA);
		
		//case 13:[T1]	(-inf,0]	[I2]
		snellTest = new Snell(45,-1,0,2);
		assertEquals(-1, snellTest.calculateIndex1(), DELTA);
		
		//case 14:[T1]	[T2]	[I2]
		snellTest = new Snell(45,45,0,2);
		assertEquals(2, snellTest.calculateIndex1(), DELTA);
		
		//case 15:	[T1]	[91,inf)	[I2]
		snellTest = new Snell(45,91,0,2);
		assertEquals(-1, snellTest.calculateIndex1(), DELTA);
		
		//case 16:[91,inf)	(-inf,0]	[I2]
		snellTest = new Snell(91,-1,0,2);
		assertEquals(-1, snellTest.calculateIndex1(), DELTA);
		
		//case 17:[91,inf)	[T2]	[I2]
		snellTest = new Snell(91,45,0,2);
		assertEquals(-1, snellTest.calculateIndex1(), DELTA);
		
		//case 18:[91,inf)	[91,inf)	[I2]
		snellTest = new Snell(91,91,0,2);
		assertEquals(-1, snellTest.calculateIndex1(), DELTA);
		
		//case 19:(-inf,0]	(-inf,0]	[4.1,inf)
		snellTest = new Snell(-1,-1,0,4.1);
		assertEquals(-1, snellTest.calculateIndex1(), DELTA);
		
		//case 20:(-inf,0]	[T2]	[4.1,inf)
		snellTest = new Snell(-1,45,0,4.1);
		assertEquals(-1, snellTest.calculateIndex1(), DELTA);

		//case 21:(-inf,0]	[91,inf)	[4.1,inf)
		snellTest = new Snell(-1,91,0,4.1);
		assertEquals(-1, snellTest.calculateIndex1(), DELTA);
		
		//case 22:[T1]	(-inf,0]	[4.1,inf)
		snellTest = new Snell(-1,-1,0,4.1);
		assertEquals(-1, snellTest.calculateIndex1(), DELTA);
		
		//case 23:	[T1]	[T2]	[4.1,inf)
		snellTest = new Snell(45,45,0,4.1);
		assertEquals(-1, snellTest.calculateIndex1(), DELTA);
		
		//case 24:[T1]	[91,inf)	[4.1,inf)
		snellTest = new Snell(45,91,0,4.1);
		assertEquals(-1, snellTest.calculateIndex1(), DELTA);
		
		//case 25:[91,inf)	(-inf,0]	[4.1,inf)
		snellTest = new Snell(91,-1,0,4.1);
		assertEquals(-1, snellTest.calculateIndex1(), DELTA);
		
		//case 26:[91,inf)	[T2]	[4.1,inf)
		snellTest = new Snell(91,45,0,4.1);
		assertEquals(-1, snellTest.calculateIndex1(), DELTA);
		
		//case 27:[91,inf)	[91,inf)	[4.1,inf)
		snellTest = new Snell(91,91,0,4.1);
		assertEquals(-1, snellTest.calculateIndex1(), DELTA);
		
	}
	
}