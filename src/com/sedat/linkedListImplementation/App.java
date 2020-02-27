package com.sedat.linkedListImplementation;

public class App {

	public static void main(String[] args) {
		LinkedList list = new LinkedList(null);
		list.traverse(list.getRoot());
		
		String data = "Erzincan Mus Kars Antalya Edirne Istanbul Kastamonu Konya Bursa Gebze Erzincan";
		String[] dataAr = data.split(" ");
		for(String s : dataAr) {
			list.addItem(new Node(s));
		}
		
		list.traverse(list.getRoot());
		
		list.removeItem(new Node("Kastamonu"));
		
		list.traverse(list.getRoot());
		
	}//end of main

}




















