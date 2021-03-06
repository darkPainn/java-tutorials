package com.sedat.testing;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.TargetDataLine;

/**
 * Unit testing usually refers to testing a method.
 * Instead of running unit tests manually, developers can use a unit testing framework to run the tests in an automated fashion.
 * JUnit is a popular testing framework, we can use to run unit tests.
 * You need to add JUnit to your project.
 * When we use JUnit, we test the output of a method against an assertion that we made about the expected output, so the test fails if the assertion is not met
 * 
 */
public class UnitTesting {

	public static void main(String[] args) throws LineUnavailableException {	
		
		AudioFormat format = new AudioFormat(8000.0f,16,1,true,true);
		TargetDataLine microphone = AudioSystem.getTargetDataLine(format);
		//microphone.
		//DataLine.Info info = new DataLine.Info(TargetDataLine.class,format);
		
		Mixer.Info[] mixerInfos = AudioSystem.getMixerInfo();
		 for (Mixer.Info info: mixerInfos){
		  Mixer m = AudioSystem.getMixer(info);
		  Line.Info[] lineInfos = m.getSourceLineInfo();
		  for (Line.Info lineInfo:lineInfos){
		   System.out.println (info.getName()+"###"+lineInfo);
		   Line line = m.getLine(lineInfo);
		   System.out.println("\t#####"+line);
		  }
		  lineInfos = m.getTargetLineInfo();
		  for (Line.Info lineInfo:lineInfos){
		   System.out.println (m+"---"+lineInfo);
		   Line line = m.getLine(lineInfo);
		   System.out.println("\t-----"+line);

		  }

		 }
		
	}

}

class BancAccount {
	private String firstname;
	private String lastname;
	private double balance;
	public BancAccount(String firstname, String lastname, double balance) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.balance = balance;
	}
	
	/**
	 * the branch arguments is true if the customer is performing the transaction
	 * at a branch, false if at an ATM
	 */
	public double deposit(double amount, boolean branch) {
		this.balance += amount;
		return this.balance;
	}
	
	/**
	 * the branch arguments is true if the customer is performing the transaction
	 * at a branch, false if at an ATM
	 */
	public double withdraw(double amount, boolean branch) {
		this.balance -= amount;
		return this.balance;
	}
	
	public double getBalance() {
		return balance;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
