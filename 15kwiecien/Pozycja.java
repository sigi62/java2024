package com.java.upsl;

public class Pozycja {
	
	String NazwaTowaru;
	int IleSztuk;
	double Cena;
	double cenaPozycji;
	
	public Pozycja(String nazwaTowaru, int ileSztuk, double cena)
	{
		NazwaTowaru = nazwaTowaru;
		IleSztuk = ileSztuk;
		Cena = cena;
		cenaPozycji = ObliczWartosc();
	}

	public double ObliczWartosc() {
		return IleSztuk * Cena;
 
	}
	
	@Override
	public String toString()
	{
		return NazwaTowaru + "		" + Cena + " zl   " + IleSztuk + " szt.   "+ cenaPozycji + " zl ";
			
	}
}
