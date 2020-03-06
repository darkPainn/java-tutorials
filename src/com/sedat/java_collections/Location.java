package com.sedat.java_collections;

import java.util.HashMap;
import java.util.Map;

public class Location {
	
	private final int locationID;
	private final String description;
	private final Map<String, Integer> exits;
	
	public Location(int locationID, String description) {
		this.locationID = locationID;
		this.description = description;
		this.exits = new HashMap<>();
		this.exits.put("Q",0);
	}
	
	public void addExit(String direction, int location) {
		this.exits.put(direction,location);
	}

	public int getLocationID() {
		return locationID;
	}

	public String getDescription() {
		return description;
	}

	public Map<String, Integer> getExits() {
		//returning a new map object with the same data ensures that no one can modify the data outside this class
		return new HashMap<>(this.exits);
	}

}
