package unitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
public class CalculatorTest {
   Calculator calcObject;
   @BeforeEach                                         
   void setUp() {
       calcObject = new Calculator();
   }
   @Test                                               
   @DisplayName("Add 2 numbers")   
   void addTest() {
       assertEquals(15, calcObject.add(10, 5));  
   }
   @RepeatedTest(5)                                    
   @DisplayName("Adding a number with zero to return the same number")
   void testAddWithZero() {
       assertEquals(15, calcObject.add(0, 15));
   }
}