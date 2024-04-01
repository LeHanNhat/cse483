package controller;

import java.util.List;
import java.util.Scanner;

import model.Account;
import model.User;
import view.AuthenticateUserView;
import view.HomeView;
import view.PrintAccountDetailsView;
import view.PrintTransactionView;

public class HomeController {
	private List<Account> _accounts;
	private Account _account;
	private AuthenticateUserController _authenticateController;
	private DepositController _depositController;
	private WithdrawController _withdrawController;
	private TransactionLogController _transactionLogController;
	private HomeView _view;
	private AuthenticateUserView _authenticateView;
	private PrintAccountDetailsView _accountDetailsView;
	private PrintTransactionView _transactionView;

	public HomeController(List<Account> accounts) {
		_accounts = accounts;
		_view = new HomeView();
	}

	public void start() {
		int choice = 0;
		boolean flag = true;
		while (flag) {
			choice = displayServiceMenu();

			if (choice == 1) {
				displayTransaction();
			} else if (choice == 2) {
				deposit(_view.depositView());
			} else if (choice == 3) {
				withdraw(_view.withdrawView());
			} else if (choice == 4) {
				flag = false;
			} else {
				_view.errorInputNotify(choice);
			}
		}
	}

	public int displayServiceMenu() {
		return _view.displayServiceMenu();
	}

	public boolean authenticate() {
		_authenticateView = new AuthenticateUserView();
		_authenticateController = new AuthenticateUserController(_accounts, _authenticateView);

		String username = _authenticateView.inputUsername();
		String password = _authenticateView.inputPassword();
		User user = new User(username, password);

		_account = _authenticateController.authenticate(user);
		if (_account == null) {
			return false;
		}
		return true;
	}

	public void deposit(double amount) {
		_depositController = new DepositController(_account);
		_depositController.deposit(amount);
	}

	public void withdraw(double amount) {
		_withdrawController = new WithdrawController(_account);
		_withdrawController.withdraw(amount);
	}

	public void displayTransaction() {
		_accountDetailsView = new PrintAccountDetailsView();
		_transactionView = new PrintTransactionView();
		_transactionLogController = new TransactionLogController(_account, _accountDetailsView, _transactionView);
		_transactionLogController.displayTransactionLog();
	}

}
