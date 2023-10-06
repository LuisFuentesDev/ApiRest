package com.luisfuentes.tareaapi;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	Calculator calculator = new Calculator();

	@Test
	void testAddition() {

		// given
		int a = 10;
		int b = 5;

		// when
		int expectedResult = calculator.addition(a, b);

		// then
		int result = 15;
		assertThat(expectedResult).isEqualTo(result);
	}

	@Test
	void testSubtraction() {
		// given
		int a = 10;
		int b = 5;

		// when
		int expectedResult = calculator.subtraction(a, b);

		// then
		int result = 5;
		assertThat(expectedResult).isEqualTo(result);
		;
	}

	@Test
	void testDivision() {
		// given
		int a = 20;
		int b = 5;

		// when
		int expectedResult = calculator.division(a, b);

		// then
		int result = 4;
		assertThat(expectedResult).isEqualTo(result);
	}

	@Test
	void testMultiplication() {
		// given
		int a = 10;
		int b = 5;

		// when
		int expectedResult = calculator.multiplication(a, b);

		// then
		int result = 50;
		assertThat(expectedResult).isEqualTo(result);
	}

	@Test
	void testModule() {
		// given
		int a = 5;
		int b = 3;

		// when
		int expectedResult = calculator.module(a, b);

		// then
		int result = 2;
		assertThat(expectedResult).isEqualTo(result);
	}

}
