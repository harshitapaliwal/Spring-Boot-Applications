package com.cg.emp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.emp.model.Employee;

@Repository      
public interface EmployeeRepository extends CrudRepository<Employee, Long> {	

}
