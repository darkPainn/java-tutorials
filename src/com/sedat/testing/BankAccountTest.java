
package com.sedat.testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test units have to be annotated with \@Test, they must also be public and void
 * Test method names should give some indication of the actual condition they are testing.
 * assertNotEquals is used when you don't want the actual value to be equal to a specific value
 * assertArrayEquals when we want to verify the value of an array. it is true when both arrays are same length, they contain same items and in the same order
 * assertNull assertNotNull to check for null and not null values
 * assertSame assertNotSame to check if two instances are the exact same instances - checks if two refs point to the same object
 * assertThat compares the actual value against a matcher. We can compare the actual value against a range of values. only available from JUnit 4.4
 * When you are expecting an exception to be thrown from a test case and you don't want it to show on the console, and you want the program to continue:
 * \@Test(expected = ExceptionName.class)
 */
public class BankAccountTest {
	private static BancAccount ac;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass() called");		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass() called");
	}


	@Before
	public void setUp() throws Exception {
		System.out.println("setUp() called");
		ac = new BancAccount("John", "Doe", 1000.00);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown() called");
	}

	@Test
	public void deposit() {		
		double balance = ac.deposit(200, true);
		System.out.println(balance);
		//in the below method the first param is the value we expect, second is the value we want to test and third is the delta, which allows some lee way in the comparison.
		//This is useful when comparing double values
		assertEquals("The balance is not 1200",1200, balance,0);
	}

	@Test
	public void withdraw() {
		ac.withdraw(400, true);
		assertEquals(600, ac.getBalance(), 0);
	}

	@Test
	public void getBalance() {
		assertEquals(1000, ac.getBalance(), 0);
	}

}
