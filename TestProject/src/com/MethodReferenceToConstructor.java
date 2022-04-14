package com;

@FunctionalInterface 
interface MyInterfaceExample2{  
    Hello display(String say);  
}  
class Hello{  
    public Hello(String say){  
        System.out.print(say);  
    }  
}  
public class MethodReferenceToConstructor {  
    public static void main(String[] args) { 
    	//Method reference to a constructor
    	MyInterfaceExample2 ref = Hello::new;  
        ref.display("Hello World!");  
    }  
}
