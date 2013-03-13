package com.evolutionaryworks.MathsOperations;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ArithmeticOperationsExceptionTest {
	
	ArithmeticOperations operation;
	int x;
	int y;
	int result;
	
	@BeforeTest(groups={"Exception"})
	public void setup(){
		operation = new ArithmeticOperations();
		x = 4;
		y = 0;
		System.out.println("In before test");
	}

	@Test(expectedExceptions = ArithmeticException.class, groups = {"Exception"})
	public void divide() {
		result = operation.divide(x, y); 
	}
	
}
