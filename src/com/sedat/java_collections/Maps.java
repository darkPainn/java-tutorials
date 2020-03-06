package com.sedat.java_collections;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author sedat.turkoglu
 * Map interface is part of the collections framework even tho its not a true collection.
 * Map interface replaces the obsolete dictionary abstract class and just like dictionary, it maps the keys to values.
 * Just like a language dictionary where the words are the keys and definitions are the values for a key.
 * Java map cannot contain duplicate keys and each key maps to a single value. If you try to put a new entry with an existing key, the old value is being replaced
 * Commonly used java classes that implement Map interface is HashMap, LinkedHashMap, TreeMap which implements SortedMap interface.
 * Maps are generic, they takes 2 types one for the key and one for the value.
 * 
 */
public class Maps {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		//put() method returns the old value if there was one
		String oldvalue = map.put("Java", "highlevel language");
		map.put("C++","another language");
		printMap(map);
		System.out.println("#############################################");
//		System.out.println(map.get("Java"));
//		System.out.println("Old value was: " + oldvalue);
//		
//		oldvalue = map.put("Java", "my favourite");
//		System.out.println(map.get("Java"));
//		System.out.println("Old value was: " + oldvalue);
		
		//use containsKey(K) method to determine if a map contains a key
		
		//use putAbsent() to make sure the addition will only take place if the key is not already present
//		oldvalue = map.putIfAbsent("Java", "new value");
//		System.out.println(map.get("Java"));
//		System.out.println("Old value was: " + oldvalue);
		
		//use keySet() to retrieve the set of the keys of a map
		
		//use remove(K) to remove a specific key from a map which returns the value
		//System.out.println("Removed: " + map.remove("Java"));
		
		//use remove(K, V) to make sure the removal takes place only if the key value pair is found in the map
		
		// use replace() to replace the entry for a specific key if it is already mapped to a value
		map.replace("Java", "Java is the best");
		map.replace("Scala", "this wont be added");
		//replace method can take 3 arguments replace(key, existingValue, newValue) - for newValue to be added, key and existingValue must be found as a pair
		printMap(map);
		
		
	}
	
	public static void printMap(Map<String, String> map) {
		for(String key : map.keySet()) {
			System.out.println(key + " : " + map.get(key));
		}
	}

}
