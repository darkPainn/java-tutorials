package com.sedat.networking;

/**
 * @author sedat.turkoglu
 * User Datagram Protocol (UDP)
 * When using TCP, there is a handshake between client and server, client sends req server sends resp, so it is two way communication and there is a tight-coupling between them.
 * TCP also does error checking and resends the messages to server if they don't make it.
 * When using UDP there is no handshake at all, and the destination host which may or may not be a server doesn't actually send any responses to the message sender.
 * So you use UDP when you don't need a reliable connection, or two way connection or speed essential. It is mostly used for time-sensitive communication.
 * 
 * This demo doesn't use Threads but in a real-world application you would use Threads.
 */
public class UDPMain {

	public static void main(String[] args) {
		Thread server = new Thread("server") {
			@Override
			public void run() {
				UDPServer.runServer();
			}
		};
		
		Thread client = new Thread("client") {
			@Override
			public void run() {
				UDPClient.runClient();
			}
		};
		
		server.start();
		client.start();
	}

}
