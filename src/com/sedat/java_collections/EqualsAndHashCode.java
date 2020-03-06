package com.sedat.java_collections;

/**
 * 
 * @author sedat.turkoglu
 * Referential equality is when two or more references point to the same object in the memory, and is checked with == operator.
 * If two objects compare equal then their hashcodes also must be the same, which is why if you override equals() you must override hashCode() as well.
 * When storing objects in a hashed collection such as hashset, it has a number of buckets to store the objects in. The hashcode of each object determines
 * which bucket that object will go into. When we add a new object to the collection, its hashcode tells the collection in which bucket it should put the object in.
 * There may already be objects in that bucket, so each existing object is compared to the new one to make sure it is not already in there. 
 * When equals() return true, the hashcode must be the same.
 * 
 */
public class EqualsAndHashCode {
	

	public static void main(String[] args) {
		Example ob1 = new Example("Object 1");
		Example ob2 = new Example("Object 2");
		Example ob3 = ob1;
		System.out.println(ob1.equals(ob2));
		System.out.println(ob1.equals(ob3));
	}

}

class Example{
	
	private static int idcount = 0;
	
	private String desc;
	private int ID;
	
	public Example(String desc) {
		this.desc = desc;
		this.ID = idcount++;
	}

	public String getDesc() {
		return desc;
	}

	public int getID() {
		return ID;
	}
	
	/**
	 * when you override the equals(), the parameter has to be of type Object, otherwise the method is overloaded and not overridden.
	 * 
	 */
	@Override
	public boolean equals(Object secondObject) {
		if(this == secondObject) return true;
		System.out.println("this.getClass: " + this.getClass());
		System.out.println("secondObject.getClass: " + secondObject.getClass());
		if( (secondObject == null) || (secondObject.getClass()!=this.getClass()) ) {
			return false;
		}
		
		String secondObjectName = ((Example) secondObject).getDesc();
		return this.desc.equals(secondObjectName);
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
		int newHascode = this.desc.hashCode() + 57;
		System.out.println("Hashcode called new hashcode is: " + newHascode);
		return newHascode;
	}
	
}



























