package JavaProgram;

public class SwapTwoNumbersExample3  
{  
public static void main(String args[])  
{  
int x = 10;  
int y = 20;  
System.out.println("values before swapping:");   
System.out.println("x = " + x +" y = " + y);  
//swapping two numbers using multiplication and division  
x = x*y; //now x is 200   
y = x/y; //now x is 200 and y is 20, on dividing x/y is y=10 (original value of x)  
x = x/y; //now x is 200 and y is 10, on dividing x/y is x=20 (original value of y)  
System.out.println("values after swapping:");  
System.out.println("x = " + x +" y = " + y);  
}  
}  
/*
 * values before swapping:
x = 10 y = 20
values after swapping:
x = 20 y = 10
 */
