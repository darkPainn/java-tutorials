package com.sedat.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class URLConnectionsAndInputStreamReader {

	public static void main(String[] args) {
		
		try {
			//connecting to the Internet, the URL constructor has versions to accept ports, protocol etc.
			URL urlexternal = new URL("http://example.org/");
			
			//you can convert a URL to a URI
			//URI uri = urlexternal.toURI();
			
			//reading from the url
			BufferedReader reader = new BufferedReader(new InputStreamReader(urlexternal.openStream()));
			String line = "";
			while(line != null) {
				line = reader.readLine();
				//System.out.println(line);
			}
			reader.close();
			
			//another way of reading a web page
			/*
			 * urlexternal.openConnection(); doesn't connect to the url, it returns an open connection instance that you can use to configure the connection.
			 * you can decide say if you want to read from the connection, or write to it. So it gives you a chance to set any configurations
			 * and settings that will influence how the connection is made.
			 * You might call a few methods between the openConnection() and connect()
			 * By default you can only read from a connection, if you want to write you need to call connection.setDoOutput(true);
			 */
			
			URLConnection connection = urlexternal.openConnection();			
			connection.connect();
			BufferedReader conreader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line1 = "";
			while(line1 != null) {
				line1 = conreader.readLine();
				//System.out.println(line1);
			}
			conreader.close();
			
			//you can do alot more with a connection like getting the headers
			Map<String, List<String>> headerFields = connection.getHeaderFields();

			for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
				String key = entry.getKey();
				List<String> value = entry.getValue();
				System.out.println("--------------key: " + key);
				for (String eachValue : value) {
					System.out.println("value: " + eachValue);
				}
			}
			
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
