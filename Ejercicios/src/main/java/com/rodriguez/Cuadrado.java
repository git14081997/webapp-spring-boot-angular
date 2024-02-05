
package com.rodriguez;

public class Cuadrado implements Figura {

	private double lado;

	public Cuadrado(Double sizeLado){
		this.lado = sizeLado;
	}

	@Override
	public Double getArea() {
		return lado * lado;
	}

	@Override
	public Double getPerimetro() {
		return lado * 4;
	}

} // class
