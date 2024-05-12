package com.java.upsl.szostyMaja;

public class szoostyMaja {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Figura figura = new Figura();
		figura.Wyswietl();
		System.out.println("");
		Kolo kolo = new Kolo(2);
		kolo.Wyswietl();
		System.out.println("");
		Kula kula  = new Kula(2);
		kula.Wyswietl();
		System.out.println("");
		Stozek stozek = new Stozek(3,2);
		stozek.Wyswietl();
		System.out.println("");
		Walec walec = new Walec(3,2);
		walec.Wyswietl();
		
	}

}
