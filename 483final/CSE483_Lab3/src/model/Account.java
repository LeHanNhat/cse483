package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import model.Transaction.TransType;

public class Account {
	private String _accountNumber;
	private double _balance;
	private User _owner;
	private AccountType _accountType;
	private List<Transaction> _transactions;

	public Account(User user, AccountType type) {
		_accountNumber = CreateAccountNumber();
		_owner = user;
		_accountType = type;
		_transactions = new ArrayList<>();
		_balance = 0;
	}

	public void addTransaction(Transaction trans) {
		if (trans.checkType() == TransType.DEPOSIT) {
			_balance += trans.getAmount();
		} else {
			_balance -= trans.getAmount();
		}
		_transactions.add(trans);

	}

	public List<Transaction> getAllTransactions() {
		return _transactions;
	}

	private String CreateAccountNumber() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

	public String GetAccountNumber() {
		return _accountNumber;
	}

	public double GetBalance() {
		return _balance;
	}

	public AccountType CheckAccountType() {
		return _accountType;
	}

	public User GetUser() {
		return _owner;
	}

	public enum AccountType {
		SAVINGS, CHECKING, LOAN
	}
}
