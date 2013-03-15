package com.evolutionaryworks.RESTAPITestingExample.model;

public class CurrencyMap {
	
	
	private	String lhs;
	
	
	private String rhs;
	

	public String getLhs() {
		return lhs;
	}

	public void setLhs(String lhs) {
		this.lhs = lhs;
	}

	public String getRhs() {
		return rhs;
	}

	public void setRhs(String rhs) {
		this.rhs = rhs;
	}
	
	@Override
	public String toString(){
		return lhs + " = " + rhs;
	}
}
