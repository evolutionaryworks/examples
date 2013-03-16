package com.evolutionaryworks.MathsOperations;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ArithmeticOperationsTest {
	
	
	private ArithmeticOperations operation;
	private int x;
	private int y;
	private int result;
	
	@BeforeTest(groups={"Smoke", "Regression"})
	public void setup(){
		operation = new ArithmeticOperations();
		x = 4;
		y = 2;
		System.out.println("In before test");
	}

	@Test(groups = {"Smoke", "Regression"})
	public void divide() {
		result = operation.divide(x, y); 
		Assert.assertEquals(result, 2);
	}

	@Test(groups = {"Smoke", "Regression"})
	public void multiply() {
		result = operation.multiply(x, y);
		Assert.assertEquals(result, 8);
	}

	@Test(groups = {"Smoke", "Regression"})
	public void subtract() {
		result = operation.subtract(x, y);
		Assert.assertEquals(result, 2);
	}
	
	@Test(groups = {"Regression"})
	public void subtractGetNegative() {
		int x1 = 2;
		int y1 = 4;
		result = operation.subtract(x1, y1);
		Assert.assertEquals(result, -2);
	}

	@Test(groups = {"Smoke", "Regression"})
	public void sum() {
		result = operation.sum(x, y);
		Assert.assertEquals(result, 6);
	}
	
	@AfterMethod
	public void teardown(Method m){
		System.out.println("After test for "+m.getName());
	}
}
