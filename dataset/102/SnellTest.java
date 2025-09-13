import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import LightSim.Snell;

import org.junit.jupiter.api.DisplayName;

public class DecisiontableBasedTest {
	
	private static final double DELTA = 1e-2; // tolerance for floating point comparisons
	
	@Test
	@DisplayName("Test A1: Calculate Theta 1")
	void testCalculateTheta1() {
		
		Snell snellTest;
		//theta1, theta2, idnex1, index2
		
		//case: 	45,2,2
		snellTest = new Snell(0,45,2,2);
		assertEquals(45, snellTest.calculateTheta1(), DELTA);
		
	}
	
	@Test
	@DisplayName("Test A2: Calculate Theta 2")
	void testCalculateTheta2() {
		
		Snell snellTest;
		//theta1, theta2, idnex1, index2
		
		//case: 	45,2,2
		snellTest = new Snell(45,0,2,2);
		assertEquals(45, snellTest.calculateTheta2(), DELTA);
		
	}
	
	@Test
	@DisplayName("Test A3: Calculate Index 1")
	void testCalculateIndex1() {
		
		Snell snellTest;
		//theta1, theta2, idnex1, index2
		
		//case: 	45,45,2
		snellTest = new Snell(45,45,0,2);
		assertEquals(2, snellTest.calculateIndex1(), DELTA);
		
	}
	
	@Test
	@DisplayName("Test A4: Calculate Index 2")
	void testCalculateIndex2() {
		
		Snell snellTest;
		//theta1, theta2, idnex1, index2
		
		//case: 	45,45,2
		snellTest = new Snell(45,45,2,0);
		assertEquals(2, snellTest.calculateIndex2(), DELTA);
		
	}
	
	@Test
	@DisplayName("Test A5: Invalid Input C1 Theta 1 less than 0: True")
	void testA5C1() {
		
		Snell snellTest;
		//theta1, theta2, idnex1, index2
		
		//case: 	45,45,-1
		snellTest = new Snell(45,45,-1,0);
		assertEquals(-1, snellTest.calculateIndex2(), DELTA);
		
	}
	
	@Test
	@DisplayName("Test A5: Invalid Input C3 C3: Theta 1 more than 90: True")
	void testA5C3() {
		
		Snell snellTest;
		//theta1, theta2, idnex1, index2
		
		//case: 	45,45,-1
		snellTest = new Snell(45,45,91,0);
		assertEquals(-1, snellTest.calculateIndex2(), DELTA);
		
	}
	
	@Test
	@DisplayName("Test A5: Invalid Input C4 Theta 2 less than 0: True")
	void testA5C4() {
		
		Snell snellTest;
		//theta1, theta2, idnex1, index2
		
		//case: 	45,45,-1
		snellTest = new Snell(45,45,0,-1);
		assertEquals(-1, snellTest.calculateTheta1(), DELTA);
		
	}
	
	@Test
	@DisplayName("Test A5: Invalid Input C6 C6: Theta 2 more than 90: True")
	void testA5C6() {
		
		Snell snellTest;
		//theta1, theta2, idnex1, index2
		
		//case: 	45,45,91
		snellTest = new Snell(45,45,0,91);
		assertEquals(-1, snellTest.calculateTheta1(), DELTA);
		
	}
	
	@Test
	@DisplayName("Test A5: Invalid Input C7 Index 1 less than 1: True")
	void testA5C7() {
		
		Snell snellTest;
		//theta1, theta2, idnex1, index2
		
		//case: 	45,45,-1
		snellTest = new Snell(45,45,-1,0);
		assertEquals(-1, snellTest.calculateIndex2(), DELTA);
		
	}
	
	@Test
	@DisplayName("Test A5: Invalid Input C9 Index 1 more than 4: True")
	void testA5C9() {
		
		Snell snellTest;
		//theta1, theta2, idnex1, index2
		
		//case: 	45,45,91
		snellTest = new Snell(45,45,4.1,0);
		assertEquals(-1, snellTest.calculateIndex2(), DELTA);
		
	}
	
	@Test
	@DisplayName("Test A5: Invalid Input C10 Index 2 less than 1: True")
	void testA5C10() {
		
		Snell snellTest;
		//theta1, theta2, idnex1, index2
		
		//case: 	45,45,-1
		snellTest = new Snell(45,45,0,-1);
		assertEquals(-1, snellTest.calculateIndex1(), DELTA);
		
	}
	
	@Test
	@DisplayName("Test A5: Invalid Input C12 Index 2 more than 4: True")
	void testA5C12() {
		
		Snell snellTest;
		//theta1, theta2, idnex1, index2
		
		//case: 	45,45,-1
		snellTest = new Snell(45,45,0,4.1);
		assertEquals(-1, snellTest.calculateIndex1(), DELTA);
		
	}
	
	
	
}