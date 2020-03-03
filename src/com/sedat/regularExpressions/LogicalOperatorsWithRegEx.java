package com.sedat.regularExpressions;

public class LogicalOperatorsWithRegEx {

	public static void main(String[] args) {
		
		//[H|h] means lower or upper case h
		System.out.println("harry".replaceAll("[H|h]arry", "Larry"));
		
		//the not operator examples
		//1- when the ^ is the first character in the square brackets it means not [^abc] - not abc
		//2- the ! opertaor
		String tvtest = "tstvtkt";
		//find all t s that arent followed by v
		String ts = "t(?!v)";
		System.out.println(tvtest.replaceAll(ts, "X"));
		
		//find all t s followed by v but don't include v = "t(?=v)"
		
		//to validate a credit card number
		//must start with 4, following 4 we expect 12 numbers then optinal 3 characters
		String cardregex = "^4[0-9]{12}([0-9]{3})?$";
		System.out.println("4444444444444".matches(cardregex));
	}

}
