import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamPracticeBasicOperations {

	public static void main(String[] args) {
		
		
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 9, 2, 7, 4, 6);
        
        // 1. Find the total number of elements in a list
        
        long count = numbers.stream()
        		.count();
        System.out.println("Total elements in the list: " + count);
        
        // 2. Sort all values in descending order
        
        List<Integer> sorted = numbers.stream()
        		.sorted(Comparator.reverseOrder())
        		.collect(Collectors.toList());
        System.out.println("Descending order in the list: " + sorted);
        
        // 3. Find the first element of a list
        
        Optional<Integer> first = numbers.stream()
        		.findFirst();
        System.out.println("First element: " + first.get());
        
        // 4. Find the last element of a list
        
        Optional<Integer> last = numbers.stream()
        		.reduce((a,b)->b);
        System.out.println("Last element: " + last.get());
        
        // 5. Find the sum of all elements in a list
        
        int sum = numbers.stream()
        		.mapToInt(Integer::intValue)
        		.sum();
        System.out.println("Sum: " + sum);
        
        // 6. Find the average of all elements in a list
        
        OptionalDouble average = numbers.stream()
        		.mapToInt(Integer::intValue)
        		.average();
        System.out.println("average: " + average);
        
        // 7. Find the sum of first 10 natural numbers
        
        int sumFirst10 = IntStream.rangeClosed(1, 10)
        		.sum();
        System.out.println("Sum of first 10 natural numbers: " + sumFirst10);
        
        // 8. Find the maximum and minimum in a stream
        
        Optional<Integer> max = numbers.stream()
        		.max(Comparator.naturalOrder());
        
        Optional<Integer> min = numbers.stream()
        		.min(Comparator.naturalOrder());
        
        System.out.println("Maximum: " + max.get());
        System.out.println("Minimum: " + min.get());
        
        
        

		

	}

}
