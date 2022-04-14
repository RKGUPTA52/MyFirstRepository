package com;

import java.util.Arrays;
import java.util.List;

interface Addable{  
    int add(int a,int b);  
}  
  
public class LambdaExpressionExample5{  
    public static void main(String[] args) {  
          
        // Multiple parameters in lambda expression  
        Addable ad1=(a,b)->(a+b);  
        System.out.println(ad1.add(10,20));  
          
        // Multiple parameters with data type in lambda expression  
        Addable ad2=(int a,int b)->(a+b);  
        System.out.println(ad2.add(100,200));
        
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.forEach((n)->System.out.println(n));  
        
    }  
}
