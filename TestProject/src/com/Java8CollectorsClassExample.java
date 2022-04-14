package com;
//count.avg,min,max,tolist,toSet...
import java.util.stream.Collectors;  
import java.util.List;  
import java.util.ArrayList;  
class Student{  
   public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
int id;     
   String name;    
   int age;         
   public Student(int id, String name, int age) {  
        this.id = id;    
        this.name = name;         
        this.age = age;     
   } 
}  
public class Java8CollectorsClassExample {  
   public static void main(String[] args) {    
      List<Student> studentlist = new ArrayList<Student>();   
      //Adding Students      
      studentlist.add(new Student(11,"Jon",22));      
      studentlist.add(new Student(22,"Steve",18));        
      studentlist.add(new Student(33,"Lucy",22));        
      studentlist.add(new Student(44,"Sansa",23));         
      studentlist.add(new Student(55,"Maggie",18));                  
      //Fetching student names as List       
      List<String> names = studentlist.stream() 
                                   .map(n->n.name) 
                                   .collect(Collectors.toList());
      System.out.println(names); 
      
      Double avgAge = studentlist.stream()   
              .collect(Collectors.averagingInt(s->s.age));  
          System.out.println("Average Age of Students is: "+avgAge);
          
          
          List<String> namesList = studentlist.stream().map(e -> e.getName()).collect(Collectors.toList());
          System.out.println("namesList...."+namesList);
          //List<String> namesList2 = studentlist.stream().map(e -> e.getName()=="Jon" && e.getAge()==18))).collect(Collectors.toList());
          //System.out.println("namesList2......."+namesList2);

   }  
}
