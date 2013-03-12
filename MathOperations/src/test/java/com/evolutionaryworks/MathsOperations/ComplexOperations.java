package com.evolutionaryworks.MathsOperations;

public class ComplexOperations {
	
	public ComplexNumber sum(ComplexNumber c1, ComplexNumber c2){
		ComplexNumber cResult = new ComplexNumber(1,1);
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
