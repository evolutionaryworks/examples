package com.evolutionaryworks.RESTAPITestingExample;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

import com.evolutionaryworks.RESTAPITestingExample.model.CurrencyMapper;
import com.google.gson.Gson;


public class CurrencyConverter 
{
	private String url;
	private HttpClient httpClient;
	private HttpUriRequest request;
	private HttpResponse httpResponse;
	private CurrencyMapper currencyMap;

	public CurrencyConverter(){
		url = "http://www.google.com/ig/calculator?hl=en&q=1USD=?INR";
		httpClient = new DefaultHttpClient();
		request  = new HttpGet(url);
		currencyMap = null;
	}
	
	public CurrencyMapper getCurrencyMap() {
		return this.currencyMap;
	}
	
	private void setCurrencyMap(){
		String content = "";
		Gson gson = new Gson();
		
		try {
			httpResponse = httpClient.execute( request );
			content = IOUtils.toString(httpResponse.getEntity().getContent());
			System.out.println(content);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.currencyMap = gson.fromJson(content, CurrencyMapper.class);
	}
	
	public int getRoundedValue(){
		if (currencyMap == null) setCurrencyMap();
		String val = currencyMap.getRhs().substring(0, 9);
		Double doubleVal = Double.parseDouble(val);
		return doubleVal.intValue();
	}
	
	
	public static void main(String[] args) {
		CurrencyConverter converter = new CurrencyConverter();
		System.out.println(converter.getRoundedValue());
	}

	
}
