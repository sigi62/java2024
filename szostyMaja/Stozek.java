package com.java.upsl.szostyMaja;

public class Stozek extends Kolo{
	
	String nazwa = "Stozek";
	double _promien;
	double _wysokosc;
	double l;
	
	public Stozek(double promien, double wysokosc) {
		super(promien);
		_promien = promien;
		_wysokosc = wysokosc;
	}

	public String Nazwa() {
		return nazwa;
	}
	
	public double Pole() {
		l = Math.sqrt((_wysokosc*_wysokosc + _promien*_promien)); //l =sqrt(r^2+h^2)
		return Math.PI*_promien*l; //pi*r*l  - powierzchnia boczna
	}
	
	
	public double Objetosc()
	{
		return (_wysokosc * super.Pole())/3; //1/3 * pi * r^2* H
	}
	
	public void Wyswietl() {
		super.Wyswietl();
		System.out.print(" objetosc - " + Objetosc());
	}


}
