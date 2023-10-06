package com.luisfuentes.tareaapi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void testAddition() {
		Calculator calculator = new Calculator(20,10);
				int result = calculator.addition();
				assertEquals(30, result);
	}

	@Test
	void testSubtraction() {
		Calculator calculator = new Calculator(20,10);
		int result = calculator.subtraction();
		assertEquals(10, result);
	}

	@Test
	void testDivision() {
		Calculator calculator = new Calculator(10,2);
		int result = calculator.division();
		assertEquals(5, result);
	}

	@Test
	void testMultiplication() {
		Calculator calculator = new Calculator(5,2);
		int result = calculator.multiplication();
		assertEquals(10, result);
	}

	@Test
	void testModule() {
		Calculator calculator = new Calculator(10,20);
		int result = calculator.module();
		assertEquals(10, result);
	}

}
