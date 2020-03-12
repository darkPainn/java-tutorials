package com.sedat.networking;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class UDPClient {

	public static void runClient() {
		try {
			
			InetAddress address = InetAddress.getLocalHost(); //you would use InetAddress.getAllByName(host) to connect to a server that is on a different host			
			DatagramSocket socket = new DatagramSocket();
			
			Scanner sc = new Scanner(System.in);
			String echoString;
			
			do {
				System.out.println("Enter string to be sent to the server");
				echoString = sc.nextLine();
				
				byte[] buffer = echoString.getBytes();
				
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 5001);
				socket.send(packet);
				
				//if the server is sending anything back
				byte[] buffer2 = new byte[50];
				packet = new DatagramPacket(buffer2, buffer2.length);
				socket.receive(packet);
				System.out.println("Package received: " + new String(buffer2, 0, packet.getLength()));
				
			}while(!echoString.equalsIgnoreCase("exit"));
			
			sc.close();
			socket.close();
			
		}catch(SocketTimeoutException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
