package com.evolutionaryworks.MathsOperations;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArithmeticOperationsTest {
	
	
	ArithmeticOperations operation;
	
	@BeforeTest
	public void setup(){
		operation = new ArithmeticOperations();
	}
	
	@DataProvider(name = "dataProvider")
	public Object[][] dp() {
	  return new Object[][] {
	    new Object[] {2, 3, 5}, 
	    new Object[] {4, 5, 9}, 
	  };
	}

	@Test(dataProvider = "dataProvider")
	public void sum(int x, int y, int expected) {
		int result = operation.sum(x, y);
		Assert.assertEquals(result, expected);
	}
}
