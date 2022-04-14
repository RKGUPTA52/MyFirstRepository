package JavaProgram;

import java.io.*;
import java.util.*;
  
class Geek 
{
      
    String name;
    int id;
      
    Geek(String name, int id)
    {
          
        this.name = name;
        this.id = id;
    }
      
    @Override
    public boolean equals(Object obj)
    {
          
    if(this == obj)
            return true;          

        if(obj == null || obj.getClass()!= this.getClass())
            return false;
          
        // type casting of the argument. 
        Geek geek = (Geek) obj;
          return (geek.name.equals(this.name)  && geek.id == this.id);
    }
      
    @Override
    public int hashCode()
    {         

        return this.id;
    }
      
}
  
// Driver code
class HashCodeEqualsExample 
{
    public static void main (String[] args) 
    {
          
        // creating two Objects with 
        // same state
        Geek g1 = new Geek("aditya", 1);
        Geek g2 = new Geek("aditya", 1);
          
        Map<Geek, String> map = new HashMap<Geek, String>();
        map.put(g1, "CSE");
        map.put(g2, "IT");
          
        for(Geek geek : map.keySet())
        {
            System.out.println(map.get(geek).toString());
        }
  
    }
}