package com.example;


import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.interfaces.TestInterface;
import com.example.pojo.Employee;

public class Test {

	public static void main(String[] args) {
		
		TestInterface testInterface = new TestInterface() {
		};
	
		List<Employee> empList = testInterface.add_all_employee();
		
		Predicate<Employee> pred = (p)->p.getName()=="harshita_paliwal";
	
		Predicate<Employee> predicate = (p)->p.getName().startsWith("b");
		
		//SequentialStream with filter condition
 		empList.stream().filter(pred).forEach(str -> System.out.println("Sequential Stream: "+str));
 		
 		//ParallelStram with filter condition
 		empList.parallelStream().filter(pred).forEach(str -> System.out.println("Parallel Stream: "+str));
 		
 		//All Match
 		boolean flag = empList.stream().allMatch(pred);
 		System.out.println("All Match flag is: "+flag);
 		
 		//Any Match
 		flag = empList.stream().anyMatch(pred);
 		System.out.println("Any Match flag is: "+flag);
 		
		//None Match
 		flag = empList.stream().noneMatch(predicate);
 		System.out.println("None Match flag is: "+flag);
 		
 		//Find Any
 		Optional<Employee> result = empList.parallelStream().findAny();
 		System.out.println("result is: "+result);
 		
 		//Find First
 		Optional<Employee> result_findFirst = empList.parallelStream().findFirst();
 		System.out.println("result is: "+result_findFirst);
 		  
 		//Map
 		 List<String>list = empList.stream().map(emp -> emp.getName().toUpperCase()).collect(Collectors.toList());
 		 list.forEach(System.out::println);
 		 
 		 System.out.println("FlatMap Is:");
 		//FlatMap
 		Stream<List<Employee>> list_emp = Stream.of(empList);
 		Set<Employee> employee_list= list_emp.flatMap(strList -> strList.stream()).collect(Collectors.toSet());
 		employee_list.forEach(System.out::println);
 		
 		//Average
 		OptionalDouble Average =empList.stream().mapToDouble(p->p.getSalary()).average();
 		System.out.println("avg: "+Average);
 		
 		//Reduce
 		Optional<Double> totalSalary = empList.stream().map(Employee::getSalary).reduce((a, b) -> a + b);
 		System.out.println("total sal"+totalSalary);
 		
 
 		//Optional<T> class to deal with NullPointerException
 		
 		
 		//Grouping
 		Map<Integer, List<Employee>> employeebyId =empList.stream()
 		     .collect(Collectors.groupingBy(Employee::getId));

 		System.out.println(employeebyId.get(1));

 	employeebyId.get(1).stream().filter(pred).forEach(str -> System.out.println("Values: "+str));

 // Instant and LocalDate
 Instant instant = Instant.now();

 System.out.println(instant);
 
Instant instant1 = Instant.ofEpochMilli(new Date().getTime());
System.out.println(instant1);

instant1 = Instant.parse("1995-10-23T10:12:35Z");
instant.plus(Duration.ofHours(5).plusMinutes(4));

Instant instant2 = instant.plus(Duration.ofHours(5).plusMinutes(4));
System.out.println("Instant is immutable, so instant==instant returns: " + (instant1 == instant2));

LocalDate localDate = LocalDate.now();
System.out.println(localDate);

LocalDateTime localDateTime = LocalDateTime.now();
System.out.println(localDateTime);






	}


}
