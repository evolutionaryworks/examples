package com.evolutionaryworks.RESTAPITestingExample;

import org.apache.http.HttpResponse;
import org.apache.http.entity.ContentType;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;


public class GoogleCurrencyApiTestWithStubs {
	
	GoogleCurrencyApi googleApi;
	HttpResponse httpResponse;
	
	@BeforeTest
	//Is it ok for setup to throw exceptions? Can move this to test method
	public void setup(){
		googleApi = new GoogleCurrencyApi();
		httpResponse = googleApi.apiResponse();
	}

	@Test
	public void testResponseCode(){
		int statusCode = httpResponse.getStatusLine().getStatusCode();
		Assert.assertEquals( statusCode, 200 );
	}
	
	@Test
	public void testMimeCode(){
		String jsonMimeType = "text/html";
		ContentType type  = ContentType.getOrDefault(httpResponse.getEntity());
		String mimeType = type.getMimeType();
		System.out.println(mimeType);
		Assert.assertEquals(mimeType, jsonMimeType);
	}

}
