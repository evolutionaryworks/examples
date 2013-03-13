package com.evolutionaryworks.MathsOperations;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ArithmeticOperationsV2Test {

	ArithmeticOperations operation;
	private int result;
	
	@BeforeTest
	public void setup(){
		operation = new ArithmeticOperations();
		System.out.println("In v2 before test");
	}

	@Parameters({"x", "y", "expected"})
	@Test
	public void subtract(int x, int y, int expected) {
		result = operation.subtract(x, y);
		Assert.assertEquals(result, expected);
	}

}
