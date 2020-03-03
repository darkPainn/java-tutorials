package com.sedat.regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionChallenge {

	public static void main(String[] args) {
		
		//challange1 - write the string literal regex to match to match "I want a bike"
		System.out.println("I want a bike".matches("I want a bike"));
		
		//challange2 write regex to match "I want a bike." and "I want a ball"
		String ch2 = "I want a bike.";
		String ch21 = "I want a ball.";
		String ch2regexversion1 = "I want a \\w+.";
		String ch2regexversion2 = "I want a (bike|ball).";
		System.out.println(ch2.matches(ch2regexversion1));
		System.out.println(ch21.matches(ch2regexversion1));
		System.out.println(ch2.matches(ch2regexversion2));
		System.out.println(ch21.matches(ch2regexversion2));
		
		//challange3 - replace all white spaces with underscore for "Replace all blanks with underscores"
		String ch = "Replace all blanks with underscores";
		System.out.println(ch.replaceAll(" ", "_"));
		System.out.println(ch.replaceAll("\\s", "_"));
		
		//challange 4 - write regex to match the following string in its entirety "aaabcccccccdddefffg"
		String ch4 = "aaabcccccccdddefffg";
		System.out.println(ch4.matches("[abcdefg]+"));
		System.out.println(ch4.matches("[abcdefg]*"));
		System.out.println(ch4.matches("[a-g]+"));
		System.out.println(ch4.matches("[a-g]*"));
		
		
		System.out.println("##############################################");
		
		//chalange5 - write regex to match a string starts with a series of letters which must be followed by a period, after that there must be a series of digits
		//the string "kjisl.22" should match but "f5.12a" shouldn't
		String ch5regex = "^[a-z][A-z]+\\.\\d+$";
		System.out.println("kjisl.22".matches(ch5regex));
		System.out.println("f5.12a".matches(ch5regex));
		
		
		//challenge 6 - modify the regex from challenge 5 to use a group so that we can print all the digits that occur in a string,
		// that contains multiple occurences of the pattern
		String ch6 = "abcd.135uvqz.7tzik.999";
		String ch6regex = "[A-Za-z]+\\.(\\d+)";
		Pattern patern = Pattern.compile(ch6regex);
		Matcher matcher = patern.matcher(ch6);
		while(matcher.find()) {
			System.out.println("Occurence: " + matcher.group(1));
		}
		
		
		//challenge 7 - suppose we have the following string containing points on a graph: "{0,2},{0,5},{1,3},{2,4}" extract only what's inside the curly braces
		System.out.println("\n####################challenge 7##########################");
		String ch7 = "{0,2},{0,5},{1,3},{2,4}";
		String ch7regex = "\\{(.+?)\\}";
		//if you only want numbers to match: "\\{(\\d+, \\d+)\\}" ->matches one or more digit comma space one or more digit
		Pattern chpattern = Pattern.compile(ch7regex);
		Matcher ch7matcher = chpattern.matcher(ch7);
		while(ch7matcher.find()) {
			System.out.println("Occurence: " + ch7matcher.group(1));
		}
		
		//challange 8 - write a regex to match 5 digit US zip code 
		String ch8 = "11111";
		String ch8regex = "^\\d{5}$";
		System.out.println(ch8.matches(ch8regex));
		
		//challenge 9 = some US code can be followed by a dash and another four numbers. write regex to match 11111-1111
		String ch9 = "11111-1111";
		String ch9regex = "^\\d{5}-\\d{4}$";
		System.out.println(ch9.matches(ch9regex));
		
		//challenge 10 - write regex to match 5 digit US zip code and zip codes that contain the optional 4 digits preceded by a dash
		System.out.println("\n####################challenge 10##########################");
		String ch10 = "11111";
		String ch10_1 = "11111-1111";
		String ch10regex = "^\\d{5}(-\\d{4})?$";
		System.out.println(ch10.matches(ch10regex));
		System.out.println(ch10_1.matches(ch10regex));
		
	}//end of main

}

























