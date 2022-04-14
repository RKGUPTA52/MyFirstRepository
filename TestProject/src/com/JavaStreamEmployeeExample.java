package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class JavaStreamEmployeeExample {
	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

		// How many male and female employees are there in the organization?
		Map<String, Long> noOfMaleAndFemaleEmployees = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));


		// Print the name of all departments in the organization?
		employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

		// What is the average age of male and female employees?
		Map<String, Double> avgAgeOfMaleAndFemaleEmployees = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));

		System.out.println(avgAgeOfMaleAndFemaleEmployees);

		// Get the details of highest paid employee in the organization?
		Optional<Employee> highestPaidEmployeeWrapper = employeeList.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
		System.out.println("Details Of Highest Paid Employee : "+highestPaidEmployeeWrapper);
		Optional<Employee> minimumPaidEmployeeWrapper = employeeList.stream()
				.collect(Collectors.minBy(Comparator.comparingDouble(Employee::getSalary)));
		System.out.println("Details Of minimum Paid Employee : "+minimumPaidEmployeeWrapper);
		
		employeeList.stream().filter(emp->emp.getSalary() > 10000).forEach(System.out::println);
		 Double total = employeeList.stream().collect(
				   Collectors.summingDouble(Employee::getSalary));
				  System.out.println("Total Employees Salary : " + total);
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
				  Integer sum = integers.stream()
				    .collect(Collectors.summingInt(Integer::intValue));
				  System.out.println("sum Employees Salary : " + sum);

		Employee highestPaidEmployee = highestPaidEmployeeWrapper.get();
		System.out.println("Details Of Highest Paid Employee : ");
		System.out.println("==================================");
		System.out.println("ID : " + highestPaidEmployee.getId());
		System.out.println("Name : " + highestPaidEmployee.getName());
		System.out.println("Age : " + highestPaidEmployee.getAge());
		System.out.println("Gender : " + highestPaidEmployee.getGender());
		System.out.println("Department : " + highestPaidEmployee.getDepartment());
		System.out.println("Year Of Joining : " + highestPaidEmployee.getYearOfJoining());
		System.out.println("Salary : " + highestPaidEmployee.getSalary());

		// Get the names of all employees who have joined after 2015?
		employeeList.stream().filter(e -> e.getYearOfJoining() > 2015).map(Employee::getName)
				.forEach(System.out::println);
		// Get the names of all employees who have salary greater ths 15000?
		employeeList.stream().filter(e -> e.getYearOfJoining() > 2015).map(Employee::getName)
				.forEach(System.out::println);

		// Count the number of employees in each department?
		Map<String, Long> employeeCountByDepartment = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

		Set<Entry<String, Long>> entrySet = employeeCountByDepartment.entrySet();

		for (Entry<String, Long> entry : entrySet) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

		// What is the average salary of each department?
		Map<String, Double> avgSalaryOfDepartments = employeeList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

		Set<Entry<String, Double>> entrySet2 = avgSalaryOfDepartments.entrySet();

		for (Entry<String, Double> entry : entrySet2) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

		// Get the details of youngest male employee in the product development
		// department?
		Optional<Employee> youngestMaleEmployeeInProductDevelopmentWrapper = employeeList.stream()
				.filter(e -> e.getGender() == "Male" && e.getDepartment() == "Product Development")
				.min(Comparator.comparingInt(Employee::getAge));

		Employee youngestMaleEmployeeInProductDevelopment = youngestMaleEmployeeInProductDevelopmentWrapper.get();

		System.out.println("Details Of Youngest Male Employee In Product Development");
		System.out.println("----------------------------------------------");
		System.out.println("ID : " + youngestMaleEmployeeInProductDevelopment.getId());
		System.out.println("Name : " + youngestMaleEmployeeInProductDevelopment.getName());
		System.out.println("Age : " + youngestMaleEmployeeInProductDevelopment.getAge());
		System.out.println("Year Of Joinging : " + youngestMaleEmployeeInProductDevelopment.getYearOfJoining());
		System.out.println("Salary : " + youngestMaleEmployeeInProductDevelopment.getSalary());

		// Who has the most working experience in the organization?
		Optional<Employee> seniorMostEmployeeWrapper = employeeList.stream()
				.sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();

		Employee seniorMostEmployee = seniorMostEmployeeWrapper.get();

		System.out.println("Senior Most Employee Details :");

		System.out.println("----------------------------");

		System.out.println("ID : " + seniorMostEmployee.getId());

		System.out.println("Name : " + seniorMostEmployee.getName());

		System.out.println("Age : " + seniorMostEmployee.getAge());

		System.out.println("Gender : " + seniorMostEmployee.getGender());

		System.out.println("Age : " + seniorMostEmployee.getDepartment());

		System.out.println("Year Of Joinging : " + seniorMostEmployee.getYearOfJoining());

		System.out.println("Salary : " + seniorMostEmployee.getSalary());

		// How many male and female employees are there in the sales and marketing team?
		Map<String, Long> countMaleFemaleEmployeesInSalesMarketing = employeeList.stream()
				.filter(e -> e.getDepartment() == "Sales And Marketing")
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

		System.out.println(countMaleFemaleEmployeesInSalesMarketing);
        //GroupingBy collector is used for grouping objects by some property and storing results in a Map instance.
		
		Map<Integer, List<Employee>> groupByAge = employeeList.stream().collect(Collectors.groupingBy((Employee e) -> e.getAge()));
		System.out.println("groupByAge :: "+groupByAge);
		
		// What is the average salary of male and female employees?
		Map<String, Double> avgSalaryOfMaleAndFemaleEmployeingreses = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));

		System.out.println(avgSalaryOfMaleAndFemaleEmployeingreses);
		


		// List down the names of all employees in each department?
		Map<String, List<Employee>> employeeListByDepartment = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println("employeeList By Department--------------------------------------"+employeeListByDepartment);
		Set<Entry<String, List<Employee>>> entrySet3 = employeeListByDepartment.entrySet();
		for (Entry<String, List<Employee>> entry : entrySet3) {
			System.out.println("--------------------------------------");
			System.out.println("Employees In " + entry.getKey() + " : ");
			System.out.println("--------------------------------------");

			List<Employee> list = entry.getValue();

			for (Employee e : list) {
				System.out.println(e.getName());
			}
		}

		// What is the average salary and total salary of the whole organization?
		DoubleSummaryStatistics employeeSalaryStatistics = employeeList.stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary));

		System.out.println("Average Salary = " + employeeSalaryStatistics.getAverage());

		System.out.println("Total Salary = " + employeeSalaryStatistics.getSum());
		
        //partitioningBy() method takes Predicate Functional Interface which returns Boolean.
		Map<Boolean, List<Employee>> partitionByAge = employeeList.stream().collect(Collectors.partitioningBy( e -> e.getAge() > 30));
		System.out.println("partitionByAge :: "+partitionByAge);
		
		// Separate the employees who are younger or equal to 25 years from those
		// employees who are older than 25 years.
		Map<Boolean, List<Employee>> partitionEmployeesByAge = employeeList.stream()
				.collect(Collectors.partitioningBy(e -> e.getAge() > 25));

		Set<Entry<Boolean, List<Employee>>> entrySet4 = partitionEmployeesByAge.entrySet();

		for (Entry<Boolean, List<Employee>> entry : entrySet4) {
			System.out.println("----------------------------");

			if (entry.getKey()) {
				System.out.println("Employees older than 25 years :");
			} else {
				System.out.println("Employees younger than or equal to 25 years :");
			}

			System.out.println("----------------------------");

			List<Employee> list = entry.getValue();

			for (Employee e : list) {
				System.out.println(e.getName());
			}
		}

		// Who is the oldest employee in the organization? What is his age and which
		// department he belongs to?
		Optional<Employee> oldestEmployeeWrapper = employeeList.stream().max(Comparator.comparingInt(Employee::getAge));

		Employee oldestEmployee = oldestEmployeeWrapper.get();
		System.out.println("Name : " + oldestEmployee.getName());
		System.out.println("Age : " + oldestEmployee.getAge());
		System.out.println("Department : " + oldestEmployee.getDepartment());
		// 2nd Highest Salary
		Optional<Employee> emp = employeeList.stream()
				.sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst();

		System.out.println("2nd Highest Salary" + emp.get());

		// Top 3 Element salary
		employeeList.stream().sorted(comparing(Employee::getSalary, comparing(Math::abs)).reversed()).limit(3)
				.collect(toList()).forEach(s -> System.out.println("top 3 salary: " + s));
		;



		Map<String, List<Employee>> employeesMap2 = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getName));

		System.out.println(employeesMap2);
