package com.training.empScenario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.empScenario.entity.Employee;
import com.training.empScenario.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	public EmployeeService empService;
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee newEmp){
		Employee addedEmp = empService.addEmployee(newEmp);
		return new ResponseEntity<Employee>(addedEmp, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> allEmp = empService.getAllEmloyees();
		return new ResponseEntity<List<Employee>>(allEmp, HttpStatus.OK);
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int empId){
		Employee result = null;
		try {
			result = empService.getEmployeeById(empId);
		}
		catch (Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<Employee>(result, HttpStatus.OK);
	}
	
	@GetMapping("/getByDesignation/{desg}")
	public ResponseEntity<List<Employee>> getEmployeeByDesignation(@PathVariable("desg") String empDesg){
		List<Employee> result = empService.getEmployeeByDesignation(empDesg);
		return new ResponseEntity<List<Employee>>(result, HttpStatus.OK);
	}
	
	@PostMapping("/updateSalary/{id}/{revSalary}")
	public ResponseEntity<Employee> updateEmployeeSalary(@PathVariable("id") int empId, @PathVariable("revSalary") int revSalary){
		Employee updatedEmp = empService.updateEmployeeSalary(empId, revSalary);
		return new ResponseEntity<Employee>(updatedEmp, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable("id") int empId) {
		empService.deleteEmployee(empId);
	}
}
