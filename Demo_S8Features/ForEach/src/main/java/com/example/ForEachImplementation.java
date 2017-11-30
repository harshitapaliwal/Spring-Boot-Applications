package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ForEachImplementation {

	public static void main(String[] args) {
		
			List<Integer> myList = new ArrayList<Integer>();
			for(int i=0; i<10; i++) myList.add(i);
			myList.forEach(new Consumer<Integer>(){

				public void accept(Integer t) {
					
					System.out.println("value of t: "+t);
					
				}
				
			});
			
			MyConsumer action = new MyConsumer();
			myList.forEach(action);
	}
	

	}
class MyConsumer implements Consumer<Integer>{

	public void accept(Integer t) {
		System.out.println("Consumer impl Value::"+t);
	}

}
