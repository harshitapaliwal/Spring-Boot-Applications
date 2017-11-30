package com.example;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;

public class MultiMap {

	public static void main(String[] args) {
		  Multimap<String,String> multimap = ArrayListMultimap.create();

	      multimap.put("lower", "a");
	      multimap.put("lower", "b");
	      multimap.put("lower", "c");
	      multimap.put("lower", "d");
	      multimap.put("lower", "e");

	      multimap.put("upper", "A");
	      multimap.put("upper", "B");
	      multimap.put("upper", "C");
	      multimap.put("upper", "D");		
	      
	      
	      List<String> lowerList = (List<String>)multimap.get("lower");
	      System.out.println("Initial lower case list");
	      System.out.println(lowerList.toString());

	      lowerList.add("f");
	      System.out.println("Modified lower case list");
	      System.out.println(lowerList.toString());

	      List<String> upperList = (List<String>)multimap.get("upper");
	      System.out.println("Initial upper case list");
	      System.out.println(upperList.toString());

	      upperList.remove("D");
	      System.out.println("Modified upper case list");
	      System.out.println(upperList.toString());

	      Map<String, Collection<String>> map = multimap.asMap();
	      System.out.println("Multimap as a map");

	      for (Map.Entry<String,  Collection<String>> entry : map.entrySet()) {
	         String key = entry.getKey();
	         Collection<String> value =  multimap.get(key);
	         System.out.println(key + ":" + value);
	      }

	      System.out.println("Keys of Multimap");
	      Set<String> keys =  multimap.keySet();

	      for(String key:keys) {
	         System.out.println(key);
	      }

	      System.out.println("Values of Multimap");
	      Collection<String> values = multimap.values();
	      System.out.println(values);
	      
	      multimap.put("LOWER", "aA");
	   multimap.forEach((s,k)->System.out.println(s+"  "+k));
	   
	   Multimap<String,String> multimap_new = ArrayListMultimap.create();
	   multimap_new.putAll(multimap);
	   multimap.forEach((s,k)->System.out.println("values of new multi map are: "+s+"  "+k));
	   
	   
	   multimap.remove("lower", "a");
	   multimap.forEach((s,k)->System.out.println("Modified multimap: "+s+"  "+k));
	   
	   
	   System.out.println(multimap.containsKey("lower"));
	   
	  multimap.removeAll("lower");
	  multimap.forEach((s,k)->System.out.println("Modified multimap: "+s+"  "+k));
	  
	   System.out.println(multimap.containsKey("lower"));
	  
	 System.out.println(multimap.size()); 

	 
	   multimap.clear();
	   System.out.println("values are : ");
	   multimap.forEach((s,k)->System.out.println(s+"  "+k));
	   
	// creates a ListMultimap with tree keys and array list values
	   ListMultimap<String, Integer> treeListMultimap =
	       MultimapBuilder.treeKeys().arrayListValues().build();

	   treeListMultimap.put("int", 5);
	   treeListMultimap.put("lower", 6);
	   treeListMultimap.put("upper", 60);
	   
	   treeListMultimap.forEach((s,k)->System.out.println(s+"  "+k));
	}

}
