package com.example.interfaces;

import java.util.ArrayList;
import java.util.List;

import com.example.pojo.Employee;

public interface TestInterface {
		
	List<Employee> empList = new ArrayList<Employee>();

	
	default List<Employee> add_all_employee(){
		empList.add(new Employee(1,"harshita_paliwal",40000));
		empList.add(new Employee(1,"harshita",39000));
		empList.add(new Employee(2,"namita",25000));
		empList.add(new Employee(3,"ashok",20000));	
		empList.add(new Employee(4,"omkar",22000));
		

		
		return empList;
		
	}
	
}
