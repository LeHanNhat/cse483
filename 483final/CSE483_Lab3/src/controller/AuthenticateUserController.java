package controller;

import java.util.List;

import model.Account;
import model.User;
import view.AuthenticateUserView;

public class AuthenticateUserController {
	private List<Account> _accounts;
	private AuthenticateUserView _view;

	public AuthenticateUserController(List<Account> accounts, AuthenticateUserView view) {
		_accounts = accounts;
		_view = view;
	}

	public Account authenticate(User user) {
		Account acc = validateUser(user);
		if(acc != null) {
			_view.displayAccountInfo(acc);
		}
		return acc;
	}
	
	private Account validateUser(User user) {
		for (Account acc : _accounts) {
			if(acc.GetUser().GetUsername().equals(user.GetUsername())) {
				if(acc.GetUser().GetUserPassword().equals(user.GetUserPassword())) {
					return acc;
				}
				_view.displayLoginFalseNotify();
				return null;
			}
		}
		_view.displayLoginFalseNotify();
		return null;
	}
}
