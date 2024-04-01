package controller;

import model.Account;
import model.Transaction;
import model.Transaction.TransType;

public class WithdrawController {
	private Account _account;
	
	public WithdrawController(Account account) {
		_account = account;
	}
	
	public void withdraw(double amount) {
		if(!checkAccountType()) {
			System.out.println("Can not process the request!");
			return;
		}
		
		Transaction trans = new Transaction(TransType.WITHDRAWAL, amount);
		_account.addTransaction(trans);
		System.out.println("Successful!");
	}
	
	public boolean checkAccountType() {
		return _account.CheckAccountType() == Account.AccountType.CHECKING ? true : false;
	}
}
