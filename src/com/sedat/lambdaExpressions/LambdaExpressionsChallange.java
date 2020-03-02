package com.sedat.lambdaExpressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class LambdaExpressionsChallange {
	
	public static void main(String[] args) {
		//challenge 1 - write the following anon class as a lambda expression
		/*System.out.println("startin");
		Runnable runnable = new Runnable() {		
			@Override
			public void run() {
				String s = "Let's split this up into an array";
				String[] sar = s.split(" ");
				for(String part : sar) {
					System.out.println(part);
				}
			};
		};*/
		
		//solution 1
		Runnable r = () -> {
			String s = "Let's split this up into an array";
			String[] sar = s.split(" ");
			for(String part : sar) {
				System.out.println(part);
			}
		};
		r.run();
		
		//Challenge 2 - write the following method as a lambda expression
		/*public static String everySecondChar(String source) {
			StringBuilder returnVal = new StringBuilder();
			for(int i = 0; i<source.length(); i++) {
				if(i % 2 == 1) {
					returnVal.append(source.charAt(i));
				}
			}
			return returnVal.toString();
		}*/
		
		// solution 2
		Function<String, String> everySecondChar = source -> {
			StringBuilder returnVal = new StringBuilder();
			for(int i = 0; i<source.length(); i++) {
				if(i % 2 == 1) {
					returnVal.append(source.charAt(i));
				}
			}
			return returnVal.toString();
		};		
		//System.out.println(everySecondChar.apply("1234567890"));
		
		//Challenge 3 - write a method to accept the function we wrote on challenge 2 as a parameter and returns the result of the function
		System.out.println(everySecondCharFunc(everySecondChar,"1234567890"));
		
		// Challenge 4 - write code to print the items in the list in sorted order and first letter upper-cased. Use lambda as much as possible
		List<String> top25Names = Arrays.asList("Amelia","Olivia", "emily","Isla", "ava","oliver","Jack","Charlie","harry","Jacob");
		
		//solution 4
		List<String> upper = new ArrayList<>();		
		top25Names.forEach(eachname -> {
			upper.add(eachname.substring(0,1).toUpperCase() + eachname.substring(1));
		});
		upper.sort( (s1, s2) -> s1.compareTo(s2) );
		//System.out.println(upper);
		
		// Challenge 5 - change the challenge 4 so that the code uses method reference instead
		//Solution 5
		upper.sort(String::compareTo);
		//upper.forEach(System.out::println);
		
		// Challenge 6 - do challenge 5 by using a stream and a chain of stream operations
		//Solution 6
		top25Names
			.stream()
			.map(name -> name.substring(0,1).toUpperCase() + name.substring(1) )
			.sorted(String::compareTo)
			//the peak() method allows you to debug at certain stages of your stream chain. but if the chain doesn't contain a terminal method, then the whole chain is ignored
			.peek(System.out::println)
			.forEach(System.out::println);
		
		// Challenge 7 - instead of printing out sorted names, print how many letters begin with 'A'
		//Solution 7
		long nameCount = top25Names.stream()
							.map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
							.filter(name -> name.startsWith("A"))
							.count();
		
		System.out.println("Number of names beginning with A: " + nameCount);
		
		
	}//end of main
	
	//solution 3
	public static String everySecondCharFunc(Function<String, String> func, String source) {
		return func.apply(source);
	}

}






























