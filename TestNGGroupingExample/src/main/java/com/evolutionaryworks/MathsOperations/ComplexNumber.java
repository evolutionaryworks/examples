package com.evolutionaryworks.MathsOperations;

class ComplexNumber{
	private int x; 
	private int y;

	public ComplexNumber(int x, int y){
		this.setX(x);
		this.setY(y);
	}

	@Override
	public String toString(){
		return String.valueOf(getX()) + " + " + String.valueOf(getY()) + "i";
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
