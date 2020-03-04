package com.sedat.accesModifiers_staticFinalKeywords;

/**
 * 
 * @author sedat.turkoglu
 * Final keyword is generally used to define constant values. Strictly speaking, the final fields are not actually constants, because they can be modified
 * but only once and any modification must be before the class constructing finishes. We can assign a final field a value either when we first declare it,
 * or in the constructor.
 * So you can either assign a value to a final field when you declare it or in the constructor.
 * Final keyword can also be used at the class level and when it is the case, the class cannot be subclassed - no other class can extend it.
 * When you declare a method final, they cannot be overridden even if the class is not final
 * 
 * The static keyword on the other hand is used to declare constants and assign them a value when they are created.
 * This is useful when we know the value will never change and it doesn't make sense for each instance to have a different value for the field.
 */
public class StaticFinalKeywords {
	
	private final int instancecount;
	private static int classCounter = 0;
	
	public StaticFinalKeywords() {
		classCounter++;
		//now each object will have its own copy and own value, even tho the field is final. Each time the constructor is called
		instancecount = classCounter;
	}

	public static void main(String[] args) {
		Password p = new Password(674312);
		p.storePassword();
		p.letMeIn(4587);
		p.letMeIn(523364);
		p.letMeIn(0);
		p.letMeIn(-1);
		p.letMeIn(674312);
	}

	public int getInstancecount() {
		return instancecount;
	}

}

class Password{
	private static final int KEY = 748576362;
	private final int encryptedPassword;
	
	public Password(int password) {
		this.encryptedPassword = encryptDecrypt(password);
	}

	private int encryptDecrypt(int password) {
		return password ^ KEY;
	}
	
	public void storePassword() {
		System.out.println("Storing password: " + this.encryptedPassword);
	}
	
	public boolean letMeIn(int password) {
		if(encryptDecrypt(password) == this.encryptedPassword) {
			System.out.println("Welcome");
			return true;
		}else {
			System.out.println("Cannot come in");
			return false;
		}
	}
}





























