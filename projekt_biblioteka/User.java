package com.java.biblioteka;
import java.io.IOException;
import java.util.ArrayList;

public class User {

	String userName; 
	String userPassword;
	int RentedBooks = 0;
	Account account;
	
	public User(String name,String password,Account _account)throws IOException  {
		userName = name;
		userPassword = password;
		account = _account;
	}
	
	
	public void Rent(String title) {

		int index = account.library.FindByTitle(title);
		if(index != -1)
		{ 
			Book book = account.Books.get(index);
			if(book.isRented == false) {
				account.SetRenting(index, true,userName);
				RentedBooks += 1;
				System.out.println("Wypożyczyłeś książke '" + title + "'");
			}
			else
			{ 
				System.out.println("Ktoś inny wypożyczył książkę '" + title + "'");
			}
			
		}
		else {System.out.println("Nie ma takiej ksiazki w bibliotece");}
		
	}	

	public void GiveBack(String title) {
		
		int index = account.library.FindByTitle(title);
		if(index != -1)
		{ 
			Book book = account.Books.get(index);
			if(book.isRented == true && book.rentedBy.equals(userName)) {
				account.library.SetRenting(index, false,null);
				RentedBooks -= 1;
				System.out.println("Oddałeś książke '" + title + "'");
			}
			else
			{ 
				System.out.println("Nie masz wyposżyczonej książki '" + title + "'");
			}
		}
		
		else {System.out.println("Nie ma takiej książki w bibliotece");}
		
	}	
	
	public void ShowAviable() {

		account.library.ShowAviable();
	}	

	public void ShowRented() {

		ArrayList<Integer>indexes = account.library.FindByRented(userName);
		for(int element:indexes) {
			
			System.out.println(account.Books.get(element).toString());
		}
		
	}

	@Override
	public String toString()
	{
		return "username:"+ userName+" , password: "+userPassword;
	}			
}
