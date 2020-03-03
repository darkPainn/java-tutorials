package com.sedat.regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author sedat.turkoglu
 *
 * quantifiers specify how often an element in a regular expression can occur
 */
public class QuantifiersAndPatternAndMatcherClasses {

	public static void main(String[] args) {
		String alphanumeric = "abcADeeef124567Ghhiiiijkl99zabcDeee!*-hij";
		
		//abcADe{3} means 3 of e in order for it to match
		System.out.println(alphanumeric.replaceAll("^abcADe{2}", "X"));
		
		//string begins with abcAD followed by 1 or more e
		System.out.println(alphanumeric.replaceAll("^abcADe+", "X"));
		
		//string begins with abcAD followed by 0 or more e
		System.out.println(alphanumeric.replaceAll("^abcADe*", "X"));
		
		//string begins with abcAD followed by 2-5 e
		System.out.println(alphanumeric.replaceAll("^abcADe{4,5}", "X"));
		
		//string beginning with 1 h followed by 0 or more i followed by j
		System.out.println(alphanumeric.replaceAll("h+i*j", "X"));
		
		//to find all occurrences of h2 tag in a char sequence of html text
		StringBuilder htmltext = new StringBuilder("<h1>Heading</h1>");
		htmltext.append("<h2>Sub-Heading</h2>");
		htmltext.append("<p>This is paragraph1</p>");
		htmltext.append("<p>This is paragraph2</p>");
		htmltext.append("<h2>Summary</h2>");
		htmltext.append("<p>Here is the summary</p>");
		htmltext.append("<h2></h2>");
		
		//.*yourstring.* means there can be anything before and after yourstring, you can also group your pattern: (pattern) so that you can work with groups
		String h2Pattern = "<h2>";
		//adding Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE makes sure it is case insentive and also searching fro unicodes as well
		Pattern pattern = Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
		
		//a matcher can only be used once!! It has an internal state and updates itself when its used.
		Matcher matcher = pattern.matcher(htmltext);
		System.out.println(matcher.matches());
		
		//call this method on matcher to be able to use it again
		matcher.reset();
		
		//to find the number of occurences of a patern
		int count = 0;
		while(matcher.find()) {
			count++;
			System.out.println("Occurrence: " + count + " : " + matcher.start() + " to " + matcher.end());
		}
		
		//to get opening, closing and anything between h2
		String h2All = "(<h2>.*?</h2>)";
		Pattern group = Pattern.compile(h2All);
		Matcher groupMatch = group.matcher(htmltext);
		System.out.println(groupMatch.matches());
		
		groupMatch.reset();
		while(groupMatch.find()) {
			System.out.println("Occurence: " + groupMatch.group(1));
		}
		
		//to get only the text between opening and closing of h2. .+? instead of .*? means don't match empty string
		String h2text = "(<h2>)(.+?)(</h2>)";
		Pattern h2group = Pattern.compile(h2text);
		Matcher h2textmatch = h2group.matcher(htmltext);
		while(h2textmatch.find()) {
			System.out.println("Occurence: " + h2textmatch.group(2));
		}
	}

}











































