import java.util.*;
import java.util.stream.Collectors;


public class StreamPracticeStringOperation {

	public static void main(String[] args) {
	
		// Convert a list of strings to uppercase
		
		List<String> words = Arrays.asList(
			    "hello", "world", "java", "streams");
		
		List<String> upperCase = words.stream()
				.map(String::toUpperCase)
				.collect(Collectors.toList());
		
		System.out.println("Uppercase Letters "+upperCase);
		
		// Concatenate a list of strings with a delimiter
		
		String result = words.stream()
				.collect(Collectors.joining(", ")); // delimeter
		
		System.out.println("List of Strings with a delimeter: "+ result);
		
		// Reverse Each word in a string
		
		String originalSentence = "Hello World Java Streams";
		
		String reversedSentence = Arrays.stream(originalSentence.split(" "))
			    .map(word ->new StringBuilder(word).reverse().toString())
			    .collect(Collectors.joining(" "));
		
		System.out.println("Original Sentence: "+ originalSentence);
		
		System.out.println("Reversed Sentence: " +reversedSentence);
		
		
		// Find the sum of digits of a number
		
		int number = 123456;
		
		int digitSum = String.valueOf(number)
				.chars()
				.map(c->c-'0')
				.sum();
		
		System.out.println("Sum of digits: " + digitSum);
		
		// Check if two Strings are Anagrams
		String s1 = "listen";
		String s2 = "silent";
		
		boolean isAnagram = Arrays.equals(
			    s1.chars().sorted().toArray(),
			    s2.chars().sorted().toArray()
			);
		
		System.out.println("Two Strings: "+ s1 + " & " + s2 + " → anagram: " + isAnagram);
		
		// Find Palindrome Strings in a List
		
		List<String> palindromeWords = Arrays.asList("racecar", "hello", "level", "world", "madam");
		
		List<String> palindromeStrings = palindromeWords.stream()
				.filter(w->w.equals(
						new StringBuilder(w).reverse().toString()))
				.collect(Collectors.toList());
		
		System.out.println("Pallindrome Strings are: "+palindromeStrings);
		
		
		// Join Strings with Prefix, Suffix, and delimiter
		
		List<String> joinStrings = Arrays.asList("Java", "Python", "Go", "Rust");
		
		String joiningResult = joinStrings.stream()
				.collect(Collectors.joining(
						", ",  //delimiter
						"[",   //Prefix
						"]"   //Suffix
						));
		
		System.out.println("Joining the Strings with Delimeter, Prefix, Suffix:"+joiningResult);
		
		

	}

}
