package com.evolutionaryworks.RESTAPITestingExample;

import com.evolutionaryworks.RESTAPITestingExample.api.Currency;
import com.evolutionaryworks.RESTAPITestingExample.api.GoogleCurrencyApi;
import com.evolutionaryworks.RESTAPITestingExample.model.GoogleCurrencyApiResponse;
import com.evolutionaryworks.RESTAPITestingExample.util.ResponseBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.entity.ContentType;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;


public class GoogleCurrencyApiTest {
	
	private HttpResponse httpResponse;
    private GoogleCurrencyApi currencyApi;

    @BeforeClass
	public void setup(){
        currencyApi = new GoogleCurrencyApi("http://www.google.com/ig/calculator?hl=en");
        httpResponse = currencyApi.convert(Currency.USD, Currency.INR);
	}

	@Test
	public void testResponseCode(){
		int expectedStatusCode = httpResponse.getStatusLine().getStatusCode();
		Assert.assertEquals(expectedStatusCode, 200,"Status Code");
	}
	
	@Test(dependsOnMethods = {"testResponseCode"})
	public void testMimeCode(){
		String expectedContentType = "text/html";
        // Get Observed Mime Type
		ContentType type  = ContentType.getOrDefault(httpResponse.getEntity());
		String mimeType = type.getMimeType();
        // Assert
		Assert.assertEquals(mimeType, expectedContentType);
	}

    @Test(dependsOnMethods = {"testMimeCode"})
   	public void testDollarToRupee() throws IOException {
        GoogleCurrencyApiResponse googleResponse = ResponseBuilder.buildResponse(httpResponse.getEntity().getContent());
        Assert.assertEquals(googleResponse.getRhsValueAsInt(), 54);
   	}

}
