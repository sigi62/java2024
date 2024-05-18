package com.java.biblioteka;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*; 
import java.io.IOException; 


public class Library {

	ArrayList<Book> Books = new ArrayList<Book>();
	String path = "bookList.txt";
	
	public Library() {
		
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Book> Load()throws IOException {
		try{
			
			File plikWej = new File(path);

			if(plikWej.createNewFile()) {
				System.out.println("created a file");
			}
			
			Scanner myReader = new Scanner(plikWej);	
			
			while (myReader.hasNextLine())
			{ 
				String data = myReader.nextLine(); 
				String[] bkdata=data.split(";");
				int year = Integer.valueOf(bkdata[2]);
				Book newBook = new Book(bkdata[0].toString(),bkdata[1],year);
				Books.add(newBook); 
				 
				
			}	 
			myReader.close(); 
		}	 
				 
		catch(FileNotFoundException e) {		 
			System.out.println("file not found");
			e.printStackTrace();	 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Books;
		

	}

	public void ShowAll() {

		for(int i =0;i< Books.size();i++)
		{
			System.out.print(Books.get(i).toString() + "\n");
		}

		
	}
	public void ShowAviable() {

		for(int i =0;i< Books.size();i++)
		{
			Book book = Books.get(i);
			if(!book.isRented)
				System.out.print(book.toString() + "\n");
		}

	}	
	
	public void ShowRented() {
		
		for(int i =0;i< Books.size();i++)
		{
			Book book = Books.get(i);
			if(book.isRented)
				System.out.print(book.toString() + ", wypożyczona przez: " + book.rentedBy + "\n");
		}

	}
	
	public int FindByTitle(String title) {
		
		for(int i =0;i< Books.size();i++)
		{
			Book book = Books.get(i);
			if(book._title.toLowerCase().equals(title.toLowerCase()) )
				return i;
		}
		return -1;
	}
	
	public  ArrayList<Integer> FindByRented(String userName) {
		 ArrayList<Integer>indexes = new ArrayList<Integer>();
		for(int i =0;i< Books.size();i++)
		{
			Book book = Books.get(i);
			if(book.rentedBy == userName)
				indexes.add(i);
		}
		return indexes;
	}
	
	public void SetRenting(int index,Boolean rent,String user) {
		
		Book book = Books.get(index);
		book.isRented = rent;
		book.rentedBy = user;
		
	}
	
	
}
