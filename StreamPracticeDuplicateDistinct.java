import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.*;

public class StreamPracticeDuplicateDistinct {

	public static void main(String[] args) {
		
		// Find Duplicate Elements with the count
		
		List<String> words = Arrays.asList("apple", "banana", "apple", "cherry",
			    "banana", "apple", "date");
		
		Map<String,Long> duplicates = words.stream()
				.collect(Collectors.groupingBy(
						Function.identity(),
						Collectors.counting()
						))
				.entrySet().stream()
				.filter(e->e.getValue()>1)
				.collect(Collectors.toMap(
						Map.Entry::getKey,
						Map.Entry::getValue
						));
		
		System.out.println("Duplicate Strings in the list are "+duplicates);
		
		// Remove Duplicates Elements from the list
		
		List<Integer> numbers = Arrays.asList(5,3,8,1,3,2,7,5,6,2);
		
		List<Integer> unique = numbers.stream()
				.distinct()
				.collect(Collectors.toList());
		
		System.out.println("Original : " + numbers);
		System.out.println("No dupes : " + unique);
		
		// Find Squares of all Distinct Elements
		
		List<Integer> squares = numbers.stream()
				.distinct()
				.map(n->n*n)
				.collect(Collectors.toList());
		
		System.out.println("Input   : " + numbers);
		System.out.println("Squares : " + squares);
		
		
				
		
		
		
		
		

	}

}
