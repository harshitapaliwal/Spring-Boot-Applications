package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;



import com.example.pojo.Employee;
import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Sets;
public class Strings {

	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee(1,"harshita_paliwal",40000));
		empList.add(new Employee(1,"harshita",39000));
		empList.add(new Employee(2,"namita",25000));
		empList.add(new Employee(3,"ashok",20000));	
		empList.add(new Employee(4,"omkar",22000));
		
	
	
	 //Joiner
	 Joiner joiner = Joiner.on(" ;").useForNull("str");
	 String str = joiner.join(empList);
	 System.out.println(str);
	 
	 //Splitter
	 Iterable<String> str1 =  Splitter.on(",").limit(6).trimResults().omitEmptyStrings().split(str);
	 str1.forEach(s->System.out.println(s));
	 
	 //CaseFormat
	 String string = "harshita_paliwal";
	 String result = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_UNDERSCORE, string);
	 System.out.println(result);
	 
	 
	 //CharMatcher
	 char c = 97;
	 char e = 100;
	 String match= "yess";
	 String string1 = "harshitapaliwAl";

	 System.out.println(CharMatcher.is(c).matchesAnyOf(string));
	 System.out.println(CharMatcher.anyOf(match).matchesAnyOf(string));
	 System.out.println(CharMatcher.breakingWhitespace().matchesAnyOf(string1));
	 System.out.println(CharMatcher.inRange(c, e).matchesAnyOf(string1));
	 System.out.println(CharMatcher.inRange(c, e).collapseFrom(string1, e));
	 System.out.println(CharMatcher.javaLowerCase().retainFrom(string1));
	 System.out.println(CharMatcher.javaLowerCase().trimFrom(string1));
	 System.out.println(CharMatcher.whitespace().removeFrom(string1));
	 
	 
	 //Sets
	 
	 ImmutableSet<String> wordsWithPrimeLength = ImmutableSortedSet.of("one", "two", "three", "six", "seven", "eight");
	 Set<String> primes = ImmutableSet.of("two", "three", "five", "seven");
	 
	 wordsWithPrimeLength.forEach(s->System.out.println("wordsWithPrimeLength :"+s));
	 System.out.println("asList with get key: "+wordsWithPrimeLength.asList().get(2));
	
	
	 Set<String> set = Sets.symmetricDifference(wordsWithPrimeLength, primes);
	 @SuppressWarnings("unchecked")
	Set<List<String>> set1 = Sets.cartesianProduct(wordsWithPrimeLength,primes);
	 

	 
	set.forEach(s->System.out.println(s)); 
	set1.forEach(s->System.out.println(s)); 
	
	set = Sets.difference(wordsWithPrimeLength, primes);
	set.forEach(s->System.out.println(s)); 
	
	set = Sets.intersection(primes, wordsWithPrimeLength);
	set.forEach(s->System.out.println(s)); 

	
	List<String> list = ImmutableList.copyOf(primes);
	list.forEach(s->System.out.println("list is:"+s));



	}

}


