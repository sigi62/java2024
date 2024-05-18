package com.java.biblioteka;

import java.io.IOException;
import java.util.Scanner;

public class main {
	
	public enum state {
	    Start,
	    Logging,
	    LoggedUser,
	    LoggedAdmin,
	    AddingAccount,
	    LoggingOut
	}


	
	public static void main(String[] args) throws IOException {
		
		
		Account acc = new Account();
		Admin admin_Main = new Admin("admin","admin",acc);//nie zapisuje sie w liscie ;'c
		admin_Main.CreateAccount("admin", "admin", true); // :D
		state prevstate = null;
		Admin admin = null;
		User user = null;
		try {
			statemachine(state.Start,prevstate,acc,admin_Main,admin,user);
		} 
		catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "static-access", "resource", "resource" })
	public static  void statemachine(state main_State,state _prevstate,Account _acc,Admin Mainadmin,Admin _admin,User _user) throws IOException, InterruptedException {
		
		//set up
		state state = main_State;
		state prevstate = _prevstate;
		Account acc = _acc;
		Admin admin_Main = Mainadmin;
		
		Admin admin = _admin;
		User user = _user;
		
		if(state == state.Start) {
			
			System.out.println("\n ---------------- \n");
	
			System.out.println("Witaj w aplikacji biblioteki!");
			System.out.println("Zaloguj się na konto aby kontynuować");
			System.out.println("1. Zaloguj się");
			System.out.println("2. Utwórz konto");
				
			Scanner scanner = new Scanner(System.in);
			String text = scanner.nextLine();
			
			if(text.equals("1")) {statemachine(state.Logging,prevstate,acc,admin_Main,admin,user);}
			else if(text.equals("2")) { statemachine(state.AddingAccount,prevstate,acc,admin_Main,admin,user);}
			else { statemachine(state.Start,prevstate,acc,admin_Main,admin,user); }
				
			
		}
		
		else if(state == state.Logging) {
			
			System.out.println("\n -------Logging--------- \n");
			Scanner scanner = new Scanner(System.in);
			System.out.print("Login: ");
			String login = scanner.nextLine();
			System.out.print("Hasło: ");
			String password = scanner.nextLine();
				
			int i = acc.UFindIndexbyName(login);
			if(i == -1) { //nie ma konta usera
				i = acc.AFindIndexbyName(login);
				if(i == -1) { // nie ma konta admina
					System.out.println("Takie konto nie istnieje. Utworzyć nowe konto?  [y/n]");
					if(scanner.nextLine().equals("y")) {statemachine(state.AddingAccount,prevstate,acc,admin_Main,admin,user);}
					else {statemachine(state.Start,prevstate,acc,admin_Main,admin,user);}
				}
				else //konto admina istnieje
				{
					admin = acc.admins.get(i);
					if(admin.adminPassword.equals(password)) { //haslo poprawne
						System.out.println("Pomyślnie zalogowano! ");
						statemachine(state.LoggedAdmin,prevstate,acc,admin_Main,admin,user);
					}
					else {
						System.out.println("Niepoprawne hasło");
						statemachine(state.Logging,prevstate,acc,admin_Main,admin,user);
					}
					
				}
			}
			else {//konto usera istnieje
				
				user = acc.users.get(i);
				if(user.userPassword.equals(password)) { //haslo poprawne
					System.out.println("Pomyślnie zalogowano! ");
					statemachine(state.LoggedUser,prevstate,acc,admin_Main,admin,user);
				}
				else {
			
					System.out.println("Niepoprawne hasło");
					statemachine(state.Logging,prevstate,acc,admin_Main,admin,user);
				}
				
			}
		}
		
		else if(state == state.AddingAccount) {
			
			System.out.println("\n ---------------- \n");
			Scanner scanner = new Scanner(System.in);
				System.out.println("Witaj w tworzeniu konta!");
				System.out.println("Wprowadz nazwe konta poniżej.");
				System.out.print("Login: ");
				String login = scanner.nextLine();
				System.out.println("Teraz podaj hasło.");
				System.out.print("Hasło: ");
				String password = scanner.nextLine();
				
				
				admin_Main.CreateAccount(login, password, false);
			
			System.out.println("Konto zostało utworzone! Powrót do ekranu logowania");
			statemachine(state.Logging,prevstate,acc,admin_Main,admin,user);
			
		}
		
		else if(state == state.LoggedUser) {
			
			System.out.println("\n ---------------- \n");
			try (Scanner scanner = new Scanner(System.in)) {
				System.out.println("Witaj użytkowniku!");
				System.out.println("Opcje biblioteki są poniżej");
				ShowUserOptions();
				
				String text = scanner.nextLine();
				if(text.equals("1")) { //lista dostępnych ksiązek
					System.out.println("\n ---Dostępne---- \n");
					user.ShowAviable();
					statemachine(state.LoggedUser,prevstate,acc,admin_Main,admin,user);
				}
				else if(text.equals("2")) {//wypożyczanie
					System.out.println("\n ---Wypożyczanie---- \n");
					System.out.println("Podaj tytuł ksiązki którą chcesz wypożyczyć");
					System.out.print("Wypożycz: ");
					String title = scanner.nextLine();
					user.Rent(title);
					statemachine(state.LoggedUser,prevstate,acc,admin_Main,admin,user);
				}
				else if(text.equals("3")) {//oddawanie
					System.out.println("\n ---Oddawanie---- \n");
					System.out.println("Podaj tytuł ksiązki którą chcesz oddać");
					System.out.print("Oddaj: ");
					String title = scanner.nextLine();
					user.GiveBack(title);
					statemachine(state.LoggedUser,prevstate,acc,admin_Main,admin,user);
				}
				else if(text.equals("4")) {//wyswietlanie wypożyczonych
					System.out.println("\n ---Wypożyczone---- \n");
					user.ShowRented();
					statemachine(state.LoggedUser,prevstate,acc,admin_Main,admin,user);
				}
				else if(text.equals("5")) {//wylogowywanie
					
					prevstate = state.LoggedUser;
					statemachine(state.LoggingOut,prevstate,acc,admin_Main,admin,user);
				}
				else if(text.equals(null)) {//bruh
				
				}
				else { System.out.println("Niepoprawna komenda!");statemachine(state.LoggedUser,prevstate,acc,admin_Main,admin,user);}
				
			}
			
		}
		
		else if(state == state.LoggedAdmin) {
			
			System.out.println("\n ---------------- \n");
			try (Scanner scanner = new Scanner(System.in)) {
				System.out.println("Witaj adminie!");
				System.out.println("Opcje biblioteki są poniżej");
				ShowAdminOptions();
				
				String text = scanner.nextLine();
				if(text.equals("1")) { //dodaj użytkonika
					System.out.println("\n ------dodawanie użytkownika----- \n");
					System.out.println("1. Dodaj nowego użytkownika");
					System.out.println("2. Dodaj nowego admina");
					String reply = scanner.nextLine();
					
					if(!reply.equals("1") && !reply.equals("2")){
						
						System.out.println("Nieprawidsłowa opcja! ");
					}
					else {
						System.out.print("Login: ");
						String login = scanner.nextLine();
						System.out.print("Hasło: ");
						String password = scanner.nextLine();
						
						if(reply.equals("1")) {
							Mainadmin.CreateAccount(login, password, false);
							System.out.println("Pomyślnie utworzono nowe konto użytkownika");
						}
						if(reply.equals("2")) {
							Mainadmin.CreateAccount(login, password, true);
							System.out.println("Pomyślnie utworzono nowe konto admina");
						}
						
					}
					
					statemachine(state.LoggedAdmin,prevstate,acc,admin_Main,admin,user);
				}
				
				else if(text.equals("2")) {//usuń użytkownika
					System.out.println("\n ------usuwanie użytkownika----- \n");
					
					System.out.println("Podaj login konta które chcesz usunąć");
					System.out.print("login: ");
					String login = scanner.nextLine();
					
					int i = acc.UFindIndexbyName(login);
					if(i == -1) { //nie ma konta usera
						i = acc.AFindIndexbyName(login);
						if(i == -1) { // nie ma konta admina
							System.out.println("Takie konto nie istnieje.");
							
						}
						else //konto admina istnieje
						{
							Mainadmin.DeleteAccount(login, true);
							System.out.println("Usunięta konto admina "+login);
							
						}
					}
					else {//konto usera istnieje
						
						Mainadmin.DeleteAccount(login, false);
						System.out.println("Usunięta konto "+login);
						
					}
					statemachine(state.LoggedAdmin,prevstate,acc,admin_Main,admin,user);
				}
				else if(text.equals("3")) {//lista użytkonwikow
					System.out.println("\n ------lista użytkowników----- \n");
					Mainadmin.ShowAllUsers();
					statemachine(state.LoggedAdmin,prevstate,acc,admin_Main,admin,user);
				}
				else if(text.equals("4")) {//lista ksiązek
					System.out.println("\n ---lista książek---- \n");
					admin.ShowAllBooks();
					statemachine(state.LoggedAdmin,prevstate,acc,admin_Main,admin,user);
				}
				else if(text.equals("5")) {//wypożyczone ksiazki
					System.out.println("\n ---lista wypożyczonych książek---- \n");
					admin.ShowRentedBooks();
					statemachine(state.LoggedAdmin,prevstate,acc,admin_Main,admin,user);
				}
				else if(text.equals("6")) {//użytkownicy z wypożyczone ksiazki
					System.out.println("\n ---lista użtkowników którzy wypożyczyli książki---- \n");
					admin.ShowUsersRenting();
					statemachine(state.LoggedAdmin,prevstate,acc,admin_Main,admin,user);
				}
				else if(text.equals("7")) {//wylogujw
					prevstate = state.LoggedAdmin;
					statemachine(state.LoggingOut,prevstate,acc,admin_Main,admin,user);
				}
				else if(text.equals(null)) {//bruh
				}
				else { System.out.println("Niepoprawna komenda!");statemachine(state.LoggedAdmin,prevstate,acc,admin_Main,admin,user);}
			}
			
		}


		else if(state == state.LoggingOut) {
		
			System.out.println("\n ---------------- \n");
			System.out.println("Czy na pewno chcesz się wylogować?  [y/n]");
			Scanner scanner = new Scanner(System.in);
			String reply = scanner.nextLine();
			
			if(reply.equals("y")) {
				statemachine(state.Start,prevstate,acc,admin_Main,admin,user);
			}
			else if (reply.equals("n")){
				statemachine(prevstate,state.LoggingOut,acc,admin_Main,admin,user);
			}
			else { 
				System.out.println("Niepoprawna komenda!");
				statemachine(state.LoggingOut,prevstate,acc,admin_Main,admin,user);
			}
		}
		
	}
	public static void ShowAdminOptions()
	{
		System.out.println("1. Dodaj konto");
		System.out.println("2. Usuń konto");
		System.out.println("3. Wyświetl list użtkowników");
		System.out.println("4. Wyświetl wszystkie książki");
		System.out.println("5. Wyświetl wypożyczone książki");
		System.out.println("6. Wyświetl użtkowników z wypożyczonymi książkami");
		System.out.println("7. Wyloguj");
		
	}
	public static void ShowUserOptions()
	{
		System.out.println("1. Wyświetl dostępne książki");
		System.out.println("2. Wypożycz książke");
		System.out.println("3. Oddaj książke");
		System.out.println("4. Wyświetl wypożyczone książki");
		System.out.println("5. Wyloguj");
	}

}
