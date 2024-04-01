import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.HomeController;
import model.Account;
import model.Account.AccountType;
import model.Transaction;
import model.Transaction.TransType;
import model.User;

public class OnlineBankingSystem {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HomeController controller = new HomeController(seedData());

		while (true) {
			if (controller.authenticate()) {
				controller.start();
			}
		}

	}


	private static List<Account> seedData() {
		List<Account> list = new ArrayList<>();

		Account acc1 = new Account(new User("abc", "123"), AccountType.CHECKING);
		Account acc2 = new Account(new User("asd", "123"), AccountType.SAVINGS);
		Account acc3 = new Account(new User("jkl", "123"), AccountType.LOAN);

		Transaction trans1 = new Transaction(TransType.DEPOSIT, 100_000);
		Transaction trans2 = new Transaction(TransType.DEPOSIT, 500_000);
		Transaction trans3 = new Transaction(TransType.WITHDRAWAL, 10_000);

		acc1.addTransaction(trans3);
		acc2.addTransaction(trans2);
		acc1.addTransaction(trans1);

		list.add(acc3);
		list.add(acc2);
		list.add(acc1);

		return list;
	}
}
