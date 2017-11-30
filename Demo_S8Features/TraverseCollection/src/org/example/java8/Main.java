package org.example.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String args[]){
		 
		List<String> strings = new ArrayList<String>();
		strings.add("AAA");
		strings.add("bbb");
		strings.add("CCC");
		strings.add("ddd");
		strings.add("");
		strings.add("EEE");

		
		
		
		
		Random random = new Random();
		random.ints().limit(10).sorted().forEach(System.out::println);
		long count = strings.stream().filter(string -> string.isEmpty()).count();
		
		System.out.println("count :"+count);
	}
}
