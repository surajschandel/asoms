package com.lakeacr.asoms.utils;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Test {
		  
	    // Main method 
	    public static void main(String[] args) 
	    { 
	    	IntPredicate isOdd = argument -> argument %2 == 0;
	        IntStream 
	  
	            // Iterate the IntStream with i 
	            // by incrementing the value with 1 
	            .iterate(0, i -> i + 1)
	            .filter(isOdd)
	            .forEach(System.out::println);
	  
	            // Print the IntStream 
	            // using forEach() method. 
	             
	    } 
	
}
