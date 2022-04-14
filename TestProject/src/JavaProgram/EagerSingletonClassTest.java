package JavaProgram;

import static org.junit.Assert.*;

import org.junit.Test;
 
public class EagerSingletonClassTest {
 
    @Test
    public void testSingleton() {
         
        EagerSingletonClass instance1 = EagerSingletonClass.getInstance();
        EagerSingletonClass instance2 = EagerSingletonClass.getInstance();
        System.out.println("checking singleton objects equality");
        assertEquals(true, instance1==instance2);
         
    }
 
}
