package com.sedat.accesModifiers_staticFinalKeywords;

public class StaticTest {
	
	private int nonStaticInstantCount = 0;
	private static int staticInstantCount = 0;
	
	
	public StaticTest() {
		//every time the class is instantiated, each object will have the value 1
		this.nonStaticInstantCount++;
		//every time the class is instantiated, each object will have the incremented value
		staticInstantCount++;
	}
	public int getNonStaticInstantCount() {
		return nonStaticInstantCount;
	}
	public static int getStaticInstantCount() {
		return staticInstantCount;
	}
}
