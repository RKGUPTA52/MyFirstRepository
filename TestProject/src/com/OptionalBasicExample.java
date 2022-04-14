package com;

import java.util.Optional;

public class OptionalBasicExample {

    public static void main(String[] args) {

        Optional<String> gender = Optional.of("MALE");
        String answer1 = "Yes";
        String answer2 = null;

        System.out.println("Non-Empty Optional:" + gender);
        System.out.println("Non-Empty Optional: Gender value : " + gender.get());
        System.out.println("Empty Optional: " + Optional.empty());

        System.out.println("ofNullable on Non-Empty Optional: " + Optional.ofNullable(answer1));
        System.out.println("ofNullable on Empty Optional: " + Optional.ofNullable(answer2));
        
        // java.lang.NullPointerException
        System.out.println("ofNullable on Non-Empty Optional: " + Optional.of(answer2));
       
        
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