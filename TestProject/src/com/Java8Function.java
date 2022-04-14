package com;

import java.util.function.Function;
/*
 * This functional interface represents a function that accepts one argument and 
 * produces a result. One use, for example, it's to convert or transform from 
 * one object to another. Since it's a functional interface, you can pass a 
 * lambda expression wherever a Function is expected.
 */
public class Java8Function {
	  public static void main(String[] args) {
	    int n = 5;
	    modifyValue(n, val-> val + 10);
	    modifyValue(n, val-> val * 100);
	  }

	  static void modifyValue(int v, Function<Integer, Integer> function){
	    int result = function.apply(v);
	    System.out.println(result);
	  }

	}
