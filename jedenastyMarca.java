package com.java.upsl;

import java.util.*;
import java.lang.Object;


public class jedenastyMarca {

	public static void main(String[] args) {
		zad6(args);
	}
	public static void zad2(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		StringBuilder str = new StringBuilder(text);
		str.reverse();
		System.out.print(str.toString());
		
	}
	
	public static void zad3(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		StringBuilder str = new StringBuilder(text);
		str.reverse();
		boolean isPalindrome = true;
		for(int i=0;i<str.length();i++) {
			if(text.charAt(i)==str.charAt(i)) {
				continue;
			}
			else isPalindrome = false; break;
		}
		
		System.out.print("is " +  text + " palindrome? : " + isPalindrome);
		
	}
	
	public static void zad4(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		int sum = 0;
		
		for(int i=0;i<text.length();i++) {
			char a = text.charAt(i);
			if(Character.isDigit(a)) {
				int num = Integer.parseInt(String.valueOf(a));
				sum = sum + num;
			}
		}
		
		System.out.println(sum);
		
	}
	
	public static void zad5(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		
		int counterR = 0;
		int counterL = 0;
		
		for(int i=0;i<text.length();i++) {
			if(text.charAt(i) == '(') {
				counterL++;
			}
			if(text.charAt(i) == ')') {
				counterR++;
			}
		}
		
		if(counterL == counterR) System.out.println("OK");
		else if(counterL > counterR) System.out.println("Coś zostało niezamknięte!");
		else System.out.println("za dużo nawiasów zamykających");
		
	}
	
	public static void zad6(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		int n = 2;
		
		StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) {
                char shifted = (char) (ch + n);
                if ((Character.isUpperCase(ch) && shifted > 'Z') || (Character.isLowerCase(ch) && shifted > 'z')) {
                    shifted = (char) (ch - (26 - n));
                }
                result.append(shifted);
            } else {
                result.append(ch);
            }
        }
		
		System.out.println(result);
		
	}
	
	
}
