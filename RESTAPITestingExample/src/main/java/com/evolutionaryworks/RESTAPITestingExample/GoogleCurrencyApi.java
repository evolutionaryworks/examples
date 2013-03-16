package com.evolutionaryworks.RESTAPITestingExample;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

import com.evolutionaryworks.RESTAPITestingExample.model.CurrencyMap;
import com.google.gson.Gson;

public class GoogleCurrencyApi {

	private String url;
	private HttpClient httpClient;
	private HttpUriRequest request;
	private HttpResponse httpResponse;

	public GoogleCurrencyApi() {
		url = "http://www.google.com/ig/calculator?hl=en&q=1USD=?INR";
		httpClient = new DefaultHttpClient();
		request  = new HttpGet(url);
	}
	
	public HttpResponse apiResponse(){
		try {
			httpResponse = httpClient.execute( request );
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return httpResponse;
	}
	
	public String getResponseJSON(){
		HttpResponse response = apiResponse();
		String jsonResponse = "";
		try {
			jsonResponse =  IOUtils.toString(response.getEntity().getContent());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(jsonResponse);
		return jsonResponse;
	}
	
	public CurrencyMap getResponseAsPOJO(){
		Gson gson = new Gson();
		return gson.fromJson(getResponseJSON(), CurrencyMap.class);
	}
	
}
