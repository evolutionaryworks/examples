package com.evolutionaryworks.mathsoperations;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.evolutionaryworks.mathsoperations.ArithmeticOperations;

public class ArithmeticOperationsTest {
	
	
	ArithmeticOperations operation;
	private int x;
	private int y;
	private int result;
	
	@BeforeClass
	public void setup(){
		operation = new ArithmeticOperations();
		x = 4;
		y = 2;
		System.out.println("In before class");
	}
	
	@BeforeMethod
	public void beforeMethod(){
		System.out.println("In before method");
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
	public void subtractGetNegative() {
		int x1 = 2;
		int y1 = 4;
		result = operation.subtract(x1, y1);
		Assert.assertEquals(result, -2);
	}

	@Test
	public void sum() {
		result = operation.sum(x, y);
		Assert.assertEquals(result, 6);
	}
}
