package com.sedat.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HTTPUrlConnection {

	public static void main(String[] args) {
		
		try {
			
			URL url = new URL("http://example.org/");
			HttpURLConnection conection = (HttpURLConnection) url.openConnection();
			//optionally you can set the http request method. if you want to do a POST, you need to conection.setDoOutput(true); so that you can write to the connection			
			conection.setRequestMethod("GET");
			
			/*
			 * conection.setRequestProperty(key, val) call is to set the http header properties of a connection.
			 * there are many properties defined here: https://en.wikipedia.org/wiki/List_of_HTTP_header_fields
			 * the method allows you to set a property as a key-value pairs, 
			 * and if there's multiple values for a single key then you separate them with a comma in the call:
			 *  conection.setRequestProperty("key", "val1,val2,val3...");
			 */
			conection.setRequestProperty("User-Agent", "Chrome");
			
			//timeout - in case the server is down or slow so that your application won't hang waiting for a response
			conection.setReadTimeout(3000);
			
			int responseCode = conection.getResponseCode();
			System.out.println("Response code: " + responseCode);
			
			BufferedReader inputreader = new BufferedReader(new InputStreamReader(conection.getInputStream()));
			String line;
			while((line = inputreader.readLine()) != null) {
				line = inputreader.readLine();
				System.out.println(line);
			}
			inputreader.close();
			
			
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
