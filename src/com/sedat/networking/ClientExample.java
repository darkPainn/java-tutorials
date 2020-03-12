package com.sedat.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientExample {

	public static void runClient() {
		//System.out.println("Client running");
		
		try(Socket socket = new Socket("localhost", 5000)){
			BufferedReader echoes = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);
			
			Scanner scanner = new Scanner(System.in);
			String echoString;
			String response;
			
			do {
				System.out.println("Enter a string to be echoed");
				echoString = scanner.nextLine();
				
				//send the string to the server
				stringToEcho.println(echoString);
				
				if(!echoString.equalsIgnoreCase("exit")) {
					response = echoes.readLine();
					System.out.println(response + " in clientexample 32");					
				}else {
					scanner.close();
				}
				
			}while(!echoString.equalsIgnoreCase("exit"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void runClients(String strToEcho) {
		try(Socket socket = new Socket("localhost", 5000)){
			//BufferedReader echoes = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);
			stringToEcho.println(strToEcho);
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
