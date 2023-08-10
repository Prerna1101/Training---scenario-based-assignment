package com.training.empScenario.service;

import java.util.List;

import com.training.empScenario.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmloyees();
	public Employee getEmployeeById(int empId);
	public List<Employee> getEmployeeByDesignation(String empDesg);
	public Employee addEmployee(Employee newEmp);
	public Employee updateEmployeeSalary(int empId, int revSalary);
	public void deleteEmployee(int empId);

}
