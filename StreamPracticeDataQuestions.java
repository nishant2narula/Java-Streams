import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class StreamPracticeDataQuestions {

	public static void main(String[] args) {
		
		List<Employee> employees = Arrays.asList(
			    new Employee(1,  "Alice Johnson",  "Engineering", 95000, LocalDate.of(1990,  3, 15)),
			    new Employee(2,  "Bob Smith",      "Engineering", 87000, LocalDate.of(1985,  7, 22)),
			    new Employee(3,  "Carol White",    "Engineering", 45000, LocalDate.of(1995, 11,  8)),
			    new Employee(4,  "David Brown",    "Marketing",   62000, LocalDate.of(1988,  1, 30)),
			    new Employee(5,  "Eva Martinez",   "Marketing",   58000, LocalDate.of(1992,  6, 14)),
			    new Employee(6,  "Frank Lee",      "Marketing",   48000, LocalDate.of(1997,  9,  3)),
			    new Employee(7,  "Grace Kim",      "HR",          55000, LocalDate.of(1991,  4, 27)),
			    new Employee(8,  "Henry Wilson",   "HR",          42000, LocalDate.of(1993, 12, 19)),
			    new Employee(9,  "Isla Davis",     "Finance",     78000, LocalDate.of(1987,  8, 11)),
			    new Employee(10, "Jack Thompson",  "Finance",     82000, LocalDate.of(1984,  2, 25)),
			    new Employee(11, "Karen Moore",    "Finance",     91000, LocalDate.of(1982,  5, 16)),
			    new Employee(12, "Liam Anderson",  "Engineering", 73000, LocalDate.of(1994, 10,  7))
			);
		
		// Grouping Elements by Department
		
		Map<String,List<Employee>> groupByDept = employees.stream()
				.collect(Collectors.groupingBy(
						Employee::getDepartment
						));
		
		System.out.println("Group Elements by Department: ");
		
		groupByDept.forEach((dept,emps)->{
			System.out.println(dept + ":");
			 emps.forEach(e -> System.out.println("  " + e.getName()));
		});
		
		// Count Employees in Each Department
		
		Map<String,Long> countByDept = employees.stream()
				.collect(Collectors.groupingBy(
						Employee::getDepartment,
						 Collectors.counting()
						));
		
		System.out.println("-------------------------------------------------");
		System.out.println("Count Employees in Each Department: ");
		countByDept.forEach((dept, count) ->
	    System.out.println(dept + " → " + count + " employees"));
		
		// Find Average Salary of each department
		
		 Map<String, Double> avgSalary = employees.stream()
				 .collect(Collectors.groupingBy(
						 Employee::getDepartment,
						 Collectors.averagingDouble(Employee::getSalary)
						 ));
		 
		 System.out.println("-------------------------------------------------");
		 System.out.println("Find Average Salary of each department: ");
		 avgSalary.forEach((dept, avg) ->
		    System.out.printf("%s → $%.2f%n", dept, avg));
		 
		 
		 // Find the highest paid employee in each department
		 
		 Map<String,Optional<Employee>> highestPaid = employees.stream()
				 .collect(Collectors.groupingBy(
						 Employee::getDepartment,
						 Collectors.maxBy(
						            Comparator.comparingDouble(Employee::getSalary)
						        )
						 ));
		 
		 System.out.println("-------------------------------------------------");
		 System.out.println("Highest paid employee in each department: ");
		 
		 highestPaid.forEach((dept, emp) ->
		    System.out.println(dept + " → "
		        + emp.get().getName()
		        + " ($" + emp.get().getSalary() + ")"));
		 
		 // Employee Names sorted Alphabetically, Salary>50,000
		 
		 List<String> employeesAlphabetically = employees.stream()
				    .filter(e -> e.getSalary() > 50000)      // salary condition
				    .sorted(Comparator.comparing(
				        Employee::getName))                  // alphabetical order
				    .map(Employee::getName)                  // extract name only
				    .collect(Collectors.toList());
		 
		 System.out.println("-------------------------------------------------");
		 System.out.println("Employee Names sorted Alphabetically, Salary>50,000: ");
		 employeesAlphabetically.forEach(System.out::println);
		 
		 // Calculate age from date of birth 

		 Map<String,Long> ages = employees.stream()
				 .collect(Collectors.toMap(
				 Employee::getName,
			        e -> ChronoUnit.YEARS.between(
			            e.getDateOfBirth(),
			            LocalDate.now()          // today's date
			        )
			    ));
		 
		 System.out.println("-------------------------------------------------");
		 System.out.println("Calculate age from date of birth: ");
		 
		 ages.forEach((name, age) ->
		    System.out.println(name + " → " + age + " years old"));
		 
		 // Find the top 3 highest paid employees across all departments.
		 
		 List<Employee> top3 = employees.stream()
				    .sorted(Comparator.comparingDouble(Employee::getSalary)
				                      .reversed())      // highest salary first
				    .limit(3)                            // take only the first 3
				    .collect(Collectors.toList());
		 
		 System.out.println("-------------------------------------------------");
		 System.out.println("Top 3 highest paid employees across all departments: ");
		 top3.forEach(e ->
		    System.out.printf("%-20s %-15s $%.0f%n",
		        e.getName(), e.getDepartment(), e.getSalary()));
			    
			    
		 
				 
		

	}

}
