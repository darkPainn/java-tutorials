package com.sedat.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author sedat.turkoglu
 * This server's purpose is just to echo back to the client, whatever text the client send to it
 */
public class ServerExample {

	public static void runServer() {
		
		//the port number can be an integer 0 - 65.535 inclusive. To find out if a port number is already in use, assign a port number and see if Socket instance is successfully created
		try(ServerSocket serverSocket = new ServerSocket(5000)){
			//we want the server to listen to clients on the port we've assigned. to do that we gonna call server socket accept method which returns a socket instance, 
			//which will be the socket used to communicate with the client
			Socket socket = serverSocket.accept();
			
			//the accept method is gonna block into a client that connects to the server and the execution flow will be blocked there
			System.out.println("Client connected!");
			
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			//second parameter specifies whether you want to automatically flush the output stream
			PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
			
			//we remain listening while the client is alive
			while(true) {
				String echoStr = input.readLine();
				if(echoStr != null && echoStr.equals("exit")) {
					break;
				}
				output.println("Echo from server: " + echoStr);
			}
		}catch(IOException e) {
			System.out.println("Server exception " + e.getMessage());
		}
	}

}



















