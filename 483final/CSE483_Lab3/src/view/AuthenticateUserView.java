package view;

import java.util.Scanner;

import model.Account;

public class AuthenticateUserView {
	private static Scanner sc = new Scanner(System.in);	
	
	public void displayAccountInfo(Account account) {
		System.out.println("Login successful! Welcome to Online Banking Service!");
		System.out.println();
		System.out.println("Account number: " + account.GetAccountNumber());
		System.out.println("Owner: " + account.GetUser().GetUsername());
		System.out.println("Type: " + account.CheckAccountType().toString());
		System.out.println("Balance: " + account.GetBalance());
		System.out.println("\n");
	}
	
	public void displayLoginFalseNotify() {
		System.out.println("Login false, please ensure that you entered correct username and password.");
	}
	
	public String inputUsername() {
		String username = null;
		System.out.println("Login");
		while (true) {
			System.out.println("Username: ");
			username = sc.nextLine();
			if (!(username.equals("") || username == null)) {
				return username;
			}
			System.out.println("Please input your username");
		}
	}
	
	public String inputPassword() {
		String password = null;
		while (true) {
			System.out.println("Password: ");
			password = sc.nextLine();
			if (!(password.equals("") || password == null)) {
				return password;
			}
			System.out.println("Please input your password");
		}
	}
}
