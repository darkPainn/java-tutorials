package com.sedat.java_collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author sedat.turkoglu
 * Bulk operations from set such as addAll, clear(), union are destructive
 */
public class SetBulkOperations {

	public static void main(String[] args) {
		
		Set<Integer> squares = new HashSet<>();
		Set<Integer> cubes = new HashSet<>();
		
		for(int i = 1; i <= 100; i++) {
			squares.add(i * i);
			cubes.add(i * i * i);
		}
		
		System.out.println("There are " + squares.size() + " squares and " + cubes.size() + " cubes.");
		
		//union
		Set<Integer> union = new HashSet<>(squares);
		union.addAll(cubes);
		System.out.println("Union contains " + union.size() + " elemnts");
		
		//intersection
		Set<Integer> intersection = new HashSet<>(squares);
		intersection.retainAll(cubes);
		System.out.println("Intersection contains " + intersection.size() + " elements.");
		
		//to confirm the intersection
		for(int i : intersection) {
			System.out.println(i + " is the square of " + Math.sqrt(i) + " and the cube of " + Math.cbrt(i));
		}
		
		Set<String> nature = new HashSet<>();
		Set<String> divine = new HashSet<>();
		String[] natureWords = {"all","nature","is","but","art","unknown","to","thee"};
		String[] divineWords = {"to","err","is","human","to","forgive","divine"};
		nature.addAll(Arrays.asList(natureWords));
		divine.addAll(Arrays.asList(divineWords));
		
		System.out.println("############ nature - divine ###############");
		Set<String> diff1 = new HashSet<>(nature);
		diff1.removeAll(divine);
		printSet(diff1);
		
		System.out.println("################# divine - nature ################");
		Set<String> diff2 = new HashSet<>(divine);
		diff2.removeAll(nature);
		printSet(diff2);
		
		
		//symmetric difference is removing the intersection from the union
		Set<String> unionstr = new HashSet<>(nature);
		unionstr.addAll(divine);
		
		Set<String> intersecstr = new HashSet<>(nature);
		intersecstr.retainAll(divine);
		
		System.out.println("Smmetric difference");
		unionstr.removeAll(intersecstr);
		printSet(unionstr);
		
		
	}//end of main

	private static void printSet(Set<String> diff1) {
		System.out.print("\t");
		for(String s : diff1) {
			System.out.print(s + " ");
		}
		System.out.println();
	}

}



























