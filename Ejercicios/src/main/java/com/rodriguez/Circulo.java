
package com.rodriguez;

public class Circulo implements Figura {

	private double radio;

	final double pi = 3.1416;

	public Circulo(double radio){
		this.radio = radio;
	}


	@Override
	public Double getArea() {
		return pi * radio * radio;
	}


	@Override
	public Double getPerimetro() {
		return 2 * pi * radio;
	}


} // class
