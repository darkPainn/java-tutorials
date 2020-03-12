package com.sedat.networking;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {

	public static void runServer() {
		try {
			DatagramSocket socket = new DatagramSocket(5001);
			
			while(true) {
				byte[] buffer = new byte[50];
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
				socket.receive(packet);
				System.out.println("Packet received: " + new String(buffer, 0, packet.getLength()));
				
				//if you want to send the received packet somewhere (back to the client in this example)
				String returnString = "returning from server: " + new String(buffer, 0, buffer.length);
				byte[] buffer2 = returnString.getBytes();
				//we can define the address to be what we want
				InetAddress address = packet.getAddress();
				int port = packet.getPort();
				packet = new DatagramPacket(buffer2, buffer2.length, address, port);
				socket.send(packet);
			}
		}catch(SocketException e) {
			e.printStackTrace();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}
