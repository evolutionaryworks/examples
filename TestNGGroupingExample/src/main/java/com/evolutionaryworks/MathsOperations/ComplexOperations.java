package com.evolutionaryworks.MathsOperations;

public class ComplexOperations {

	public ComplexNumber complexSum(ComplexNumber c1, ComplexNumber c2){

		int xResult = c1.getX() + c2.getX();
		int yResult = c1.getY() + c2.getY();
		ComplexNumber cResult = new ComplexNumber(xResult,yResult);
		return cResult;
	}

	public ComplexNumber complexSubtract(ComplexNumber c1, ComplexNumber c2){

		int xResult = c1.getX() - c2.getX();
		int yResult = c1.getY() - c2.getY();
		ComplexNumber cResult = new ComplexNumber(xResult,yResult);
		return cResult;
	}


}

