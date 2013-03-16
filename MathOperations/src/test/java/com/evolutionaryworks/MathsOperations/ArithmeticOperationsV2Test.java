package com.evolutionaryworks.mathsoperations;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.evolutionaryworks.mathsoperations.ArithmeticOperations;

public class ArithmeticOperationsV2Test {

	ArithmeticOperations operation;
	private int x;
	private int y;
	private int result;
	
	@BeforeTest
	public void setup(){
		operation = new ArithmeticOperations();
		x = 4;
		y = 2;
		System.out.println("In v2 before test");
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
