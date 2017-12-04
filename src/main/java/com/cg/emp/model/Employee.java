package com.cg.emp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;







@Entity(name = "Employee")	
@Data
public class Employee implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "Emp_ID")
	private String emp_id;
	@Column(name = "Emp_NAME")
	private String emp_name;
	@Column(name = "Emp_DEPT")
	private String emp_dept;
	@Column(name = "Emp_SALARY")
	private double emp_salary;
	
	/*public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_dept() {
		return emp_dept;
	}
	public void setEmp_dept(String emp_dept) {
		this.emp_dept = emp_dept;
	}
	public double getEmp_salary() {
		return emp_salary;
	}
	public void setEmp_salary(double emp_salary) {
		this.emp_salary = emp_salary;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Employee(String emp_id, String emp_name, String emp_dept,
			double emp_salary) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_dept = emp_dept;
		this.emp_salary = emp_salary;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
*/

	
}