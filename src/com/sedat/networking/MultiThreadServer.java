package com.sedat.networking;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @author sedat.turkoglu
 * This server accepts connections from multiple clients.
 * Servers that can connect to multiple clients will run multiple threads. We need to enable server to respond to each client
 * within a new thread
 */
public class MultiThreadServer {
	
	public static void runServers() {
		
		try(ServerSocket serverSocket = new ServerSocket(5000)) {
            while(true) {
                new Echoer(serverSocket.accept()).start();
            }


        } catch(IOException e) {
            System.out.println("Server exception " + e.getMessage());
        }
	}

}
