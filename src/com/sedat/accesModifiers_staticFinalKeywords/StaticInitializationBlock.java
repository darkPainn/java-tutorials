package com.sedat.accesModifiers_staticFinalKeywords;

/**
 * 
 * @author sedat.turkoglu
 * SIB (static initialization block) is static equivalent of constructors.
 * Constructors are not static and are executed every time we create an instance of the class, but SIB is executed only once
 * when the class is firstly loaded into the project. SIB can be thought as a class constructor even tho it is not really the correct term.
 * static final variable must be initialized by the time all SIB blocks terminate. In the same way we can set the final variable in the constructor,
 * we can set the value of a static final variable inside a SIB.
 * SIB is an advanced feature and rarely used.
 * In a class there can be as many SIBs as you want, and they are called in the same order they are declared in the class.
 */
public class StaticInitializationBlock {
	
	public static final String OWNER;
	
	static {
		OWNER = "Sedat";
		System.out.println("First SIB is called");
	}
	
	public StaticInitializationBlock() {
		System.out.println("SIB constructor called");
	}
	
	static {
		System.out.println("Second SIB called");
	}
	
	public void someMethod() {
		System.out.println("Some method called");
	}
	
	public static void main(String[] args) {
		System.out.println("Main method called");
		StaticInitializationBlock sib = new StaticInitializationBlock();
		sib.someMethod();
		System.out.println("Owner is: " + StaticInitializationBlock.OWNER);
	}

}





















