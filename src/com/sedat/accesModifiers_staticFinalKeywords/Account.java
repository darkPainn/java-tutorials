package com.sedat.accesModifiers_staticFinalKeywords;

import java.util.ArrayList;

public class Account {
	public String accountName;
	public int balance = 0;
	public ArrayList<Integer> transactions;
	public Account(String accountName) {
		this.accountName = accountName;
		this.transactions = new ArrayList<>();
	}
	public int getBalance() {
		return this.balance;
	}
	public void deposit(int amount) {
		if(amount > 0) {
			transactions.add(amount);
			this.balance += amount;
			System.out.println(amount + " deposited. Balance now is: " + this.balance);
		}else {
			System.out.println("Cannot deposit negative sums!");
		}
	}
	public void withdraw(int amount) {
		int withdrawol = -amount;
		if(withdrawol < 0) {
			this.transactions.add(withdrawol);
			this.balance += withdrawol;
			System.out.println(amount + " withdrown. The balance now is: " + this.balance);
		}else {
			System.out.println("Cannot withdraw negative sums!");
		}
	}
	public void calculateBalance() {
		this.balance = 0;
		for(int i : this.transactions) {
			this.balance += i;
		}
		System.out.println("Balance calculated: " + this.balance);
	}
}
