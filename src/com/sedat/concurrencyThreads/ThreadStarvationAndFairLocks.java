package com.sedat.concurrencyThreads;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author sedat.turkoglu
 * Starvation occurs when a thread never gets a chance to run - or waits a long time to do so.
 * This could be because there are lots of threads waiting to get a chance to run a synchronized code
 * but a thread never gets a chance because the OS randomly chooses other threads when the lock becomes 
 * available
 */
public class ThreadStarvationAndFairLocks {
	
	//when we put the lock on this object, the execution is not first come first serve, it is up to the OS
	//private static Object lock = new Object();
	
	//this assures that the order of execution is first come first serve with parameter true 
	private static ReentrantLock lock = new ReentrantLock(true);

	public static void main(String[] args) {
		Thread t1 = new Thread(new Worker("\u001B[91m"), "Priority 10");
		Thread t2 = new Thread(new Worker("\u001B[92m"), "Priority 8");
		Thread t3 = new Thread(new Worker("\u001B[93m"), "Priority 6");
		Thread t4 = new Thread(new Worker("\u001B[94m"), "Priority 4");
		Thread t5 = new Thread(new Worker("\u001B[95m"), "Priority 2");
		
		//the priority is only a suggestion to the OS, we can never force OS to run a particular thread first
		t1.setPriority(10);
		t2.setPriority(8);
		t3.setPriority(6);
		t4.setPriority(4);
		t5.setPriority(2);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
	
	private static class Worker implements Runnable{
		private int runcount = 1;
		private String threadColor;
		
		public Worker(String color) {
			this.threadColor = color;
		}
		//when using unfair lock
		/*@Override
		public void run() {
			for(int i = 0; i < 100; i++) {
				synchronized(lock) {
					System.out.format(this.threadColor + "%s: runcount = %d\n" , Thread.currentThread().getName(), this.runcount++);
				}
			}
		}*/
		
		//when using fair lock
		@Override
		public void run() {
			for(int i = 0; i < 100; i++) {
				lock.lock();
				try {
					System.out.format(this.threadColor + "%s: runcount = %d\n" , Thread.currentThread().getName(), this.runcount++);
				}finally {
					lock.unlock();
				}
			}
		}		
	}

}
