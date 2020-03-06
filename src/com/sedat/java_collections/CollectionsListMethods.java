package com.sedat.java_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsListMethods {

	public static void main(String[] args) {
		Theatre olimpos = new Theatre("Olimpos", 8, 12);
		
		/*this is called a shallow copy which means the copy doesn't contain new seat objects but instead the same objects from olimpos
		 * we have two list objects but they the same data
		*/
		List<Seat> seatscopy = new ArrayList<>(olimpos.getSeatss());
		
		//below 2 lines confirm that the when we modify one object from one list, the effect can be seen on the other list as well.
		olimpos.getSeatss().get(1).reserve();
		seatscopy.get(1).reserve();
		
		/*
		 * to confirm that olimpos.seats and seatscopy are different objects
		 * we reverse the seatscopy then print both
		 * also this line prints true: System.out.println(Collections.min(seatscopy) == Collections.min(olimpos.getSeatss()));
		 */
		Collections.reverse(seatscopy);
		System.out.println("Printing olimpos.getSeatss()");
		printSeats(olimpos.getSeatss());
		System.out.println("Printing seatscopy");
		printSeats(seatscopy);
		
		//shuffle() from the Collections class shuffles the elements of the lists in a random order
		Collections.shuffle(olimpos.getSeatss());
		
		/**
		 * The min and max return the smallest and highest elements from the collection according to their natural
		 * sort order
		 */
		System.out.println("Max is: " + Collections.max(seatscopy).getSeatNumber());
		System.out.println("Min is: " + Collections.min(seatscopy).getSeatNumber());
		
		sortList(seatscopy);
		printSeats(seatscopy);
		
		printSeatsWithPrice(seatscopy);
		
	}
	
	public static void printSeats(List<Seat> seats) {
		for(Seat s : seats) {
			System.out.print(" " + s.getSeatNumber());
		}
		System.out.println();
		System.out.println("==============================");
	}
	
	public static void printSeatsWithPrice(List<Seat> seats) {
		for(Seat s : seats) {
			System.out.println(" " + s.getSeatNumber() + " " + s.getPrice());
		}
	}	
	
	/*
	 * If you want to provide your own sort; the Collections class provides a swap method to swap two elements in the list
	 * we pass the name of the list and the index position of the 2 elements that we want to swap
	 * In this example we are using bubble sort to sort the list which is less effective than merge sort but this one requires
	 * far more less memory than the merge sort
	 */
	public static void sortList(List<? extends Seat> list) {
		for(int i = 0; i < list.size()-1; i++) {
			for(int j = i+1; j < list.size(); j++) {
				if(list.get(i).compareTo(list.get(j)) > 0) {
					Collections.swap(list, i, j);
				}
			}
		}
	}

}




























