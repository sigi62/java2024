package com.java.biblioteka;

public class Book {

	String _title;
	String _author;
	int _year_creation;
	Boolean isRented = false;
	String rentedBy = null;
	public Book(String title,String author,int year_creation) {
		
		_title = title;
		_author = author;
		_year_creation = year_creation;
		
	}

	@Override
	public String toString()
	{
		return "'" + _title + "' by " + _author + ", rok powstania - " + _year_creation; 
	}	



	
}
