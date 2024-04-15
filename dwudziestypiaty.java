package com.java.upsl;

import java.io.*; 
import java.io.IOException; 
import java.util.*; 

public class dwudziestypiaty {

	public static void main(String[] args) throws IOException {
		szukaj("wiersze.txt","wyjscieplik.txt","lody");
		
		try{
			
			File myFile = new File("plik_do_zadania1.txt");
			
			if(myFile.createNewFile()) {
				System.out.println("created a file");
			}
			
			Scanner myReader = new Scanner(myFile); 
			
			int charCounter=0;
			int whitespaceCounter=0;
			int wordCounter=1;
			
			while (myReader.hasNextLine()) { 
				 String data = myReader.nextLine();
				 for(int i = 0;i<data.length();i++) {
					char a = data.charAt(i);
					 if(Character.isWhitespace(a)) {
						 whitespaceCounter+=1;
							wordCounter	+=1;
					 }
					 if(Character.isAlphabetic(a)) {
						 charCounter+=1;	
					 }
				 }		
				 System.out.println("liczba znakow : " + charCounter);
				 System.out.println("liczba spacji : " + whitespaceCounter);
				 System.out.println("liczba słow : " + wordCounter);
			}	 
			myReader.close();	 
		}	 
				 
		catch(FileNotFoundException e) {		 
			System.out.println("file not found");
			e.printStackTrace();	 
				
		}

	} 	
	public static void szukaj(String nazwaPlikuWej, String nazwaPlikuWyj, String slowo) {
		try{
			
			File plikWej = new File(nazwaPlikuWej);

			Scanner myReader = new Scanner(plikWej);	
			FileWriter myWriter = new FileWriter(nazwaPlikuWyj);
			
			int linecounter = 0;
			
			while (myReader.hasNextLine()) { 
				 String data = myReader.nextLine();
				 linecounter +=1;
				if(data.contains(slowo)) {
					myWriter.write(linecounter + ":" + data + '\n');
				}
			}	 
			myReader.close();
			myWriter.close();	 
		}	 
				 
		catch(FileNotFoundException e) {		 
			System.out.println("file not found");
			e.printStackTrace();	 
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		




		
	}
	
}
