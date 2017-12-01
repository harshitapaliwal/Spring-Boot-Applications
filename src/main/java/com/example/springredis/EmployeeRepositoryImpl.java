package com.example.springredis;


import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
@SuppressWarnings("unused")
private RedisTemplate<String , Employee> redisTemplate;


	private HashOperations<String, String, Employee> hashOperations;

	public EmployeeRepositoryImpl(RedisTemplate<String, Employee> redisTemplate) {
	super();
	this.redisTemplate = redisTemplate;
	hashOperations = redisTemplate.opsForHash();
}

	public void save(Employee employee) throws EmployeeException {
		if(employee.getEmp_id()!=null){
		hashOperations.put("Employee_4", employee.getEmp_id(), employee);}
		else{
			throw new EmployeeException("Employee record cannot be inserted");
		}

	}

	public Map<String,Employee> findAll() {
		// TODO Auto-generated method stub
		return  hashOperations.entries("Employee_4");
	}

	public void update(Employee employee) throws EmployeeException {
		if(employee.getEmp_id()!=null){
		hashOperations.put("Employee_4", employee.getEmp_id(), employee);
		}
		else{
			throw new EmployeeException("Employee record cannot be updated");
		}
	}

	public void delete(String id) throws EmployeeException {
		if(id!=null){
		hashOperations.delete("Employee_4", id);
		}
		else{
			throw new EmployeeException("Id is incorrect: "+id);
		}
		
	}

	public Employee findById(String id) throws EmployeeException {
		Employee employee=null;
		if(id!=null){
			employee = (Employee) hashOperations.get("Employee_4", id);
		}
		else{
			throw new EmployeeException("Employee with th Id: "+id+" ,does not exist");
		}
		return employee;
	}

}
