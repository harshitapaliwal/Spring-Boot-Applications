package com.example.springredis;


import java.util.Map;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/rest")
@Api(value="Employee Redis Controller API",produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {
	private Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeRepository employeeRepository;
	public EmployeeController(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public String CreateEmployee(@RequestBody Employee employee){
	boolean flag = false;
		try {
			employeeRepository.save(employee);
			flag = true;
			logger.info("Employee Record inserted");
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
		logger.error("Employee Record not inserted");
		}
		if(flag==true){
		
		return "Record Created";
		}
		else
			return "Record Not Created";
	}
	
	@RequestMapping(value="/all",method = RequestMethod.GET)
	public Map<String,Employee> allEmployee(){
		return employeeRepository.findAll();
	}
	
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public String deleteEmployee(@PathVariable("id") String id) {	
		Boolean flag=false;
		Employee employee = null;
	try {
		employee = employeeRepository.findById(id);
		employeeRepository.delete(id);
		if(employee!=null){
		flag=true;
		logger.info("Record deleted for id: " +id);}
		else
			logger.error("Record for the Id: "+id+" ,does not exists");
	} catch (EmployeeException e) {
		// TODO Auto-generated catch block
		logger.error("Record cannot be deleted for the Id: "+id);
	}
	if (flag==true){
		return "Record Deleted";
	}
	else
		return "Record not Deleted";
	}
	
	@RequestMapping(value = "/getEmployee/{id}",method = RequestMethod.GET)
	public Employee get_Employee( @PathVariable("id") String id){
		Employee employee = null;
		try {
			employee = employeeRepository.findById(id);
			if(employee!=null){
			logger.info("Employee with Id: "+id+" returned");}
			else{
				logger.error("Employee with Id: "+id +" ,does not exists " );
			}
		} catch (EmployeeException e) {
			
			logger.error("Employee with Id: "+id +" ,does not exists: " + e.getMessage());
		}
		
		return employee;
		
	}
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public String updateEmployee(@RequestBody Employee employee){
		Boolean flag=false;
		try {
			employeeRepository.update(employee);
			flag=true;
			logger.info("Employee Record updated");
		} catch (EmployeeException e) {
			
		logger.error("Employee Record not updated");
		}
		if(flag==true){
		
		return "Record Updated";}
		else
			return "Record Not Updated";
	}
}
