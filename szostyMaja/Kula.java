package com.java.upsl.szostyMaja;

public class Kula extends Kolo{
	
	String nazwa="Kula";
	double _promien;
	
	public Kula(double promien) {
		super(promien);
		_promien = promien;
		// TODO Auto-generated constructor stub
	}
	
	public String Nazwa() {
		return nazwa;
	}
	public double Pole() {
		return 4*super.Pole(); //pole kola = pi*r^2
	}
	
	
	public double Objetosc()
	{
		double pole=Pole();  //pole kuli - 4*pi*r^2
		return (pole*_promien)/3; //4/3 * pi * r^3
	}
	
	public void Wyswietl() {
		super.Wyswietl();
		System.out.print(" objetosc - " + Objetosc());
	}

}
