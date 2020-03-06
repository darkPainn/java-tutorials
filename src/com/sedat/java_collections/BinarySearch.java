package com.sedat.java_collections;

import java.util.List;

public class BinarySearch {
	
	public static boolean reserveSeat(Seat seatToFind, List<Seat> seats) {
		
		int low = 0;
		int high = seats.size()-1;
		while(low <= high) {
			System.out.print(".");
			int mid = (low + high) / 2;
			Seat midval = seats.get(mid);
			int comp = midval.getSeatNumber().compareTo(seatToFind.getSeatNumber());
			
			if(comp < 0) {
				low = mid + 1;
			}else if(comp > 0) {
				high = mid - 1;
			}else {
				return seats.get(mid).reserve();
			}
		}
		System.out.println("There is no seat with seat number: " + seatToFind.getSeatNumber());
		return false;
	}

}
