package JavaProgram;

import java.util.Arrays;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] argv) throws Exception
    {
        // Try block to check for exceptions
        try {
 
            // Creating Arrays of Integer type
            Integer a[] = new Integer[] { 10, 20, 30, 40 };
 
            // Getting the list view of Array
            List<Integer> list = Arrays.asList(a);
            
 
            // Adding another int to the list
            // As Arrays.asList() returns fixed size
            // list, we'll get
            // java.lang.UnsupportedOperationException
            list.add(50);
 
            // Printing all the elements of list
            System.out.println("The list is: " + list);
        }
 
        // Catch block to handle exceptions
        catch (UnsupportedOperationException e) {
 
            // Display message when exception occurs
            System.out.println("Exception thrown : " + e);
        }
    }

}
