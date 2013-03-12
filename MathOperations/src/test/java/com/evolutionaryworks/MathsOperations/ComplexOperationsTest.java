package com.evolutionaryworks.MathsOperations;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ComplexOperationsTest {

	ComplexNumber c1;
	ComplexNumber c2;
	ComplexNumber result;
	ComplexOperations cOperation = new ComplexOperations();
	
	@BeforeMethod
	public void setup(){
		c1 = new ComplexNumber(4, 2);
		c2 = new ComplexNumber(1, 1);
	}

	@Test
	public void ComplexSubtract() {
		result = cOperation.complexSubtract(c1, c2);
		Assert.assertEquals(result.toString(), "3 + 1i");
	}

	@Test
	public void ComplexSum() {
		result = cOperation.complexSum(c1, c2);
		Assert.assertEquals(result.toString(), "5 + 3i");
	}
}
