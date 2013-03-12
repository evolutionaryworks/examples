package com.evolutionaryworks.HelloWorld;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class HelloWorldTestV2 {
	public HelloWorld hello;

	@BeforeTest
	public void beforeMethod() {
		hello = new HelloWorld();  
	}


	@Test
	public void getMessage() {
		hello.setMessage("Hello! World");  
		Assert.assertEquals(hello.getMessage(), "Hello! World");
	}

	@Test
	public void setMessage() {
		hello.setMessage("Hello! World Again");  
		Assert.assertEquals(hello.getMessage(), "Hello! World Again");
	}
}
