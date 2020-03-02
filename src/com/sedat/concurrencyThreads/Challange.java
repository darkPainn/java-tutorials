package com.sedat.concurrencyThreads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author sedat.turkoglu
 * We could have 2 people using a joint bank account at the same time
 * Create and start 2 threads that use the same bankAccount object and an initial balance of $1000.00.
 * One will deposit $300.00 into the bank account and then withdraw $50.00.
 * The other will deposit $203.75 and then withdraw $100.00 
 */
public class Challange {	

	public static void main(String[] args) {
		BankAccount account = new BankAccount("joint account", 1000.00);
		Thread t1 = new Thread("thread1") {
			public void run() {
				account.deposit(300.00);
				account.withdraw(50.00);
				System.out.println("The final balance is: " + account.getBalance());
			}
		};
		Thread t2 = new Thread("thread2") {
			public void run() {
				account.deposit(200.00);
				account.withdraw(100.00);
				System.out.println("The final balance is: " + account.getBalance());
			}
		};
		t1.start();
		t2.start();
		
	}
}

class BankAccount {
	private Lock lock;
    private double balance;
    private String accountNumber;
 
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock = new ReentrantLock(true);
        System.out.println("The account is created and the inital amount is: " + this.balance);
    }
 
    //this is the first option - make the entire methods thread-safe
    /*public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println("Depositing the account by " + amount + " new balance is: " + this.balance);
    }
 
    public synchronized void withdraw(double amount) {
        balance -= amount;
        System.out.println("Withdrawin the account by " + amount + " new balance is: " + this.balance);
    }*/
 
    //this is the second option - make only the part of the code thread-safe
    /*
    public void deposit(double amount) {
    	synchronized(this) {
    		balance += amount;
    		System.out.println("Depositing the account by " + amount + " new balance is: " + this.balance);
    	}        
    }
 
    public void withdraw(double amount) {
    	synchronized(this) {
    		balance -= amount;
    		System.out.println("Withdrawin the account by " + amount + " new balance is: " + this.balance);
    	}        
    }*/
    
    //this is the third option - using the fair lock, without the synchronized keyword   
    public void deposit(double amount) {
    	lock.lock();
    	try {
    		balance += amount;
    		System.out.println(Thread.currentThread().getName() + " is depositing the account by " + amount + " new balance is: " + this.balance);
    	}finally {
    		lock.unlock();
    	}
    }
 
    public void withdraw(double amount) {
    	lock.lock();
    	try {
    		balance -= amount;
    		System.out.println(Thread.currentThread().getName() + " is withdrawin the account by " + amount + " new balance is: " + this.balance);
    	}finally {
    		lock.unlock();
    	}
    }
    
    public double getBalance() {
    	return this.balance;
    }
    
    public String getAccountNumber() {
    	return this.accountNumber;
    }
    
    public void printAccountNumber() {
    	System.out.println("Account number = " + this.getAccountNumber());
    }
}
























