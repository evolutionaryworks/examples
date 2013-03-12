package com.evolutionaryworks.MathsOperations;

public class ComplexOperations {
	
	public ComplexNumber ComplexSum(ComplexNumber c1, ComplexNumber c2){
		
		int xResult = c1.x + c2.x;
		int yResult = c1.y + c2.y;
		ComplexNumber cResult = new ComplexNumber(xResult,yResult);
		return cResult;
	}

public ComplexNumber ComplexSubtract(ComplexNumber c1, ComplexNumber c2){
		
		int xResult = c1.x - c2.x;
		int yResult = c1.y - c2.y;
		ComplexNumber cResult = new ComplexNumber(xResult,yResult);
		return cResult;
	}

	
}

class ComplexNumber{
	int x; 
	int y;
	
	public ComplexNumber(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString(){
		return String.valueOf(x) + " i" + String.valueOf(y);
	}
	
}
