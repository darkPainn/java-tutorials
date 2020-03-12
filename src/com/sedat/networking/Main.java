package com.sedat.networking;

public class Main {

	public static void main(String[] args) {
		System.out.println("starting");
		/*Thread server = new Thread("serverthread") {			
			@Override
			public void run() {
				ServerExample.runServer();
			}
		};
		server.start();*/
		
		MultiThreadServer.runServers();
		
		int i = 1;
		while(i <= 10) {
			Thread client = new Thread("clientthread") {
				@Override
				public void run() {
					ClientExample.runClients("This is the string to echo");
				}
			};
			client.start();
			i++;
		}
		/*Thread client = new Thread("clientthread") {			
			@Override
			public void run() {
				ClientExample.runClient();
			}
		};
		client.start();*/
	}

}
