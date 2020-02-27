package com.sedat.concurrencyThreads;

public class MyRunnable extends Thread implements Runnable{

	@Override
	public void run() {
		System.out.println("\u001B[91m" + 
							"Hello from MyRunnable.run()" + 
							"\u001B[30m" + " with the thread name: " + 
							currentThread().getName());
		try {
			System.out.println(currentThread().getName() + " is sleeping now");
			Thread.sleep(9000);
		}catch(InterruptedException e) {
			System.out.println("They woke " + currentThread().getName());
			return;
		}
		
		System.out.println(currentThread().getName() + " is awake again");
	}

}
