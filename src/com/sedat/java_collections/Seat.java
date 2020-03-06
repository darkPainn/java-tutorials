package com.sedat.java_collections;

public class Seat implements Comparable<Seat>{
	private final String seatNumber;
	private boolean reserved = false;
	private double price;
	
	public Seat(String seatnumber, double price) {
		this.seatNumber = seatnumber;
		this.price = price;
	}
	
	public boolean reserve() {
		if(!this.reserved) {
			this.reserved = true;
			System.out.println("Seat " + this.seatNumber + " is reserved.");
			return true;
		}else {
			System.out.println("Seat " + this.seatNumber + " is reserved already");
			return false;
		}
	}
	
	public boolean cancel() {
		if(this.reserved) {
			this.reserved = false;
			System.out.println("Reservation for " + this.seatNumber + " is cancelled.");
			return true;
		}else {
			return false;
		}
	}
	
	public String getSeatNumber() {
		return this.seatNumber;
	}
	
	public double getPrice() {
		return this.price;
	}

	@Override
	public int compareTo(Seat anotherSeat) {
		//System.out.print("*");
		return this.getSeatNumber().compareToIgnoreCase(anotherSeat.getSeatNumber());
	}
}
