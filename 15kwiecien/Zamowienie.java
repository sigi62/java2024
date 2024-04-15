package com.java.upsl;
import java.util.ArrayList;
public class Zamowienie {

	ArrayList<Pozycja> pozycje = new ArrayList<Pozycja>();
	int ileDodanych = 0;	
	
	public Zamowienie()
	{
			
	}
	
	public void DodajPozycje(Pozycja p) {
		ileDodanych += 1;
		pozycje.add(p);
	}
	
	public double ObliczWartosc() {
		double suma = 0;
		for(int i =0;i< ileDodanych;i++)
		{
			suma += pozycje.get(i).cenaPozycji;
		}
		return suma;
	}
	
	@Override
	public String toString() {

        StringBuilder zamowienie = new StringBuilder();

		for(int i =0;i< ileDodanych;i++)
		{
			zamowienie.append(pozycje.get(i).toString() + "\n");
		}
		
		zamowienie.append("Razem: " + ObliczWartosc() + " zl");
		return zamowienie.toString();
		
	}
}
