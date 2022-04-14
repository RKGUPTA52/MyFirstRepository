package JavaProgram;
import java.util.Arrays;
import java.util.List;

public class ArrayListExample1 {
 
    // Main driver method
    public static void main(String[] argv) throws Exception
    {
 
        // Try block to check for exceptions
        try {
 
            // Creating Arrays of String type
            String a[]
                = new String[] { "A", "B", "C", "D" };
 
            // Getting the list view of Array
            List<String> list = Arrays.asList(a);
 
            // Printing all the elements in list object
            System.out.println("The list is: " + list);
        }
 
        // Catch block to handle exceptions
        catch (NullPointerException e) {
 
            // Print statement
            System.out.println("Exception thrown : " + e);
        }
    }
}