package com.sedat.java_collections;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author sedat.turkoglu
 * Sets has no defined ordering, no duplications are allowed.
 * Set interface is generic and takes a single T which defines basic functionality such as add get clear, size contains etc
 * There is no way to retrieve an item from a set such as attempting to get the 10th element from the set is not possible.
 * A set cannot be an element of itself such as Set<Set>
 * HashSet is the best performing implementation of set interface and uses hashes to store the items.
 * Whenever an element is added to a set, it becomes the key in the underlying hashmap and dummy object is stored as the value.
 * Operations on set are very fast and they also provide the mathematical set operations such as union, intersection etc.
 * 
 */
public class SetsAndHashSet {

	public static void main(String[] args) {
		
		Set<Planet> solarSystem = Populater.populatesolarsystem();
		Set<Moon> moons = new HashSet<>();
		
		System.out.println("############### OUR SOLAR SYSTEM ####################");
		System.out.println("Planets:");
		for(Planet planet : solarSystem) {			
			System.out.println("\t" + planet.getName());
			if(planet.getMoons() != null) {
				moons.addAll(planet.getMoons());
			}
		}
		
		//union of two or more sets is a set containing all the elements of the sets. each element will appear only once in the union even if they were present multiple times in the combined sets
		System.out.println("Moons:");
		for(Moon moon : moons) {			
			System.out.println("\t" + moon.getName());
		}		
	}

}

class Moon{
	private final String name;
	public Moon(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
}

class Planet {
	private final String name;
	private Set<Moon> moons;
	public Planet(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void addMoon(Moon moon) {
		if(this.moons == null) {
			this.moons = new HashSet<>();
		}
		this.moons.add(moon);
	}
	public Set<Moon> getMoons(){
		return this.moons;
	}
	
	@Override
	public boolean equals(Object otherPlanet) {
		if(this == otherPlanet) return true;
		//make sure not to return true if a Planet object is being compared to a subclass of it. If the planet was final then this check would be unnecessary
		if( (otherPlanet == null) || (otherPlanet.getClass()!=this.getClass()) ) {
			return false;
		}
		System.out.println("this.name:" + this.name );
		String secondObjectName = ((Planet) otherPlanet).getName();
		System.out.println("otherplanet name: " + secondObjectName);
		
		return this.name.equals(secondObjectName);
	}
	
	/**
	 * How you generate the hashcode is up to you as long as the same object will always generate the same hashcode during any execution of your program.
	 * Also objects that compare equal have the same hashcode. Once these two are done than the requirements are satisfied. 
	 * You can always return 0 which would satisfy the requirements, but that defeats the purpose of hashing in terms of performance, as all the objects
	 * would end up in the bucket with address 0.
	 * 
	 */
	@Override
	public int hashCode() {
		int newHascode = this.name.hashCode() + 57;
		System.out.println("Hashcode called new hashcode is: " + newHascode + " for the planet: " + this.name);
		return newHascode;
	}
}

class Populater{
	
	public static Set<Planet> populatesolarsystem(){
		Set<Planet> solarSystem = new HashSet<>();		
		
		Planet earth = new Planet("Earth");
		earth.addMoon(new Moon("Moon"));
		solarSystem.add(earth);
		
		//without overriding the equals method in Planet, earth gets added twice, as we create a new object. But ideally it should depend on the name
		//of the planet, and if it is already there then it shouldnt be added again even if it is different object
		Planet earth2 = new Planet("Earth");
		earth.addMoon(new Moon("Moon"));
		solarSystem.add(earth2);
		
		Planet mercury = new Planet("Mercury");
		solarSystem.add(mercury);
		
		Planet venus = new Planet("Venus");
		solarSystem.add(venus);
		
		Planet mars = new Planet("Mars");
		mars.addMoon(new Moon("Phobos"));
		mars.addMoon(new Moon("Deimos"));
		solarSystem.add(mars);
		
		Planet jupiter = new Planet("Jupiter");
		jupiter.addMoon(new Moon("Europa"));
		jupiter.addMoon(new Moon("Callisto"));
		jupiter.addMoon(new Moon("Ganymede"));
		solarSystem.add(jupiter);
		
		Planet saturn = new Planet("Saturn");
		saturn.addMoon(new Moon("Mimas"));
		saturn.addMoon(new Moon("Enceladus"));
		saturn.addMoon(new Moon("Tethys"));
		saturn.addMoon(new Moon("Titan"));
		solarSystem.add(saturn);		
		
		return solarSystem;
	}
}


























