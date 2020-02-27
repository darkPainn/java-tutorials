package com.sedat.concurrencyThreads;

/**
 * 
 * @author sedat.turkoglu
 * The process will never terminate because a deadlock is occurring between thread1 and thread2
 * this is because each thread is waiting for a lock that is held by the other thread.
 */
public class Deadlocks {
	
	public static Object lock1 = new Object();
	public static Object lock2 = new Object();

	public static void main(String[] args) {
		new Thread1().start();
		new Thread2().start();
	}
	
	private static class Thread1 extends Thread{
		@Override
		public void run() {
			synchronized(lock1) {
				System.out.println("Thread1 has lock 1");
				try {
					Thread.sleep(100);
				}catch(InterruptedException e) {
					
				}
				System.out.println("Thread1 is waiting for lock2");
				synchronized(lock2) {
					System.out.println("Thread1 has lock1 and lock2");
				}
				System.out.println("Thread1 released lock2");
			}
			System.out.println("Thread1 released lock1. Exiting...");
		}
	}
	
	private static class Thread2 extends Thread{
		@Override
		public void run() {
			synchronized(lock2) {
				System.out.println("Thread2 has lock 2");
				try {
					Thread.sleep(100);
				}catch(InterruptedException e) {
					
				}
				System.out.println("Thread2 is waiting for lock1");
				synchronized(lock1) {
					System.out.println("Thread2 has lock2 and lock1");
				}
				System.out.println("Thread2 released lock1");
			}
			System.out.println("Thread2 released lock2. Exiting...");
		}
	}
}
