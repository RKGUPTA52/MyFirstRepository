package com;
//https://eherrera.net/ocpj8-notes/04-lambda-built-in-functional-interfaces
/*
 * A predicate is a statement that may be true or false depending on the values 
 * of its variables. It can be thought of as a function that returns a value 
 * that is either true or false.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/*
 * In Java 8, a Predicate is a functional interface that can be used anywhere
 *  you need to evaluate a boolean condition. Since it's a functional interface,
 *   you can pass a lambda expression wherever a Predicate is expected.
 */
public class Java8Predicate {
	  public static void main(String[] args) {
	    List<String> l = new ArrayList<>();
	    l.add("successfully");
	    l.add("easy");
	    l.add("fortune");
	    List<String> filtered = l.stream().filter( s -> s.length() > 5 ).collect(Collectors.<String>toList());
	    System.out.println(filtered);
	  }
	}
