package com.example;

import com.google.common.collect.HashBiMap;


public class BiMap {

	public static void main(String[] args) {
		com.google.common.collect.BiMap<Integer,String> empIDNameMap = HashBiMap.create();
		 

	      empIDNameMap.put(101, "namita");
	      empIDNameMap.put(102, "ashok");
	      empIDNameMap.put(103, "rahul");
	      empIDNameMap.forcePut(101, "harshi");
	  
	      empIDNameMap.forEach((s,k)->System.out.println(s+k));
	      
	      
	      System.out.println(empIDNameMap.inverse().get("rahul"));
	   
	      
	      

	}

}
