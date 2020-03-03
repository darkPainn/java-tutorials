package com.sedat.regularExpressions;

public class RegExIntroduction {

	public static void main(String[] args) {
		String s = "I am a string. yes I am";
		//this is the simplest way of using regex by passing string literal
		String y = s.replaceAll("I", "You");
		System.out.println(y);
		
		
		String alphanumeric = "abcDeeef12Ghhiiiijkl99zabcDeee";
		
		// character matcher '.' matches all the charcters
		System.out.println(alphanumeric.replaceAll(".", "Y"));
		
		//charat ^ boundry matcher is always followed by a pattern which could be a string literal or something more complex
		//when we use ^ the reg ex must match the beginning of the string i.e alphanumeric.replaceAll("^bcDeee", "Y") couldnt find the pattern as the string is starting with a
		System.out.println(alphanumeric.replaceAll("^abcDeee", "YYY"));
		
		//you can use the matches() method to fond out if a regex matches a string. The whole target string must match the parameter regex in order to get a true
		System.out.println(alphanumeric.matches("^abcDeeef12Ghhiiiijkl99zabcDeee"));
		
		// '$' boundary matcher will match only if the regex is at the end of the target string
		System.out.println(alphanumeric.replaceAll("Deee$", "The end"));
		
		//find and replace all occurrences of a pattern
		//this replaces each a e and i with X - and it is not searching for an occurrence of the pattern 'aei'
		System.out.println(alphanumeric.replaceAll("[aei]", "X"));
		
		//this one replaces each occurrence of a, e or i only if they are followed by an f or j, the replacement occurs for f and j as well
		System.out.println(alphanumeric.replaceAll("[aei][fj]", "X"));
	}

}
