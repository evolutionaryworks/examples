package com.evolutionaryworks.RESTAPITestingExample;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CurrencyConverterTestWithMock {

	CurrencyConverter converter;
	
	@BeforeTest
	public void setup(){
		converter = new CurrencyConverter();
	}

	@Test
	public void getRoundedValue() {
		int actual = converter.getRoundedValue();
		Assert.assertEquals(actual, 54);
	}
}
