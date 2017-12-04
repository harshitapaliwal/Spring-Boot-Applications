package com.cg.emp.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.emp.exception.EmployeeException;
import com.cg.emp.model.Employee;
import com.cg.emp.service.EmployeeService;

@RestController
@Api(value="Employee Controller API",produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {
	private Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeService employeeService;
	
	
	
	@RequestMapping(value="/emp/allemployee",method=RequestMethod.GET)
	public List<Employee> getAllEmployee(){
		
		return employeeService.findAll();
	}

	@RequestMapping(value = "/getEmployee/{id}", method = RequestMethod.GET)
	@ApiOperation(value="Get Employees with the particular Id")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
	
	public Employee get_Employee( @PathVariable("id") String id){
		Employee employee =null;
		try {
			employee= employeeService.getOne(id);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			logger.error("ID cannot be detected: " + e.getMessage());
		}
		return employee;
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)

	public String deleteEmployee(@PathVariable("id") String id) {
		
		try {
			
			employeeService.delete(id);
			logger.info("Record deleted for id: " +id);
			
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			
			logger.error("Record cannot be deleted: " + e.getMessage());
		}
		return "Record Deleted";
	}
	
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	
	public Employee CreateEmployee(@RequestBody Employee employee) {
		Employee new_employee =null;
		try {
			 new_employee = employeeService.create(employee);
			logger.info("New Record inserted");
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			logger.error("Record cannot be inserted: " + e.getMessage());
		}
		return new_employee;
	}

}
