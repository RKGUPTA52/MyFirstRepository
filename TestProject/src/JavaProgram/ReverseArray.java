package JavaProgram;

public class ReverseArray {  
    public static void main(String[] args) {  
        //Initialize array  
        int [] arr = new int [] {1, 2, 3, 4, 5}; 
        // char[] letters = {'e', 'v', 'o', 'l', '4'};  //reverse character
        //String letters = "neelendra";
        //String string = "Dream big"; 
        // String reversedStr = "";   
        System.out.println("Original array: ");  
        for (int i = 0; i < arr.length; i++) {  
            System.out.print(arr[i] + " ");  
        }  
        System.out.println();  
        System.out.println("Array in reverse order: ");  
        //Loop through the array in reverse order  
        for (int i = arr.length-1; i >= 0; i--) {  
            System.out.print(arr[i] + " ");  
        }  
        /*for (int i = letters.length-1; i >= 0 ; i--) { //reverse character
            System.out.print(letters[i]);}*/
        /*
         * for(int i = string.length()-1; i >= 0; i--){    
            reversedStr = reversedStr + string.charAt(i);   //reverse string 
        } 
         */
    }  
}