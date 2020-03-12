package com.sedat.networking;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author sedat.turkoglu
 * Using the high-level API you don't actually need to know about the ports and sockets, instead you use URLs(Universal resource locater) and URIs (Universal resource identifier).
 * When working with java.net package a URI is an identifier that might not provide enough information to access the resource it identifies - specifies a relative path,
 * a url is an identifier that includes information about how to access the resource it identifies - it has to be an absolute path.
 * The recommended way is to work with URI until you actually want to access a resource and then convert the URI to a URL.
 * 
 * All URLs are also URIs
 * 
 * Commonly used classes include: URI, URL, URLConnection, HttpURLConnection from java.net
 * 
 * A URI doesn't have to be valid to work with it but it has to be valid when you convert it to a URL.
 * A URI can point to a db, filesystem etc.
 */
public class HighLevelAPIMain {

	public static void main(String[] args) {
		try {
			URI uri = new URI("db://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
			URI validuri = new URI("http://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
			
			//components of a URI
			System.out.println("Scheme: " + uri.getScheme()); //db
			System.out.println("Scheme-specific part: " + uri.getSchemeSpecificPart()); ////username:password@myserver.com:5000/catalogue/phones?os=android
			System.out.println("Authority: " + uri.getAuthority()); //username:password@myserver.com:5000
			System.out.println("User info: " + uri.getUserInfo()); //username:password
			System.out.println("Host: " + uri.getHost()); //myserver.com
			System.out.println("Port: " + uri.getPort()); //5000
			System.out.println("Path: " + uri.getPath()); // /catalogue/phones
			System.out.println("Query: " + uri.getQuery()); //os=android
			System.out.println("Fragment: " + uri.getFragment());//samsung
			
			//convert a URI to a URL
			URL url = validuri.toURL();
			System.out.println("URL: " + url);
			
			//you can also define a base URI and resolve them to real URIs so that we can convert them to URLs
			//this approach is handy if you have a lot of absolute URIs on the same address and you can assign the base URI that contains the host information to a URI object
			URI baseURI = new URI("http://username:password@myserver.com:5000");
			URI uri1 = new URI("/catalogue/phones?os=android#samsung");
			URI uri2 = new URI("/catalogue/tvs?manufacturer=samsung");
			URI uri3 = new URI("/stores/locations?zip=1234");
			
			URI resolvedURI1 = baseURI.resolve(uri1);
			URI resolvedURI2 = baseURI.resolve(uri2);
			URI resolvedURI3 = baseURI.resolve(uri3);
			
			URL url1 = resolvedURI1.toURL();
			URL url2 = resolvedURI2.toURL();
			URL url3 = resolvedURI3.toURL();
			System.out.println("URL1: " + url1);
			System.out.println("URL2: " + url2);
			System.out.println("URL3: " + url3);
			
			//you can also reverse the resolving 
			System.out.println("Relativised URI: " + baseURI.relativize(resolvedURI2));			
			
		}catch(URISyntaxException e) {
			e.printStackTrace();
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
