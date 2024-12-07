package com.qsp.employee_springboot.service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.qsp.employee_springboot.dao.EmployeeDao;
import com.qsp.employee_springboot.dto.Employee;
import com.qsp.employee_springboot.exception.EmailNotFoudException;
import com.qsp.employee_springboot.exception.IdNotFoundException;
import com.qsp.employee_springboot.exception.NoDataAvaliableException;
import com.qsp.employee_springboot.exception.PhoneNotFoundException;
import com.qsp.employee_springboot.util.ResponseStructure;

@Service
public class EployeeService {

	@Autowired
	private EmployeeDao dao;

	
	
	
	
	 // Save a single employee
    public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee) {
        ResponseStructure<Employee> structure = new ResponseStructure<>();
        structure.setStatus(HttpStatus.CREATED.value());
        structure.setMessage("Saved Successfully");
        structure.setData(dao.saveEmployee(employee));
        return new ResponseEntity<>(structure, HttpStatus.CREATED);
    }

    // Save a list of employees
    public ResponseEntity<ResponseStructure<List<Employee>>> saveAllEmployees(List<Employee> employees) {
        ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
        structure.setStatus(HttpStatus.CREATED.value());
        structure.setMessage("Saved Successfully");
        structure.setData(dao.saveAllEmployees(employees));
        return new ResponseEntity<>(structure, HttpStatus.CREATED);
    }

    // Find all employees
    public ResponseEntity<ResponseStructure<List<Employee>>> findAll() {
        List<Employee> list = dao.findAll();
        ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
        if (list.isEmpty()) {
            throw new NoDataAvaliableException("No data available");
        } else {
            structure.setStatus(HttpStatus.FOUND.value());
            structure.setMessage("Data found");
            structure.setData(list);
            return new ResponseEntity<>(structure, HttpStatus.FOUND);
        }
    }

    // Find employee by ID
    public ResponseEntity<ResponseStructure<Employee>> findById(int id) {
        Optional<Employee> optional = dao.findById(id);
        ResponseStructure<Employee> structure = new ResponseStructure<>();
        if (optional.isPresent()) {
            structure.setStatus(HttpStatus.FOUND.value());
            structure.setMessage("Data found");
            structure.setData(optional.get());
            return new ResponseEntity<>(structure, HttpStatus.FOUND);
        } else {
            throw new IdNotFoundException("Employee with ID " + id + " not found");
        }
    }

    // Find employee by email
    public ResponseEntity<ResponseStructure<Employee>> findByEmail(String email) {
        Employee employee = dao.findByEmail(email);
        ResponseStructure<Employee> structure = new ResponseStructure<>();
        if (employee != null) {
            structure.setStatus(HttpStatus.FOUND.value());
            structure.setMessage("Data found");
            structure.setData(employee);
            return new ResponseEntity<>(structure, HttpStatus.FOUND);
        } else {
            throw new EmailNotFoudException("Email " + email + " not found");
        }
    }

    // Find employees by name
    public ResponseEntity<ResponseStructure<List<Employee>>> findByName(String name) {
        List<Employee> list = dao.findByName(name);
        ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
        if (list.isEmpty()) {
            throw new NoDataAvaliableException("No data available for " + name);
        } else {
            structure.setStatus(HttpStatus.FOUND.value());
            structure.setMessage("Data found");
            structure.setData(list);
            return new ResponseEntity<>(structure, HttpStatus.FOUND);
        }
    }

    // Find employee by phone
    public ResponseEntity<ResponseStructure<Employee>> findByPhone(long phone) {
        Employee employee = dao.findByPhone(phone);
        ResponseStructure<Employee> structure = new ResponseStructure<>();
        if (employee != null) {
            structure.setStatus(HttpStatus.FOUND.value());
            structure.setMessage("Data found");
            structure.setData(employee);
            return new ResponseEntity<>(structure, HttpStatus.FOUND);
        } else {
            throw new PhoneNotFoundException("Phone " + phone + " not found");
        }
    }

    // Find employees by address
    public ResponseEntity<ResponseStructure<List<Employee>>> findByAddress(String address) {
        List<Employee> list = dao.findByAddress(address);
        ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
        if (list.isEmpty()) {
            throw new NoDataAvaliableException("No data available for " + address);
        } else {
            structure.setStatus(HttpStatus.FOUND.value());
            structure.setMessage("Data found");
            structure.setData(list);
            return new ResponseEntity<>(structure, HttpStatus.FOUND);
        }
    }

    // Find employees by designation
    public ResponseEntity<ResponseStructure<List<Employee>>> findByDesignation(String designation) {
        List<Employee> list = dao.findByDesignation(designation);
        ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
        if (list.isEmpty()) {
            throw new NoDataAvaliableException("No data available for " + designation);
        } else {
            structure.setStatus(HttpStatus.FOUND.value());
            structure.setMessage("Data found");
            structure.setData(list);
            return new ResponseEntity<>(structure, HttpStatus.FOUND);
        }
    }

    // Find employees by salary less than
    public ResponseEntity<ResponseStructure<List<Employee>>> findBySalaryLessThan(double salary) {
        List<Employee> list = dao.findBySalaryLessThan(salary);
        ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
        if (list.isEmpty()) {
            throw new NoDataAvaliableException("No data available for salary less than " + salary);
        } else {
            structure.setStatus(HttpStatus.FOUND.value());
            structure.setMessage("Data found");
            structure.setData(list);
            return new ResponseEntity<>(structure, HttpStatus.FOUND);
        }
    }

    // Find employees by salary greater than
    public ResponseEntity<ResponseStructure<List<Employee>>> findBySalaryGreaterThan(double salary) {
        List<Employee> list = dao.findBySalaryGreaterThan(salary);
        ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
        if (list.isEmpty()) {
            throw new NoDataAvaliableException("No data available for salary greater than " + salary);
        } else {
            structure.setStatus(HttpStatus.FOUND.value());
            structure.setMessage("Data found");
            structure.setData(list);
            return new ResponseEntity<>(structure, HttpStatus.FOUND);
        }
    }

    // Find employees by salary between
    public ResponseEntity<ResponseStructure<List<Employee>>> findBySalaryBetween(double salary1, double salary2) {
        List<Employee> list = dao.findBySalaryBetween(salary1, salary2);
        ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
        if (list.isEmpty()) {
            throw new NoDataAvaliableException("No data available for salary between " + salary1 + " and " + salary2);
        } else {
            structure.setStatus(HttpStatus.FOUND.value());
            structure.setMessage("Data found");
            structure.setData(list);
            return new ResponseEntity<>(structure, HttpStatus.FOUND);
        }
    }

    // Delete employee by ID
    public ResponseEntity<ResponseStructure<String>> deleteEmployeeById(int id) {
        Employee employee = dao.deleteEmployeeById(id);
        ResponseStructure<String> structure = new ResponseStructure<>();
        if (employee != null) {
            structure.setStatus(HttpStatus.OK.value());
            structure.setMessage("Deleted employee with ID: " + id);
            structure.setData("Deleted employee with ID: " + id);
            return new ResponseEntity<>(structure, HttpStatus.OK);
        } else {
            structure.setStatus(HttpStatus.NOT_FOUND.value());
            structure.setMessage("Employee not found with ID: " + id);
            structure.setData("Employee not found with ID: " + id);
            return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
        }
    }

    // Delete employee by email
    public ResponseEntity<ResponseStructure<String>> deleteEmployeeByEmail(String email) {
        Employee employee = dao.deleteEmployeeByEmail(email);
        ResponseStructure<String> structure = new ResponseStructure<>();
        if (employee != null) {
            structure.setStatus(HttpStatus.OK.value());
            structure.setMessage("Deleted employee with email: " + email);
            structure.setData("Deleted employee with email: " + email);
            return new ResponseEntity<>(structure, HttpStatus.OK);
        } else {
            structure.setStatus(HttpStatus.NOT_FOUND.value());
            structure.setMessage("Employee not found with email: " + email);
            structure.setData("Employee not found with email: " + email);
            return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
        }
    }

    // Delete employee by phone
    public ResponseEntity<ResponseStructure<String>> deleteEmployeeByPhone(long phone) {
        Employee employee = dao.deleteEmployeeByPhone(phone);
        ResponseStructure<String> structure = new ResponseStructure<>();
        if (employee != null) {
            structure.setStatus(HttpStatus.OK.value());
            structure.setMessage("Deleted employee with phone: " + phone);
            structure.setData("Deleted employee with phone: " + phone);
            return new ResponseEntity<>(structure, HttpStatus.OK);
        } else {
            structure.setStatus(HttpStatus.NOT_FOUND.value());
            structure.setMessage("Employee not found with phone: " + phone);
            structure.setData("Employee not found with phone: " + phone);
            return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
        }
    }

    // Delete all employees
    public ResponseEntity<ResponseStructure<String>> deleteAllEmployees() {
        dao.deleteAllEmployees();
        ResponseStructure<String> structure = new ResponseStructure<>();
        structure.setStatus(HttpStatus.OK.value());
        structure.setMessage("Deleted all employees");
        structure.setData("Deleted all employees");
        return new ResponseEntity<>(structure, HttpStatus.OK);
    }

    // Delete employee by name
    public ResponseEntity<ResponseStructure<String>> deleteEmployeeByName(String name) {
        List<Employee> employees = dao.deleteEmployeeByName(name);
        ResponseStructure<String> structure = new ResponseStructure<>();
        if (!employees.isEmpty()) {
            structure.setStatus(HttpStatus.OK.value());
            structure.setMessage("Deleted employees with name: " + name);
            structure.setData("Deleted employees with name: " + name);
            return new ResponseEntity<>(structure, HttpStatus.OK);
        } else {
            structure.setStatus(HttpStatus.NOT_FOUND.value());
            structure.setMessage("Employee not found with name: " + name);
            structure.setData("Employee not found with name: " + name);
            return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
        }
    }

    // Delete employee by address
    public ResponseEntity<ResponseStructure<String>> deleteEmployeeByAddress(String address) {
        List<Employee> employees = dao.deleteEmployeeByAddress(address);
        ResponseStructure<String> structure = new ResponseStructure<>();
        if (!employees.isEmpty()) {
            structure.setStatus(HttpStatus.OK.value());
            structure.setMessage("Deleted employees with address: " + address);
            structure.setData("Deleted employees with address: " + address);
            return new ResponseEntity<>(structure, HttpStatus.OK);
        } else {
            structure.setStatus(HttpStatus.NOT_FOUND.value());
            structure.setMessage("Employee not found with address: " + address);
            structure.setData("Employee not found with address: " + address);
            return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
        }
    }

    // Update employee email by ID
    public ResponseEntity<ResponseStructure<Employee>> updateEmployeeEmailById(int id, String email) {
        Employee employee = dao.updateEmployeeEmailById(id, email);
        ResponseStructure<Employee> structure = new ResponseStructure<>();
        if (employee != null) {
            structure.setStatus(HttpStatus.OK.value());
            structure.setMessage("Employee email updated");
            structure.setData(employee);
            return new ResponseEntity<>(structure, HttpStatus.OK);
        } else {
            throw new IdNotFoundException("Employee with ID " + id + " not found");
        }
    }

    // Update employee phone by ID
    public ResponseEntity<ResponseStructure<Employee>> updateEmployeePhoneById(int id, long phone) {
        Employee employee = dao.updateEmployeePhoneById(id, phone);
        ResponseStructure<Employee> structure = new ResponseStructure<>();
        if (employee != null) {
            structure.setStatus(HttpStatus.OK.value());
            structure.setMessage("Employee phone updated");
            structure.setData(employee);
            return new ResponseEntity<>(structure, HttpStatus.OK);
        } else {
            throw new IdNotFoundException("Employee with ID " + id + " not found");
        }
    }

    // Update employee password by ID
    public ResponseEntity<ResponseStructure<Employee>> updateEmployeePasswordById(int id, String password) {
        Employee employee = dao.updateEmployeePasswordById(id, password);
        ResponseStructure<Employee> structure = new ResponseStructure<>();
        if (employee != null) {
            structure.setStatus(HttpStatus.OK.value());
            structure.setMessage("Employee password updated");
            structure.setData(employee);
            return new ResponseEntity<>(structure, HttpStatus.OK);
        } else {
            throw new IdNotFoundException("Employee with ID " + id + " not found");
        }
    }

    // Update employee salary by ID
    public ResponseEntity<ResponseStructure<Employee>> updateEmployeeSalaryById(int id, double salary) {
        Optional<Employee> optional = dao.findById(id);
        ResponseStructure<Employee> structure = new ResponseStructure<>();
        if (optional.isPresent()) {
            Employee employee = optional.get();
            employee.setSalary(salary);
            if (salary < 10000) {
                employee.setGrade('D');
            } else if (salary <= 20000) {
                employee.setGrade('C');
            } else if (salary <= 40000) {
                employee.setGrade('B');
            } else {
                employee.setGrade('A');
            }
            dao.updateEmployeeSalaryById(id, salary);
            structure.setStatus(HttpStatus.OK.value());
            structure.setMessage("Employee salary updated");
            structure.setData(employee);
            return new ResponseEntity<>(structure, HttpStatus.OK);
        } else {
            throw new IdNotFoundException("Employee with ID " + id + " not found");
        }
    }

    // Update employee designation by ID
    public ResponseEntity<ResponseStructure<Employee>> updateEmployeeDesignationById(int id, String designation) {
        Employee employee = dao.updateEmployeeDesignationById(id, designation);
        ResponseStructure<Employee> structure = new ResponseStructure<>();
        if (employee != null) {
            structure.setStatus(HttpStatus.OK.value());
            structure.setMessage("Employee designation updated");
            structure.setData(employee);
            return new ResponseEntity<>(structure, HttpStatus.OK);
        } else {
            throw new IdNotFoundException("Employee with ID " + id + " not found");
        }
    }

    // Update employee name by ID
    public ResponseEntity<ResponseStructure<Employee>> updateEmployeeNameById(int id, String name) {
        Employee employee = dao.updateEmployeeNameById(id, name);
        ResponseStructure<Employee> structure = new ResponseStructure<>();
        if (employee != null) {
            structure.setStatus(HttpStatus.OK.value());
            structure.setMessage("Employee name updated");
            structure.setData(employee);
            return new ResponseEntity<>(structure, HttpStatus.OK);
        } else {
            throw new IdNotFoundException("Employee with ID " + id + " not found");
        }
    }

    // Update employee password by email
    public ResponseEntity<ResponseStructure<Employee>> updateEmployeePasswordByEmail(String email, String password) {
        Employee employee = dao.updateEmployeePasswordByEmail(email, password);
        ResponseStructure<Employee> structure = new ResponseStructure<>();
        if (employee != null) {
            structure.setStatus(HttpStatus.OK.value());
            structure.setMessage("Employee password updated");
            structure.setData(employee);
            return new ResponseEntity<>(structure, HttpStatus.OK);
        } else {
            throw new EmailNotFoudException("Employee with email " + email + " not found");
        }
    }

    // Update employee password by phone
    public ResponseEntity<ResponseStructure<Employee>> updateEmployeePasswordByPhone(long phone, String password) {
        Employee employee = dao.updateEmployeePasswordByPhone(phone, password);
        ResponseStructure<Employee> structure = new ResponseStructure<>();
        if (employee != null) {
            structure.setStatus(HttpStatus.OK.value());
            structure.setMessage("Employee password updated");
            structure.setData(employee);
            return new ResponseEntity<>(structure, HttpStatus.OK);
        } else {
            throw new PhoneNotFoundException("Employee with phone " + phone + " not found");
        }
    }

    // Update employee
    public ResponseEntity<ResponseStructure<Employee>> updateEmployee(Employee updatedEmployee) {
        Optional<Employee> employeeOptional = dao.findById(updatedEmployee.getId());
        ResponseStructure<Employee> structure = new ResponseStructure<>();
        if (employeeOptional.isPresent()) {
            Employee existingEmployee = employeeOptional.get();
            existingEmployee.setName(updatedEmployee.getName());
            existingEmployee.setEmail(updatedEmployee.getEmail());
            existingEmployee.setPhone(updatedEmployee.getPhone());
            existingEmployee.setAddress(updatedEmployee.getAddress());
            existingEmployee.setDesignation(updatedEmployee.getDesignation());
            double salary = updatedEmployee.getSalary();
            existingEmployee.setSalary(salary);
            if (salary < 10000) {
                existingEmployee.setGrade('D');
            } else if (salary <= 20000) {
                existingEmployee.setGrade('C');
            } else if (salary <= 40000) {
                existingEmployee.setGrade('B');
            } else {
                existingEmployee.setGrade('A');
            }
            dao.saveEmployee(existingEmployee);
            structure.setStatus(HttpStatus.OK.value());
            structure.setMessage("Employee data updated");
            structure.setData(existingEmployee);
            return new ResponseEntity<>(structure, HttpStatus.OK);
        } else {
            throw new IdNotFoundException("Employee with ID " + updatedEmployee.getId() + " not found");
        }
    }

    // Employee login
    public ResponseEntity<ResponseStructure<String>> login(String userName, String password) {
        Employee employee = dao.loginEmployee(userName);
        ResponseStructure<String> structure = new ResponseStructure<>();
        if (employee != null) {
            if (employee.getPassword().equals(password)) {
                structure.setStatus(HttpStatus.OK.value());
                structure.setMessage("Login Success");
                structure.setData("Login Success");
                return new ResponseEntity<>(structure, HttpStatus.OK);
            } else {
                structure.setStatus(HttpStatus.UNAUTHORIZED.value());
                structure.setMessage("Invalid password");
                structure.setData("Invalid password");
                return new ResponseEntity<>(structure, HttpStatus.UNAUTHORIZED);
            }
        } else {
            structure.setStatus(HttpStatus.NOT_FOUND.value());
            structure.setMessage("User not present with userName " + userName);
            structure.setData("User not present with userName " + userName);
            return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
        }
    }
}
