package com.sedat.java_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Theatre {
	
	private final String theatreName;
	private List<Seat> seats = new ArrayList<>();
	
	public Theatre(String name, int numRows, int seatsPerRow) {
		this.theatreName = name;
		
		int lastRow = 'A' + (numRows - 1);
		double price = 12.0;
		for(char row = 'A'; row <= lastRow; row++) {
			for(int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
				if( (row < 'D') && (seatNum >= 4 && seatNum <= 9) ) {
					price = 14.0;
				}else if( (row > 'F') || (seatNum < 4 || seatNum > 9) ) {
					price = 7.0;
				}
				Seat seat = new Seat(row + String.format("%02d", seatNum), price);
				seats.add(seat);
			}
		}
	}

	public String getTheatreName() {
		return theatreName;
	}
	
	public boolean reserveSeat(String seatNumber) {
		Seat requestSeat = null;
		for(Seat seat : this.seats) {
			System.out.print(".");
			if(seat.getSeatNumber().equals(seatNumber)) {
				requestSeat = seat;
				break;
			}
		}
		
		if(requestSeat == null) {
			System.out.println("There is no seat with the seat number: " + seatNumber);
			return false;
		}
		return requestSeat.reserve();
	}
	
	public boolean reserveSeatBinary(String seatNum) {
		Seat requestedSeat = new Seat(seatNum, 12.0);
		//passing null means we are using our own comparator which defined in Seat class
		int foundSeat = Collections.binarySearch(this.seats, requestedSeat, null);
		if(foundSeat >= 0) {
			return this.seats.get(foundSeat).reserve();
		}else {
			System.out.println("There is no seat with the seat number: " + seatNum);
			return false;
		}
	}
	
	//for testing
	public void getSeats() {
		for(Seat seat : this.seats) {
			System.out.println(seat.getSeatNumber());
		}
	}
	
	public List<Seat> getSeatss(){
		return this.seats;
	}

}
























