package com;

import java.util.HashMap;

public class SingleKeyMultipleValueUsingList {
	
public static void main(String[] args) {

	HashMap<String, String> haloCars = new HashMap<String, String>();

	haloCars.put("ford", "GT");
	haloCars.put("dodge", "Viper");
	//next line wipes out the value "GT" in the "ford" key
	haloCars.put("ford", "Mustang Mach-E");

	System.out.println(haloCars.get("ford"));
    }
}


