package JavaProgram;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream; 

public class DuplicateElementJava8 {  
public static void main(String[] args) {  
        //Initialize array  
	 //ArrayList<String> list = new ArrayList<>(Arrays.asList("cat", "cow", "dog"));
	 //ArrayList<String> list = Arrays.asList(10,20,28,20,29,28);
	Integer arr[]= new Integer[] { 12, 34, 22, 87, 98,12,34,25,16 };
	List<Integer> list = Arrays.asList(arr);
	Set<Integer> set = new HashSet<>();
	String str = " hello Hi how are you You Hi";
	List<String> list2 = Arrays.asList(str.split(" "));
	//list.stream().filter(x->set.add(x)).forEach(x-> System.out.println(x));//get unique element
	//list.stream().filter(x->!set.add(x)).collect(Collectors.toSet()).forEach(x-> System.out.println(x));//get duplicate element
	//list.stream().limit(2).forEach(y-> System.out.println(y));
	//list.stream().skip(2).forEach(y-> System.out.println(y));
	Map<String,Long> map= list2.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	System.out.println(map);
	Function<String,String> fn = Function.identity();
	System.out.println(fn.apply("Hi"));

	Stream s = list.stream().filter(i-> i==34);
	s.forEach(x->System.out.println(x));
	Stream s2 = list.stream().map(i-> i*i);
	s2.forEach(x->System.out.println(x));
	
	String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

	  List<String> collect = Stream.of(array)     // Stream<String[]>
	          .flatMap(Stream::of)                // Stream<String>
	          .filter(x -> !"a".equals(x))        // filter out the a
	          .collect(Collectors.toList());      // return a List

	  collect.forEach(System.out::println);
	  
	  int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};//sum of numbers
	  // 1st argument, init value = 0
	  int sum = Arrays.stream(numbers).reduce(0, (a, b) -> a + b);
	  System.out.println("sum : " + sum); // 55
	  String result = Stream.of("java", "c", "c#", "python").reduce("Languages:", (x,y)->x+" | "+y);
      System.out.println(result);
      Integer arrSum = Stream.of(10,20,22,12,14).reduce(1000, Integer::sum);
      System.out.println(arrSum);
      
      Stream.of("bus", "car", "bycle", "flight", "train")
      .filter(e -> e.length() > 3)
      .peek(e -> System.out.println("Filtered value: " + e))
      .map(String::toUpperCase)
      .peek(e -> System.out.println("Mapped value: " + e))
      .collect(Collectors.toList());
      //peek() method returns a new Stream consisting of all the elements from the original Stream after applying a given Consumer action
      List<Integer> numList = Arrays.asList(1,3,4,5,2,7,9);
      List<Integer> filterList = numList.stream().filter(e -> e >= 5)
                                   .peek(e -> System.out.println("Filtered value: " + e))
                                   .filter(e -> e < 9)
                                   .collect(Collectors.toList());//use for debug
      System.out.println(filterList);
      

      
      Integer arrSum2 = Stream.of(10,20,22,12,14).parallel().reduce(1000, (x,y)->x+y, (p,q)->{
          System.out.println("combiner called");
          return p+q;
      });
      System.out.println(arrSum2);
      
      //String str2 = null;
      String str2 = "How are you";
      Optional<String> optional = Optional.ofNullable(str2); 
      System.out.print(optional.isPresent());  
      //System.out.print(optional.get());  
      System.out.print(optional.orElse("novalue present"));
      //String[] name = {"a","b","c","d","e","f"};
      String[] name = {"a","b","c","d",null,"f"};
      Optional<String> opt = Optional.ofNullable(name[4]); 
      //opt.ifPresent(k ->System.out.println("........"+k));
      System.out.print(opt.orElse("default"));
      
      
    }   
}  