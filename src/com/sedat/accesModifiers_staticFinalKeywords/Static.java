package com.sedat.accesModifiers_staticFinalKeywords;

public class Static {

	public static void main(String[] args) {

		StaticTest t1 = new StaticTest();
		// even tho we r incrementing nonStaticInstantCount in the constructor, both below statements will print 1 because each object has its own copy of nonStaticInstantCount
		System.out.println("Non-Static instance count: " + t1.getNonStaticInstantCount());
		System.out.println("Static instance count: " + StaticTest.getStaticInstantCount());
		
		StaticTest t2 = new StaticTest();		
		System.out.println("Non-Static instance count: " + t2.getNonStaticInstantCount());		
		System.out.println("Static instance count: " + StaticTest.getStaticInstantCount());
		
		StaticTest t3 = new StaticTest();		
		System.out.println("Non-Static instance count: " + t3.getNonStaticInstantCount());		
		System.out.println("Static instance count: " + StaticTest.getStaticInstantCount());
	}

}
