package view;

import model.Account;

public class PrintAccountDetailsView {
	public void displayUserDetail(Account account) {
		System.out.println("Account number: " + account.GetAccountNumber());
		System.out.println("Owner: " + account.GetUser().GetUsername());
		System.out.println("Type: " + account.CheckAccountType().toString());
		System.out.println("Balance: " + account.GetBalance());
	}
}
