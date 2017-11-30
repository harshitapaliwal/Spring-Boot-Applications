package com.cg.emp.Demo_Emp;

import static org.junit.Assert.*;

import javax.annotation.security.RunAs;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.emp.exception.EmployeeException;
import com.cg.emp.model.Employee;
import com.cg.emp.repository.EmployeeRepository;
import com.cg.emp.service.EmployeeService;
@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {
	@Mock
	private EmployeeRepository employeeRepository;
	
	@InjectMocks
	private EmployeeService employeeService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testaddEmployee() throws EmployeeException{
		Employee employee = new Employee();
		employee.setEmp_id((long) 3);
		employee.setEmp_name("Aman");
		employee.setEmp_dept("ServiceDesk");
		employee.setEmp_salary(19000);
//		when(employeeRepository.save(Any(Employee.class))).thenReturn(employee);

		Employee new_employee = employeeService.create(employee);
		assertEquals("Aman",new_employee.getEmp_name());
	}
}
