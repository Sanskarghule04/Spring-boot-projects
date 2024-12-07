package com.qsp.employee_springboot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.employee_springboot.dto.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	Employee findByPhone(long phone);

	Employee findByEmail(String email);

	List<Employee> findByName(String name);

	List<Employee> findByAddress(String address);

	List<Employee> findBySalaryLessThan(double salary);

	List<Employee> findBySalaryGreaterThan(double salary);

	List<Employee> findBySalaryBetween(double salary1, double salary2);

	List<Employee> findByDesignation(String designation);

}
