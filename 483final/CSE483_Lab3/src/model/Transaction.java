package model;

import java.util.UUID;

public class Transaction {
	private String _id;
	private TransType _transType;
	private double _amount;

	public Transaction(TransType type, double amount) {
		_id = createId();
		_transType = type;
		_amount = amount;
	}

	public String getId() {
		return _id;
	}
	
	private String createId() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

	public TransType checkType() {
		return _transType;
	}

	public double getAmount() {
		return _amount;
	}

	public enum TransType {
		DEPOSIT, WITHDRAWAL
	}
}
