package com.luisfuentes.tareaapi;

public class Calculator {

	private int num1;
	private int num2;

	public Calculator(int a, int b) {
		num1 = a;
		num2 = b;
	}

	public int addition() {
		int result = num1 + num2;
		return result;
	}

	public int subtraction() {
		int result = num1 - num2;
		return result;
	}

	public int division() {
		int result = num1 / num2;
		return result;
	}

	public int multiplication() {
		int result = num1 * num2;
		return result;
	}

	public int module() {
		int result = num1 % num2;
		return result;
	}
}
