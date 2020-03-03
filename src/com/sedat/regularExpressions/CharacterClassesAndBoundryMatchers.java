package com.sedat.regularExpressions;

public class CharacterClassesAndBoundryMatchers {

	public static void main(String[] args) {
		
		//one example of using the [] in a regular expression would be to find a word in a string, that maybe an upper or lower case 
		//lets say we wanted to find the name Harry or harry without upper or lower casing the target string
		System.out.println("Harry".replaceAll("[Hh]arry", "Harry"));
		System.out.println("harry".replaceAll("[Hh]arry", "Harry"));
		
		//to replace every character in a string except some certain characters
		String alphanumeric = "abcADeeef124567Ghhiiiijkl99zabcDeee!*-";
		
		//replace everything with X except e and j
		//when we use the ^ as the first character inside the square brackets, it is actually a charcter class not a boundry matcher
		System.out.println(alphanumeric.replaceAll("[^ej]", "X"));
		
		//to replace all occurrences of a-f and 3-8 inclusive
		System.out.println(alphanumeric.replaceAll("[a-f3-8]", "X"));
		//which is same as
		System.out.println(alphanumeric.replaceAll("[abcdef345678]", "X"));
		
		//to ignore the case sensitivity use (?i)
		System.out.println(alphanumeric.replaceAll("(?i)[a-f3-8]", "X"));
		
		//to match any digit use \d character class
		System.out.println(alphanumeric.replaceAll("\\d", "X"));
		
		//to match any non-digit use \D character class
		System.out.println(alphanumeric.replaceAll("\\D", "X"));
		
		//to remove all the white space \s character class
		String withWhiteSpace = "I have blanks and a \t tab, and also a new line\n";
		System.out.println(withWhiteSpace);
		System.out.println(withWhiteSpace.replaceAll("\\s", ""));
		
		//to match any non-whitespace
		System.out.println(withWhiteSpace.replaceAll("\\S", "X"));
		
		//to match a-z, A-Z, 0-9 and underscore _ use \w character class
		System.out.println(alphanumeric.replaceAll("\\w", "X"));
		System.out.println(alphanumeric.replaceAll("\\W", "X"));
		
		// \b matches word boundaries. It assumes that the words are separated by whitespace
		//following surrounds each words with the replacement string 'X' in this case
		System.out.println(withWhiteSpace.replaceAll("\\b", "X"));
		
		
	}

}
