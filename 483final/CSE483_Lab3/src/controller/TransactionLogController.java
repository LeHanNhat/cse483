package controller;

import java.util.List;

import model.Account;
import model.Transaction;
import model.Transaction.TransType;
import view.PrintAccountDetailsView;
import view.PrintTransactionView;

public class TransactionLogController {
	private Account _account;
	private PrintAccountDetailsView _accountDetailView;
	private PrintTransactionView _transactionView;
	
	public TransactionLogController(Account account, PrintAccountDetailsView accountView, PrintTransactionView transactionView) {
		_account = account;
		_accountDetailView = accountView;
		_transactionView = transactionView;
	}
	
	public void displayTransactionLog() {
		List<Transaction> transactions = _account.getAllTransactions();
		
		_accountDetailView.displayUserDetail(_account);
		System.out.println("\nTransactions History:");
		if(transactions==null || transactions.size() == 0) {
			System.out.println("This account do not have any transactions!\n\n");
			return;
		}
		for(Transaction trans : transactions) {
			_transactionView.displayTransaction(trans);
		}
	}
}
