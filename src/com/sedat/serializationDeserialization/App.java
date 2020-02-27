package com.sedat.serializationDeserialization;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class App {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\sedat.turkoglu\\Documents\\workspaces\\java\\tutorials\\inheritance\\src\\com\\sedat\\myFile.dat");
				
		MySerializableObject s1 = new MySerializableObject("This is one", 1);
		MySerializableObject s2 = new MySerializableObject("This is two", 2);
		MySerializableObject s3 = new MySerializableObject("This is three", 3);
		MySerializableObject s4 = new MySerializableObject("This is four", 4);
		
		ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
		out.writeObject(s1);
		out.writeObject(s2);
		out.writeObject(s3);
		out.writeObject(s4);
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
		boolean eof = false;
		while(!eof) {
			try {				
				MySerializableObject temp = (MySerializableObject) in.readObject();
				System.out.println(temp);
			}catch(EOFException e) {
				eof = true;
			
			//this will be thrown when the runtime cannot find the corresponding class when reading the object from the file
			}catch(ClassNotFoundException e) {
				System.out.println("Class not found" + e.getMessage());
			}
		}
		
		
	}//end of main

}




















