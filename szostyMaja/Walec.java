package com.java.upsl.szostyMaja;

public class Walec extends Kolo{
	
	String nazwa = "Walec";
	double _promien;
	double _wysokosc;
	

	public Walec(double promien, double wysokosc) {
		super(promien);
		_promien = promien;
		_wysokosc = wysokosc;
	}

	public String Nazwa() {
		return nazwa;
	}
	
	public double Pole() {
		return 2*Math.PI*_promien*_wysokosc; //2 pi*r*h  - powierzchnia boczna
	}
	
	
	public double Objetosc()
	{
		return _wysokosc * super.Pole(); // pi * r^2* H
	}
	
	public void Wyswietl() {
		super.Wyswietl();
		System.out.print(" objetosc - " + Objetosc());
	}

}
