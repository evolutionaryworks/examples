package com.evolutionaryworks.HelloWorld;

import org.testng.annotations.Test;
import org.testng.Assert;

public class HelloWorldTestV1 {
	public HelloWorld hello;

	@Test
	public void getMessage() {
		hello = new HelloWorld();
		hello.setMessage("Hello! World");  
		Assert.assertEquals(hello.getMessage(), "Hello! World");
	}

	@Test
	public void setMessage() {
		hello = new HelloWorld();
		hello.setMessage("Hello! World Again");  
		Assert.assertEquals(hello.getMessage(), "Hello! World Again");
	}
}