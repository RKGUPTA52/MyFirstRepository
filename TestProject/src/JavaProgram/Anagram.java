package JavaProgram;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;  
public class Anagram {  
	/*
	 * Two Strings are called the anagram if they contain the same characters.
	 *  However, the order or sequence of  * the characters can be different.
	 */
	
	public static String sortChars(String input) {
	    char[] characters = input.toCharArray();
	    Arrays.sort(characters);
	    return new String(characters);
	}
    public static void main (String [] args) {  

    	List<String> words2 = Arrays.asList("pool", "loop", "stream", "arc",
    	        "odor", "car", "rood", "meats", "fires", "fries",
    	        "night", "thing", "mates", "teams");
    	Map<String, List<String>> anagrams =
    		    words2.stream().collect(Collectors.groupingBy(w -> sortChars(w)));
    	 System.out.println(" anagram"+anagrams);
   
    	
        String str1="Brag";  
        String str2="Grab";  
  
        //Converting both the string to lower case.  
        str1 = str1.toLowerCase();  
        str2 = str2.toLowerCase();  
  
        //Checking for the length of strings  
        if (str1.length() != str2.length()) {  
            System.out.println("Both the strings are not anagram");  
        }  
        else {  
            //Converting both the arrays to character array  
            char[] string1 = str1.toCharArray();  
            char[] string2 = str2.toCharArray();  
  
            //Sorting the arrays using in-built function sort ()  
            Arrays.sort(string1);  
            Arrays.sort(string2);  
  
            //Comparing both the arrays using in-built function equals ()  
            if(Arrays.equals(string1, string2) == true) {  
                System.out.println("Both the strings are anagram");  
            }  
            else {  
                System.out.println("Both the strings are not anagram");  
            }  
        } 
        
    }  
}   