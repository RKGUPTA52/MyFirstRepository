package com;

import java.util.function.Supplier;
/*
 * This functional interface does the opposite of the Consumer, it takes no
 *  arguments but it returns some value
 */
public class Java8Supplier {
    public static void main(String[] args) {
        int n = 3;
        display(() -> n + 10);
        display(() -> n + 100);
    }

    static void display(Supplier<Integer> arg) {
        System.out.println(arg.get());
    }
}