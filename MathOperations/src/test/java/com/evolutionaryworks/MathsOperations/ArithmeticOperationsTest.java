package com.evolutionaryworks.MathsOperations;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ArithmeticOperationsTest {
	
	ArithmeticOperations operation;
	int x;
	int y;
	int result;
	
	@BeforeTest
	public void setup(){
		operation = new ArithmeticOperations();
		x = 4;
		y = 2;
		System.out.println("In before test");
	}

	@Test
	public void divide() {
		result = operation.divide(x, y); 
		Assert.assertEquals(result, 2);
	}

	@Test
	public void multiply() {
		result = operation.multiply(x, y);
		Assert.assertEquals(result, 8);
	}

	@Test
	public void subtract() {
		result = operation.subtract(x, y);
		Assert.assertEquals(result, 2);
	}

	@Test
	public void sum() {
		result = operation.sum(x, y);
		Assert.assertEquals(result, 6);
	}
}
