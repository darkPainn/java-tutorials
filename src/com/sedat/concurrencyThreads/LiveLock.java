package com.sedat.concurrencyThreads;

/**
 * 
 * @author sedat.turkoglu
 * Live locks occurs when threadA is looping until threadB completes its task, 
 * and threadB is looping until threadA completes its task, so none of the threads actually terminates
 * 
 */
public class LiveLock {

	public static void main(String[] args) {
		
		final Worker worker1 = new Worker("Worker 1", true);
		final Worker worker2 = new Worker("Worker 2", true);
		final SharedResource resource = new SharedResource(worker1);
		
		new Thread(new Runnable() {			
			@Override
			public void run() {
				worker1.work(resource, worker2);
			}
		}).start();
		
		new Thread(new Runnable() {			
			@Override
			public void run() {
				worker2.work(resource, worker1);
			}
		}).start();
	}

}

class SharedResource{
	private Worker owner;
	
	public SharedResource(Worker owner) {
		this.owner = owner;
	}

	public Worker getOwner() {
		return owner;
	}

	public synchronized void setOwner(Worker owner) {
		this.owner = owner;
	}
}

class Worker{
	private String name;
	private boolean active;
	public Worker(String name, boolean active) {
		super();
		this.name = name;
		this.active = active;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public synchronized void work(SharedResource resource, Worker anotherWorker) {
		while(this.active) {
			if(resource.getOwner() != this) {
				try {
					wait(10);
				}catch(InterruptedException e) {
					
				}
				continue;
			}
			if(anotherWorker.isActive()) {
				System.out.println(getName() + " : give the resource to the worker " + anotherWorker.getName());
				resource.setOwner(anotherWorker);
				continue;
			}
			System.out.println(getName() + " : working on the common resource");
			this.active = false;
			resource.setOwner(anotherWorker);
		}
	}
}























