package model.entities;

import model.exceptions.DomainException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) throws DomainException {
		if (balance < 0) {
	    	 throw new DomainException("Valor do deposito inicial não pode ser negativo");
	    }
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public void deposit(Double amount) throws DomainException {
		 if (amount <= 0) {
	    	 throw new DomainException("Valor de deposito tem que ser maior que ZERO");
	     }
		 else {
			 balance += amount;
		}
	}
	
	public void withdraw(Double amount) throws DomainException {
		if (amount > this.withdrawLimit) {
	    	 throw new DomainException("Valor do saque maior que o limite permitido");
	     }
		else if(amount > balance) {
			throw new DomainException("Valor do saque maior que o saldo da conta");
		}
		else {
			balance -= amount;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("New Balance: ");
		sb.append(balance);
		return sb.toString();
	}
	
}
