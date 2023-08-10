package com.training.empScenario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.empScenario.entity.Employee;
import com.training.empScenario.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	public EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmloyees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int empId) {
		return employeeRepository.findById(empId).orElse(null);
	}

	@Override
	public List<Employee> getEmployeeByDesignation(String empDesg) {
		return employeeRepository.findEmployeeByDesignation(empDesg);
	}

	@Override
	public Employee addEmployee(Employee newEmp) {
		return employeeRepository.save(newEmp);
	}

	@Override
	public Employee updateEmployeeSalary(int empId, int revSalary) {
		Employee e = employeeRepository.findById(empId).orElse(null);
		e.setSalary(revSalary);
		return employeeRepository.save(e);
	}

	@Override
	public void deleteEmployee(int empId) {
		employeeRepository.deleteById(empId);
	}

}
