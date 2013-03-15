package com.evolutionaryworks.RESTAPITestingExample;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.DefaultHttpClient;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;


public class GoogleCurrencyApiTest {
	
	private String url;
	private HttpClient httpClient;
	private HttpUriRequest request;
	private HttpResponse httpResponse;
	
	@BeforeTest
	//Is it ok for setup to throw exceptions? Can move this to test method
	public void setup() throws ClientProtocolException, IOException {
		httpClient = new DefaultHttpClient();
//		System.out.println("Calling the api");
		url = "http://www.google.com/ig/calculator?hl=en&q=1USD=?INR";
		request  = new HttpGet(url);
		httpResponse = httpClient.execute( request );
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
