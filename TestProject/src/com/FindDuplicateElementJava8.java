package com;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindDuplicateElementJava8 {

	public FindDuplicateElementJava8() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(new Integer[]{1,2,1,3,4,4});
		numbers.stream().filter(i -> Collections.frequency(numbers, i) >1)
        .collect(Collectors.toSet()).forEach(System.out::println);
		
		List<Integer> duplicates = IntStream.of( 1, 2, 3, 2, 1, 2, 3, 4, 2, 2, 2 )
				   .boxed()
				   .collect( Collectors.groupingBy( Function.identity(), Collectors.counting() ) )
				   .entrySet()
				   .stream()
				   .filter( p -> p.getValue() > 1 )
				   .map( Map.Entry::getKey )
				   .collect( Collectors.toList() );
		           System.out.println(duplicates);
	         
	}

}
