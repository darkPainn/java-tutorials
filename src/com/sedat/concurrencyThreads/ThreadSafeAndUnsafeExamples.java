package com.sedat.concurrencyThreads;

public class ThreadSafeAndUnsafeExamples {

	public static void main(String[] args) {
		
		/*System.out.println("Hello from " + "\u001B[91m" + Thread.currentThread().getName());
		Thread myrunnable = new Thread(new MyRunnable());
		myrunnable.setName("secondary");
		myrunnable.start();
		myrunnable.interrupt();
		
		try {
			Thread.sleep(1000);			
		}catch(InterruptedException e) {
			System.out.println("plah");
		}		
		
		System.out.println(Thread.currentThread().getName() + " is awake");*/
		Countdown c = new Countdown();
		Mythread t1 = new Mythread(c);
		Mythread t2 = new Mythread(c);
		t1.setName("T1");
		t2.setName("T2");
		t1.start();
		t2.start();
	}//end of main

}


class Mythread extends Thread{
	private Countdown countdown;
	public Mythread(Countdown c) {
		this.countdown = c;
	}
	@Override
	public void run() {
		//this.countdown.doCountdown();
		this.countdown.threadSafeCountdown();
	}
}

class Countdown {
	public void doCountdown() {
		String color = "";
		switch (Thread.currentThread().getName()) {
		case "T1":
			color = "\u001B[91m";
			break;
		case "T2":
			color="\u001B[92m";

		default:
			break;
		}
		
		for(int i = 10; i>0; i--) {
			System.out.println(color + Thread.currentThread().getName() + " : i : " + i);
		}
	}
	
	public synchronized void threadSafeCountdown() {
		System.out.println("############Thread safe countdown started. Current thread is: " + Thread.currentThread().getName());
		String color = "";
		switch (Thread.currentThread().getName()) {
		case "T1":
			color = "\u001B[91m";
			break;
		case "T2":
			color="\u001B[92m";

		default:
			break;
		}
		
		for(int i = 10; i>0; i--) {			
			System.out.println(color + Thread.currentThread().getName() + " : i : " + i);
		}
	}
}




















