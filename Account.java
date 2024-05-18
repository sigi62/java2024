package com.java.biblioteka;
import java.io.IOException;
import java.util.ArrayList;

public class Account {

	protected ArrayList<User> users =new ArrayList<User>();
	protected ArrayList<Admin> admins =new ArrayList<Admin>();
	Library library = new Library();
	
	ArrayList<Book> Books;
	
	public Account() throws IOException {
		// TODO Auto-generated constructor stub
		Books = library.Load();
	}
	
	
	
	protected int UFindIndexbyName(String name)
	{
		for(int i =0;i< users.size();i++)
		{
			User user = users.get(i);
			if(user.userName.equals(name))
				return i;
		}
		return -1;
	}
	
	
	
	protected int AFindIndexbyName(String name)
	{
		for(int i =0;i< admins.size();i++)
		{
			Admin admin = admins.get(i);
			if(admin.adminName.equals(name))
				return i;
		}
		return -1;
	}
	
	public void ShowAllAccounts() {
	
		ShowAdmins();
		ShowUsers();
		
	}
	
	protected void ShowUsersRenting() {

		for(int i =0;i< users.size();i++)
		{
			User user = users.get(i);
			if(user.RentedBooks > 0)
				System.out.print(user.toString() + ", wypożyczone książki: " + user.RentedBooks + "\n");
		}
	}
	
	public void SetRenting(int index,Boolean rent,String user) {
		
		Book book = Books.get(index);
		book.isRented = rent;
		book.rentedBy = user;
		
	}
	
	public void ShowAviable()
	{
		library.ShowAviable();
		
	}
	
	public void ShowAdmins() {
		
		System.out.println("Admins: ");
		for(int i =0;i< admins.size();i++)
		{
			Admin admin = admins.get(i);
			System.out.println(admin.toString());
		}
		
	}
	
	public void ShowUsers() {
		
		System.out.println("Users: ");
		for(int i =0;i< users.size();i++)
		{
			User user = users.get(i);
			System.out.println(user.toString());
		}
		
	}
	
	public void ResetUser(User user) {
		
		user.RentedBooks = 0;
		
		for(int i =0;i< Books.size();i++)
		{
			Book book = Books.get(i);
			if(book.isRented == true && book.rentedBy.equals(user.userName)) {
				library.SetRenting(i, false,null);
		
			}
		}
		
	}
	
	
}
