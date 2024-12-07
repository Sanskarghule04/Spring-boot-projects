package com.qsp.employee_springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.employee_springboot.dao.EmployeeDao;
import com.qsp.employee_springboot.dto.Employee;
import com.qsp.employee_springboot.repo.EmployeeRepo;
import com.qsp.employee_springboot.service.EployeeService;
import com.qsp.employee_springboot.util.ResponseStructure;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EployeeService service;

	// Save
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}

	@PostMapping("/saveAll")
	public ResponseEntity<ResponseStructure<List<Employee>>> saveEmployee(@RequestBody List<Employee> employees) {
		return service.saveAllEmployees(employees);
	}

	// Find
	@GetMapping("/all")
	public ResponseEntity<ResponseStructure<List<Employee>>> findAllEmployees() {
		return service.findAll();
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<ResponseStructure<Employee>> findEmployeeById(@PathVariable int id) {
		return service.findById(id);
	}

	@GetMapping("/findByEmail/{email}")
	public ResponseEntity<ResponseStructure<Employee>> findEmployeeByEmail(@PathVariable String email) {
		return service.findByEmail(email);
	}

	@GetMapping("/findByName/{name}")
	public ResponseEntity<ResponseStructure<List<Employee>>> findEmployeeByName(@PathVariable String name) {
		return service.findByName(name);
	}

	@GetMapping("/findByPhone/{phone}")
	public ResponseEntity<ResponseStructure<Employee>> findEmployeeByPhone(@PathVariable long phone) {
		return service.findByPhone(phone);
	}

	@GetMapping("/findByAddress/{address}")
	public ResponseEntity<ResponseStructure<List<Employee>>> findEmployeeByAddress(@PathVariable String address) {
		return service.findByAddress(address);
	}

	@GetMapping("/findByDesignation/{designation}")
	public ResponseEntity<ResponseStructure<List<Employee>>> findEmployeeByDesignation(
			@PathVariable String designation) {
		return service.findByDesignation(designation);
	}

	@GetMapping("/findBySalaryLessThan/{salary}")
	public ResponseEntity<ResponseStructure<List<Employee>>> findEmployeeBySalaryLessThan(@PathVariable double salary) {
		return service.findBySalaryLessThan(salary);
	}

	@GetMapping("/findBySalaryGreaterThan/{salary}")
	public ResponseEntity<ResponseStructure<List<Employee>>> findEmployeeBySalaryGreaterThan(
			@PathVariable double salary) {
		return service.findBySalaryGreaterThan(salary);
	}

	@GetMapping("/findBySalaryBetween/{salary1}/{salary2}")
	public ResponseEntity<ResponseStructure<List<Employee>>> findEmployeeBySalaryBetween(@PathVariable double salary1,
			@PathVariable double salary2) {
		return service.findBySalaryBetween(salary1, salary2);
	}

	@GetMapping("/login")
	public ResponseEntity<ResponseStructure<String>> login(@RequestParam String userName,
			@RequestParam String password) {
		return service.login(userName, password);
	}

	// Update
//    @PatchMapping("/update/{id}")
//    public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
//        return service.updateEmployee(id, updatedEmployee);
//    }

	@PatchMapping("/update/email/{id}/{email}")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployeeEmailById(@PathVariable int id,
			@PathVariable String email) {
		return service.updateEmployeeEmailById(id, email);
	}

	@PatchMapping("/update/phone/{id}/{phone}")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployeePhoneById(@PathVariable int id,
			@PathVariable long phone) {
		return service.updateEmployeePhoneById(id, phone);
	}

	@PatchMapping("/update/password/{id}/{password}")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployeePasswordById(@PathVariable int id,
			@PathVariable String password) {
		return service.updateEmployeePasswordById(id, password);
	}

	@PatchMapping("/update/salary/{id}/{salary}")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployeeSalaryById(@PathVariable int id,
			@PathVariable double salary) {
		return service.updateEmployeeSalaryById(id, salary);
	}

	@PatchMapping("/update/designation/{id}/{designation}")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployeeDesignationById(@PathVariable int id,
			@PathVariable String designation) {
		return service.updateEmployeeDesignationById(id, designation);
	}

	@PatchMapping("/update/name/{id}/{name}")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployeeNameById(@PathVariable int id,
			@PathVariable String name) {
		return service.updateEmployeeNameById(id, name);
	}

	@PatchMapping("/update/passwordByEmail/{email}/{password}")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployeePasswordByEmail(@PathVariable String email,
			@PathVariable String password) {
		return service.updateEmployeePasswordByEmail(email, password);
	}

	@PatchMapping("/update/passwordByPhone/{phone}/{password}")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployeePasswordByPhone(@PathVariable long phone,
			@PathVariable String password) {
		return service.updateEmployeePasswordByPhone(phone, password);
	}

	// Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteEmployeeById(@PathVariable int id) {
		return service.deleteEmployeeById(id);
	}

	@DeleteMapping("/delete/byEmail/{email}")
	public ResponseEntity<ResponseStructure<String>> deleteEmployeeByEmail(@PathVariable String email) {
		return service.deleteEmployeeByEmail(email);
	}

	@DeleteMapping("/delete/byPhone/{phone}")
	public ResponseEntity<ResponseStructure<String>> deleteEmployeeByPhone(@PathVariable long phone) {
		return service.deleteEmployeeByPhone(phone);
	}

	@DeleteMapping("/delete/byName/{name}")
	public ResponseEntity<ResponseStructure<String>> deleteEmployeeByName(@PathVariable String name) {
		return service.deleteEmployeeByName(name);
	}

	@DeleteMapping("/delete/byAddress/{address}")
	public ResponseEntity<ResponseStructure<String>> deleteEmployeeByAddress(@PathVariable String address) {
		return service.deleteEmployeeByAddress(address);
	}

	@DeleteMapping("/delete/all")
	public ResponseEntity<ResponseStructure<String>> deleteAllEmployees() {
		return service.deleteAllEmployees();
	}
}