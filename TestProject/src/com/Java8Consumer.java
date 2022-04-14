package com;

import java.util.function.Consumer;
/*
 * This functional interface represents an operation that accepts a single
 *  input argument and returns no result.
 */
class Product2 {
	  private double price = 0.0;

	  public void setPrice(double price) {
	    this.price = price;
	  }

	  public void printPrice() {
	    System.out.println(price);
	  }
	}

	public class Java8Consumer {
	  public static void main(String[] args) {
	    Consumer<Product2> updatePrice = p -> p.setPrice(5.9);
	    Product2 p = new Product2();
	    updatePrice.accept(p);
	    p.printPrice();
	  }
	}
