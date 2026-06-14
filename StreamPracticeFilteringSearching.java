import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamPracticeFilteringSearching {

	public static void main(String[] args) {
		
		 List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 9, 2, 7, 4, 6, 2);
		 
		 // 1. Return true if any value appears at least twice
		 
		 Boolean hasDuplicate = numbers.stream()
				 .collect(Collectors.groupingBy(
						 Function.identity(),
						 Collectors.counting()))
				 .values().stream()
				 .anyMatch(count->count>=2);
		 System.out.println("Value appears twice "+hasDuplicate);
		 
		 // 2. Separate Odd and Even Numbers
		 
		 Map<Boolean, List<Integer>> partitioned = numbers.stream()
				 .collect(Collectors.partitioningBy(n->n%2==0));
		 
		 List<Integer> evens = partitioned.get(true);
		 List<Integer> odd = partitioned.get(false);
		 
		 System.out.println("Even number values "+evens);
		 System.out.println("Odd number values "+odd);
		 
		 // 3.  Find Strings that start with a specific character
		 
		 List<String> words = Arrays.asList("apple","avocado","banana","apricot","cherry");
		 char target = 'a';
		 
		 List<String> result = words.stream()
				 .filter(s->s.startsWith(String.valueOf(target)))
				 .collect(Collectors.toList());
		 
		 System.out.println("Words starting with target character "+result);
		 
		 // 4. Check if all elements greater than a value
		 
		 List<Integer> nums = Arrays.asList(10, 15, 20, 25, 30);
		 
		 int value = 5;
		 
		 boolean allGreater = nums.stream()
				 .allMatch(n->n > value);
		 
		 System.out.println("Numbers greater than the value "+allGreater);
		 
		 
		 // 5. Check if any element is less than a value.
		 
		 int element = 12;
		 
		 boolean lessValue = nums.stream()
				    .anyMatch(n -> n < element);
		 
		 System.out.println("Number less than the value "+lessValue);
		 
		 //6. Find Strings with length greater than 3
		 
		 List<String> stringList = Arrays.asList(
				    "hi", "cat", "java", "stream", "go");
		 
		 List<String> stringGreaterThan3 = stringList.stream()
				 .filter(s->s.length()>3)
				 .collect(Collectors.toList());
		 
		 System.out.println("Strings with length greater than 3 "+stringGreaterThan3);
		 
		 
		 
		 
		 

	}

}
