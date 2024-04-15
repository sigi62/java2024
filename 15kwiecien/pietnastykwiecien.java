package com.java.upsl;
import java.io.*;



public class pietnastykwiecien {

	public static void main(String [] args) throws IOException {
		Pozycja p1 = new Pozycja("Chleb", 1, 3.5);
		System.out.println(p1);
		Pozycja p2 = new Pozycja("Cukier", 3, 4);
		System.out.println(p2);
		
		Zamowienie z = new Zamowienie();
		z.DodajPozycje(p1);
		z.DodajPozycje(p2);
		System.out.println("\nDrukowanie zamowienia:\n");
		System.out.println(z);
	}
	

}