//{A=[Employee [id=1, name=A, salary=100.0], Employee [id=2, name=A, salary=200.0]]}

		// employeeList.sort(Comparator.comparing(e -> e.getName())); //1
		// employeeList.sort(Comparator.comparing(Employee::getName)); //2
		employeeList.sort(Comparator.comparing(e -> e.getId()));
		System.out.println("Hi...." + employeeList);

		Comparator<Employee> groupByComparator = Comparator.comparing(Employee::getName)
				.thenComparing(Employee::getAge);
		employeeList.sort(groupByComparator);
		System.out.println("Hi2..." + employeeList);

		// Parallel Sorting
		Employee[] employeesArray = employeeList.toArray(new Employee[employeeList.size()]);
		System.out.println("Hi3...." + employeesArray);
		// Parallel sorting
		Arrays.parallelSort(employeesArray, groupByComparator);
		System.out.println("Hi4...." + employeesArray);

//https://howtodoinjava.com/java8/comparator-example-lambda/
		int numbers[] = { 9, 8, 7, 6, 3, 1 };
		Arrays.stream(numbers).forEach(n -> System.out.print(n + " "));
		System.out.println("before Parallel sorting");
		Arrays.parallelSort(numbers);
		Arrays.stream(numbers).forEach(n -> System.out.print(n + " "));
		// Parallel Sort
		// https://www.concretepage.com/java/jdk-8/java-8-arrays-parallel-sort-example
		// emp have same salary
		Map<Double, Set<String>> map3 = employeeList.stream().collect(
				Collectors.groupingBy(Employee::getSalary, Collectors.mapping(Employee::getName, Collectors.toSet())));
		System.out.println("Hi5..." + map3);
		// return all field
		employeeList.stream().filter(e -> e.getYearOfJoining() > 2015).forEach(System.out::println);
		// return only salary
		List<Double> distinctSalaries = employeeList.stream().map(e -> e.getSalary()).distinct()
				.collect(Collectors.toList());
		System.out.println(distinctSalaries);
		// GetName,GetAge https://codedestine.com/java-8-filter-method/
		List<Employee> tempList = employeeList.stream()
				.filter(e -> "Name".equalsIgnoreCase(e.getName()) && e.getAge() > 30).collect(Collectors.toList());
		tempList.forEach(e -> System.out.println("Name.. :- " + e.getName() + " , Age.. :- " + e.getAge()));

		List<String> names = Arrays.asList("Jon", "Ajeet", "Steve", "Ajeet", "Jon", "Ajeet");
		Map<String, Long> map = names.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("function identity example.." + map);
		// fetching data as List
		List<String> names2 = employeeList.stream().map(n -> n.name).collect(Collectors.toList());
		System.out.println("fetch name as list" + names2);
		// Collecting Data as Set
		Set<Employee> employees = employeeList.stream().filter(n -> n.id > 22).collect(Collectors.toSet());
		// Iterating Set
		for (Employee empy : employees) {
			System.out.println(empy.id + " " + empy.name + " " + empy.age);  }
		
		List<String> namesLinkedList = employeeList.stream().map(e -> e.getName()).collect(Collectors.toCollection(LinkedList::new));
		System.out.println("toCollectiion.."+namesLinkedList);
		
		Collection<Double> regionTreeSet = employeeList.stream().map(e -> e.getSalary()).collect(Collectors.toCollection(TreeSet::new));
		System.out.println("treeSet Example"+regionTreeSet);
		
		Map<Integer, Employee> empMap = employeeList.stream().collect(Collectors.toMap((e) -> e.getId(), Function.identity()));
		System.out.println("toMap Example"+empMap);
		
         //If we want to store the result in Concurrent Map then we should use the toConcurrentMap() method.
		Map<Integer, Employee> empConcurrentMap = employeeList.stream().collect(Collectors.toConcurrentMap((e) -> e.getId(), Function.identity()));
		System.out.println("empConcurrentMap Example"+empConcurrentMap);
		/*DoubleSummaryStatistics -  which holds count, min, max, sum, and the average for all double values in 
		the stream. This helps like a utility method.
       teeing() method  -is used to combine two Collectors output using a special merger function. This method 
		is added in Java 12.*/
		
		/*Set<Double> unmodifiableSet = employeeList.stream().map(e -> e.getSalary())
				.collect(Collectors.toUnmodifiableSet());
				System.out.println(unmodifiableSet);*/
		//Set<Employee> empSet = employeeList.stream().collect(Collectors.toUnmodifiableSet());
		//summingInt example
		int sumOfEmpIds = employeeList.stream().collect(Collectors.summingInt((Employee e) -> e.getId()));
		System.out.println("Collectors.summingInt : " + sumOfEmpIds);
		double sumOfEmpSalss = employeeList.stream().collect(Collectors.summingDouble((Employee e) -> e.getSalary()));
		System.out.println("Collectors.summingDouble : " + sumOfEmpSalss);
		
		// Collectors.maxBy() Example
		Comparator<Employee> empComparator = (e1, e2) -> e1.getId() - e2.getId();
		Optional<Employee> empMaxOptional = employeeList.stream().collect(Collectors.maxBy(empComparator));
		if (empMaxOptional.isPresent()) {
		System.out.println("Max Emp : " + empMaxOptional.get());
		}
		 
		// Collectors.minBy() Example
		Optional<Employee> empminOptional = employeeList.stream().collect(Collectors.minBy(empComparator));
		if (empminOptional.isPresent()) {
		System.out.println("Min Emp : " + empminOptional.get());
		}
		 
		// Collectors.reducing() Example
		Optional<Employee> reducingOptinal = employeeList.stream()
		.collect(Collectors.reducing(BinaryOperator.minBy(empComparator)));
		if (reducingOptinal.isPresent()) {
		System.out.println("Min Emp using reducing() method : " + reducingOptinal.get());
		}
		 
		// Collectors.summarizingDouble() Example
		/*DoubleSummaryStatistics doubleSummaryStatistics = employeeList.stream()
		.collect(Collectors.summarizingDouble((Employee e) -> e.getSal()));
		System.out.println("Statistics summary on employees salary : " + doubleSummaryStatistics);*/
		 
		// Converting 1 to 100 numbers into Stream integer.
		List<Integer> intList = new ArrayList<>();
		IntStream.range(1, 100).forEach(i -> intList.add(i));
		 
		// Calling teeing method.
		/*Double average = intList.stream().collect(
		Collectors.teeing(Collectors.summingDouble(i -> i), Collectors.counting(), (sum, n) -> sum / n));
		 
		System.out.println("Average of first 100 numbers: " + average);*/
		

		 List<String> items =  Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
	     Map<String, Long> result =  items.stream().collect(Collectors.groupingBy(Function.identity(), 
	    		 Collectors.counting()  ) );   System.out.println("result...is"+result);		
				//papaya=1, orange=1, banana=2, apple=3
	    		 Integer sumId =  employeeList.stream().collect(Collectors.summingInt(x->x.id));  
	    	        System.out.println("Sum of id's: "+sumId);  
	    	        Double average = employeeList.stream().collect(Collectors.averagingDouble(p->p.salary));  
	                   System.out.println("Average price is: "+average);  
	                   Long noOfElements = employeeList.stream().collect(Collectors.counting());  
                       System.out.println("Total elements : "+noOfElements);  
                       
                       
                       List<String> namesList = employeeList.stream().map(e -> e.getName()).collect(Collectors.toList());
                       System.out.println("namesList...."+namesList);
                       List<String> namesLinkedList2 = employeeList.stream().map(e -> e.getName()).collect(Collectors.toCollection(LinkedList::new));
                       System.out.println(namesLinkedList2);//TreeSet::new
                       Set<String> deptSet = employeeList.stream().map(e -> e.getDepartment()).collect(Collectors.toSet());
                       System.out.println(deptSet);
                       /*Set<Double> unmodifiableSet = employeeList.stream().map(e -> e.getSalary()).collect(Collectors.toUnmodifiableSet());
                       System.out.println(unmodifiableSet);*/
                       Map<Integer, Employee> empMap2 = employeeList.stream().collect(Collectors.toMap((e) -> e.getId(), Function.identity()));
                       System.out.println(empMap2);
                      /* List<Employee> filteredEmpList = employeeList.stream().collect(Collectors.filtering((Employee e) -> e.getAge() > 30, Collectors.toList()));
                       System.out.println("Collectors.filtering() - filteredEmpList : " + filteredEmpList);*/
                      /* List<String> namesList2 = employeeList.stream().map(e -> e.getName() && e.getAge()==25))).collect(Collectors.toList());
                       System.out.println("namesList2......."+namesList2);*/
                       
                      
         /*List<Employee> tempList2 = employeeList.stream()
         .filter(f -> "Name".equalsIgnoreCase(f.getName()) && f.getAge() > 25).collect(Collectors.toList());                    
         tempList2.forEach(f -> System.out.println("Name of employee :- " + f.getName() + " , Age :- " + f.getAge()));     
         
         
         		// others function.identity
		Map<Integer, Employee> employeesMap = employeeList.stream()
				.collect(Collectors.toMap(Employee::getId, Function.identity()));
		System.out.println("function identity..." + employeesMap);
         *
         */
        //   multiple Fields Map..            
      Map<String, Map<String, Long>> multipleFieldsMap = employeeList.stream().collect(
      Collectors.groupingBy(Employee::getName,Collectors.groupingBy(Employee::getGender,Collectors.counting())));
      System.out.println("multiple Fields Map..." + multipleFieldsMap);          
              		 // count number of Employees in each department
             	      System.out.printf("%nCount of Employees by department:%n"); 
             	      Map<String, Long> employeeCountByDepartment2 =
             	    		  employeeList.stream()
             	             .collect(Collectors.groupingBy(Employee::getDepartment, 
             	                TreeMap::new, Collectors.counting()));
             	      employeeCountByDepartment2.forEach(
             	         (department, count) -> System.out.printf(
             	            "%s has %d employee(s)%n...hiiiii", department, count));
                      
           List<Employee> greaterThan25 = employeeList.stream().filter(e -> e.age > 25).collect(Collectors.toList());
           System.out.println("greaterThan25..."+greaterThan25);   
           
           employeeList.stream().filter( e-> e.getAge() <25).forEach(e1->
           System.out.println("...usa..."+e1.getName()+" "+e1.getAge()+" "+e1.getSalary()));
           

   		// others function.identity
   		Map<Integer, Employee> employeesMap = employeeList.stream()
   				.collect(Collectors.toMap(Employee::getId, Function.identity()));
   		System.out.println("function identity..." + employeesMap);
   		// {1=Employee [id=1, name=A, salary=100.0]}
   		
           employeeList.stream().filter(e -> e.age>25).map(Employee::getName).forEach(System.out::println);
           
           Map<Integer, String> idToNames = employeeList.stream().filter(e->e.getAge()>38)
        	        .collect(Collectors.toMap(Employee::getId, Employee::getName));
        	System.out.println("idToNames..."+idToNames);   
        	
        	//multiple grouping
        	Map<String, Map<String, Long>> multipleFieldsMap2 = employeeList.stream()
    		.collect(Collectors.groupingBy(Employee::getDepartment,Collectors.groupingBy(Employee::getGender, 
    										Collectors.counting())));
        	 System.out.println(" multipleFieldsMap2"+multipleFieldsMap2);
        	 
        	 //flatmap example : flatmap processes the stream of stream's values. map processes the stream of values.
        	 String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
        	  List<String> collect = Stream.of(array)     // Stream<String[]>
        	          .flatMap(Stream::of)                // Stream<String>
        	          .filter(x -> !"a".equals(x))        // filter out the a
        	          .collect(Collectors.toList());      // return a List
        	  collect.forEach(System.out::println);
        	  
        	  List<Integer> list1 = Arrays.asList(1,2,3);
              List<Integer> list2 = Arrays.asList(4,5,6);
              List<Integer> list3 = Arrays.asList(7,8,9);                  
                List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);                 
                List<Integer> listOfAllIntegers = listOfLists.stream()
                          .flatMap(x -> x.stream())
                          .collect(Collectors.toList());          
                System.out.println(listOfAllIntegers);

	}
}
//https://www.javaprogramto.com/2021/02/java-8-streams-group-by-multiple-fields.html  multiple groupingBy

//https://www.javaprogramto.com/2020/08/java-8-collectors-examples.html  Collectors example
//https://www.javacodegeeks.com/2020/09/java-8-collectors-api-tutorial-with-real-time-examples.html
//https://github.com/RameshMF/java-8-tutorial  github
/*
 * collect()
toList()
toSet()
toUnmodifiableSet()
toUnmodifiableList(()
toCollection()
toMap()
toUnmodifiableMap()
summingInt()
averagingInt() / averagingLong() / averagingDouble()s
counting()
joining()
groupingBy()
partitioningBy()
toConcurrentMap()
filtering()
flatMapping()
maxBy()
minBy()
reducing()
summarizingDouble() / summarizingInt() / summarizingLong()
teeing()
 */
