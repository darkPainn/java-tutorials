package com.sedat.java_collections;

/**
 * 
 * @author sedat.turkoglu
 * At the top level of the Collections framework is the Collections class which exposes a static method that either operate on collections,
 * such as the sort() method, they also return collections object such as the list method.
 * The interfaces in the collection framework allow framework to be extended and they define methods for all the fundamental operations that are required of the collections types.
 * One of the design goals of the collections framework is that there should be good interoperability among various collections - not only the ones included in the framework
 * but also any potential ones that may be created in the future.
 * 
 * The HashSet class is unordered set and LinkedHashSet is ordered.
 * 
 * Collection class provides a binary search method, but to get that to work you need to implement the comparable interface in the class that is being passed to a collection.
 * In this case Seat class is used in the Theater class in a collection, so we implement Comparable in Seat class 
 */
public class CollectionsIntroduction {

	public static void main(String[] args) {
		Theatre olimpos = new Theatre("Olimpos", 8, 12);
		//olimpos.getSeats();
		olimpos.reserveSeat("H01");
		olimpos.reserveSeatBinary("H02");
	}

}
