package com.java.upsl;

import java.util.Scanner;
import java.lang.Object;

public class czwartyMarca {

	public static void main(String[] args) {
		zad1(args);
		
	
	}
	
	public static void zad1(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		char letter = text.charAt(text.length()-1);
		int counter = 0;
		for(int i = 0; i<text.length();i++) {
			if(text.charAt(i) == letter) {
				counter++;
			}
		}
		
		for(int i = 0; i<counter;i++) {
			System.out.println(text);
		}
		
	}
}