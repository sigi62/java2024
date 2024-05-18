package com.java.biblioteka;

import java.io.IOException;

public class Admin {

	String adminName; 
	String adminPassword;
	Account account;
	
	public Admin(String name,String password,Account _account)throws IOException  {
		adminName = name;
		adminPassword = password;
		account = _account;
		
	}

	public void CreateAccount(String name,String password,Boolean isAdmin) throws IOException {
	
		if(isAdmin) {
			Admin newAdmin = new Admin(name,password,account);
			account.admins.add(newAdmin);
		}	
		else {
			User newUser = new User(name,password,account);
			account.users.add(newUser);
		}	
		
	}
	public void DeleteAccount(String name,Boolean isAdmin){
		
		if(isAdmin) {
			account.admins.remove(account.AFindIndexbyName(name));
		}	
		else {
			User user = account.users.get(account.UFindIndexbyName(name));
			account.ResetUser(user);
			account.users.remove(user);
		}	
		
	}

	public void ShowAllUsers(){

		account.ShowUsers();
	}
	
	
	public void ShowAllBooks() {

		account.library.ShowAll();
	}	
	
	public void ShowRentedBooks() {

		account.library.ShowRented();
	}
	
	public void ShowUsersRenting() {

		account.ShowUsersRenting();
	}
	
	
	@Override
	public String toString()
	{
		return "username:"+ adminName+" , password: "+adminPassword;
	}	
	
}
