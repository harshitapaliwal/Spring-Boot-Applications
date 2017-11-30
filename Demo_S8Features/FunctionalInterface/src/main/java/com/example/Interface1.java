package com.example;


public interface Interface1 {
	
     void method1();

	default void log(String str){
		System.out.println("I1 logging::"+str);
	}
	
	default void print(String str){
		System.out.println("Printing "+str);
	}


}


