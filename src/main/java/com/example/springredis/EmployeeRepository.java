package com.example.springredis;


import java.util.Map;

public interface EmployeeRepository {
void save(Employee employee) throws EmployeeException;
Map<String, Employee> findAll();
void update(Employee employee) throws EmployeeException;
void delete(String id) throws EmployeeException;
Employee findById(String id) throws EmployeeException;

}

