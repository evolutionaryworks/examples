package com.evolutionaryworks.RESTAPITestingExample;

import com.evolutionaryworks.RESTAPITestingExample.model.CurrencyMap;
import com.google.gson.Gson;


public class CurrencyConverter 
{
	private GoogleCurrencyApi googleApi;
	private CurrencyMap currencyMap;

	public CurrencyConverter(){
		googleApi = new GoogleCurrencyApi();
		currencyMap = null;
	}
	
	public CurrencyMap getCurrencyMap() {
		return this.currencyMap;
	}
	
	private void setCurrencyMap(){
		this.currencyMap = googleApi.getResponseAsPOJO();
	}
	
	public int getRoundedValue(){
		if (currencyMap == null) setCurrencyMap();
		String val = currencyMap.getRhs().substring(0, 9);
		Double doubleVal = Double.parseDouble(val);
		return doubleVal.intValue();
	}
	
	public static void main(String[] args) {
		CurrencyConverter con = new CurrencyConverter();
		System.out.println(con.getRoundedValue());
	}
	
}
