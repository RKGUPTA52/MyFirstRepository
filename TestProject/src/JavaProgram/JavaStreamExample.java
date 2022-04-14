package JavaProgram;

import java.util.*;
import java.util.stream.Collectors;  
class Product{  
    int id;  
    String name;  
    float price;  
    public Product(int id, String name, float price) {  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }  
}  
public class JavaStreamExample {  
    public static void main(String[] args) {  
        List<Product> productsList = new ArrayList<Product>();  
        //Adding Products  
        productsList.add(new Product(1,"HP Laptop",25000f));  
        productsList.add(new Product(2,"Dell Laptop",30000f));  
        productsList.add(new Product(3,"Lenevo Laptop",28000f));  
        productsList.add(new Product(4,"Sony Laptop",28000f));  
        productsList.add(new Product(5,"Apple Laptop",90000f));  
        List<Float> productPriceList = new ArrayList<Float>();  
        for(Product product: productsList){  
              
            // filtering data of list  
            if(product.price<30000){  
                productPriceList.add(product.price);    // adding price to a productPriceList  
            }  
        }  
        System.out.println(productPriceList);   // displaying data 
        //reduce() Method in Collection - ex.sum of all the product prices
        Float totalPrice = productsList.stream()  
                .map(product->product.price)  
                .reduce(0.0f,(sum, price)->sum+price);   // accumulating price  
    System.out.println(totalPrice);  
    // More precise code ex.Stream.reduce() combine elements of a stream and produces a single value.  
    float totalPrice2 = productsList.stream()  
            .map(product->product.price)  
            .reduce(0.0f,Float::sum);   // accumulating price, by referring method of Float class  
    System.out.println(totalPrice2);  
    } 
    
}  