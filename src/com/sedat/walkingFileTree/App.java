package com.sedat.walkingFileTree;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class App {

	public static void main(String[] args) throws IOException {
		MyFileVisitor visitor = new MyFileVisitor();
		Path path = (Path) FileSystems.getDefault().getPath("C:\\Users\\sedat.turkoglu\\Documents\\workspaces\\java\\tutorials");
		Files.walkFileTree(path, visitor);
		
	}//end of main

}




















