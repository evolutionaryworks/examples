package com.evolutionaryworks.mathsoperations;

public class ArithmeticOperationsV2 extends ArithmeticOperations {
	
	@Override
	public int subtract(int x, int y){
		if (x > y)
			return x - y;
		else
			return y - x;
	}
	
	public int sum(int x, int y, int...z){
		int sum = x + y;
		if (z.length > 0){
			for(int i = 0; i< z.length; i++){
				sum += z[0];
			}
		}
		return sum;
	}
	
}
