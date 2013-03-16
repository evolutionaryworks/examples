package com.evolutionaryworks.mathsoperations;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.evolutionaryworks.mathsoperations.ArithmeticOperations;

public class ArithmeticOperationsExceptionTest {
	
	ArithmeticOperations operation;
	int x;
	int y;
	int result;
	
	@BeforeTest
	public void setup(){
		operation = new ArithmeticOperations();
		x = 4;
		y = 0;
		System.out.println("In before test");
	}

	@Test(expectedExceptions = ArithmeticException.class)
	public void divide() {
		result = operation.divide(x, y); 
	}
	
}
