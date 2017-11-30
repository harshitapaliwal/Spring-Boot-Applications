package com.cg.emp.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.emp.exception.EmployeeException;
import com.cg.emp.model.Employee;
import com.cg.emp.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired    								
	private EmployeeRepository employeeRepository;

	public List<Employee> findAll(){
		List<Employee> employee = (List<Employee>) employeeRepository.findAll();
		return employee;
	}
	public Employee getOne(Long id) throws EmployeeException{
		Employee employee=null;
		if(id!=null){
		employee = employeeRepository.findOne(id);	
		}
		else{
			throw new EmployeeException("Service Method not implemented Failed");
		}
		return employee;
	}

	public void delete(Long id) throws EmployeeException {

		if(id!=null){
			employeeRepository.delete(id);
		}
		else{
			throw new EmployeeException("Service Method not implemented Failed"+id);
		}
		
	}
	
	public Employee create(Employee employee) throws EmployeeException{
		Employee new_employee =null;
		if(employee.getEmp_id()!=null){
			 new_employee = employeeRepository.save(employee);
			
			
		}
		else{
			throw new EmployeeException("Service Method not implemented Failed");
		}
		
	return new_employee;
		
	}
	
	


}
