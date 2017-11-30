package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Tests {
		
	public static void main(String[] args){
		
		 //with type declaration
	      MathOperation addition = (int a, int b) -> a + b;
			
	      //with out type declaration
	      MathOperation subtraction = (a, b) -> a - b;
			
	      //with return statement along with curly braces
	      MathOperation multiplication = ( a,  b) -> { return a * b; };
			
	      //without return statement and without curly braces
	      MathOperation division = (int a, int b) -> a / b;
			System.out.println(addition.operation(10, 5));
	   
			
	      //without parenthesis
	      GreetingService greetService1 = message ->
	      System.out.println("Hello " + message);
			
	      //with parenthesis
	      GreetingService greetService2 = (message) ->{
	      System.out.println("Hello " + message);};
			
	      greetService1.sayMessage("Mahesh");
	      greetService2.sayMessage("Suresh");
	      Stream<Integer> numbers = Stream.of(1,2,3,4,5);
			
	      Optional<Integer> intOptional = numbers.reduce((i,j) -> {return i+j;});
	      if(intOptional.isPresent()) System.out.println("Multiplication = "+intOptional.get());
	      
	      Stream<List<String>> namesOriginalList = Stream.of(
	    			Arrays.asList("Pankaj"), 
	    			Arrays.asList("David", "Lisa"),
	    			Arrays.asList("Amit"));
	    		//flat the stream from List<String> to String stream
	    		Stream<String> flatStream = namesOriginalList
	    			.flatMap(strList -> strList.stream());

	    		flatStream.forEach(System.out::println);
	}
	  interface MathOperation {
	      int operation(int a, int b);
	   }
		
	   interface GreetingService {
	      void sayMessage(String message);
	   }
		
	 
}
