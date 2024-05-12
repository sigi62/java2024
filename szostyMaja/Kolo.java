package com.java.upsl.szostyMaja;

public class Kolo extends Figura{
	
	String nazwa = "Kolo";
	double _promien;

	public Kolo(double promien) {
		super();
		_promien = promien;
	}
	
	public String Nazwa()
	{
		return nazwa;
	}
	public double Pole() {
		return Math.PI*_promien*_promien;
	}
	
	public void Wyswietl() {
		super.Wyswietl();
		System.out.print("- "+Nazwa());
		System.out.print(" pole figury - "+Pole());
		
	}
}
