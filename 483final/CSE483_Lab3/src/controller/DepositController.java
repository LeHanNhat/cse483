package controller;

import model.Account;
import model.Transaction;
import model.Transaction.TransType;

public class DepositController {
	private Account _account;
	
	public DepositController(Account account) {
		_account = account;
	}
	
	public void deposit(double amount) {
		if(!checkAccountType()) {
			System.out.println("Can not process the request!");
			return;
		}
		
		Transaction trans = new Transaction(TransType.DEPOSIT, amount);
		_account.addTransaction(trans);
		System.out.println("Successful!");
	}
	
	public boolean checkAccountType() {
		return _account.CheckAccountType() == Account.AccountType.LOAN ? false : true;
	}
}
