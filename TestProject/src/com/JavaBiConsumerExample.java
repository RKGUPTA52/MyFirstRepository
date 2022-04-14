package com;
/*
 * BiConsumer is a functional interface; it takes two arguments and returns nothing.
 */
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class JavaBiConsumerExample {

    public static void main(String[] args) {

      BiConsumer<Integer, Integer> addTwo = (x, y) -> System.out.println(x + y);
      addTwo.accept(1, 2);    // 3

    }

}