package com.training.empScenario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.training.empScenario.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query("SELECT e from Employee e WHERE e.designation=?1")
	List<Employee> findEmployeeByDesignation(String desg);
}
