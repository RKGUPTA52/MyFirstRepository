package JavaProgram;
/*
 * In Java, there is three-way to generate random numbers using the method 
 * and classes.


Using the random() Method
Using the Random Class
Using the ThreadLocalRandom Class
Using the ints() Method (in Java 8)
 */
import java.lang.Math;   
public class RandomNumberExample1  
{   
public static void main(String args[])   
{   
// Generating random numbers  
System.out.println("1st Random Number: " + Math.random());   
System.out.println("2nd Random Number: " + Math.random());  
System.out.println("3rd Random Number: " + Math.random());   
System.out.println("4th Random Number: " + Math.random());   
}   
}  