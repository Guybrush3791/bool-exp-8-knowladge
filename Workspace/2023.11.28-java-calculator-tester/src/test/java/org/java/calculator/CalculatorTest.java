package org.java.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

	Calculator c = null;
	
	@BeforeEach
	public void init() {
		
		c = new Calculator();
	}
	
	@Test
	public void goodAddTest() {
		
		int x = 10;
		int y = 20;
		int z = x + y;
		
		assertEquals(z, c.add(x, y));
	}
	@Test
	public void goodSubtractTest() {
		
		int x = 10;
		int y = 20;
		int z = x - y;
		
		assertEquals(z, c.subtract(x, y));
	}
	@Test 
	public void goodDivideTest() throws Exception {
		
		int x = 50;
		int y = 5;
		int z = x / y;
		
		assertEquals(z, c.divide(x, y));
	}
	@Test 
	public void badDivideTest() throws Exception {
		
		int x = 50;
		int y = 0;
		
		assertThrows(Exception.class, () -> c.divide(x, y));
	}
	@Test
	public void goodMultiplyTest() {
		
		int x = 10;
		int y = 20;
		int z = x * y;
		
		assertEquals(z, c.multiply(x, y));
	}
}
