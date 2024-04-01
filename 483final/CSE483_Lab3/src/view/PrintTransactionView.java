package view;


import model.Transaction;

public class PrintTransactionView {
	public void displayTransaction(Transaction transaction) {
		System.out.println("Type: " + transaction.checkType().toString());
		System.out.println("Amount: " + transaction.getAmount());
		System.out.println("\n");
	}
}
