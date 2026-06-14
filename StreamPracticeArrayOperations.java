import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Function;

public class StreamPracticeArrayOperations {

	public static void main(String[] args) {
		
		// Find the Second Smallest Element
		
		int[] arr = {5, 3, 8, 1, 9, 2, 7, 1, 4, 6};
		
		int secondSmallest = Arrays.stream(arr)
				.distinct()
				.sorted()
				.skip(1)
				.findFirst()
				.getAsInt();
		
		System.out.println("Second smallest: " + secondSmallest);
		
		// Find the Second Largest Element
		
		int secondLargest = Arrays.stream(arr)
				.distinct()
				.boxed()
				.sorted(Comparator.reverseOrder())
				.skip(1)
				.findFirst()
				.get();
		
		System.out.println("Second Largest Element in an Array: " + secondLargest);
		
		//Find Common Elements between two arrays
		
		int[] arr1 = {1, 2, 3, 4, 5, 6};
		int[] arr2 = {4, 5, 6, 7, 8, 9};
		
		Set<Integer> set2 = Arrays.stream(arr2)
				.boxed()
				.collect(Collectors.toSet());
		
		List<Integer> commonNumbers = Arrays.stream(arr1)
				.boxed()
				.filter(set2::contains)
				.distinct()
				.collect(Collectors.toList());
		
		System.out.println("Common Number between two arrays: " + commonNumbers);
		
		// Find the most frequent element
		
		int[] frequentArray = {1, 3, 2, 3, 4, 3, 5, 1, 1, 1};
		
		int mostFrequent = Arrays.stream(frequentArray)
			    .boxed()
			    .collect(Collectors.groupingBy(
			        Function.identity(),   // group by value
			        Collectors.counting()  // count each group
			    ))
			    .entrySet().stream()
			    .max(Map.Entry.comparingByValue())
			    .get()
			    .getKey();
		
		System.out.println("Most frequent Element: " + mostFrequent);
		
			    
		
		

		

	}

}
