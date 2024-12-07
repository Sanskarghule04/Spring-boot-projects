package com.qsp.employee_springboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.employee_springboot.dto.Employee;
import com.qsp.employee_springboot.repo.EmployeeRepo;

@Repository
public class EmployeeDao {

	@Autowired
	private EmployeeRepo repo;

	 // Save
    public Employee saveEmployee(Employee employee) {
        return repo.save(employee);
    }

    public List<Employee> saveAllEmployees(List<Employee> list) {
        return repo.saveAll(list);
    }

    // Find
    public List<Employee> findAll() {
        return repo.findAll();
    }

    public Employee loginEmployee(String userName) {
        try {
            long phone = Long.parseLong(userName);
            return findByPhone(phone);
        } catch (Exception e) {
            String email = userName;
            return findByEmail(email);
        }
    }

    public List<Employee> findBySalaryLessThan(double salary) {
        return repo.findBySalaryLessThan(salary);
    }

    public List<Employee> findBySalaryGreaterThan(double salary) {
        return repo.findBySalaryGreaterThan(salary);
    }

    public List<Employee> findBySalaryBetween(double salary1, double salary2) {
        return repo.findBySalaryBetween(salary1, salary2);
    }

    public Optional<Employee> findById(int id) {
        return repo.findById(id);
    }

    public Employee findByEmail(String email) {
        return repo.findByEmail(email);
    }

    public List<Employee> findByName(String name) {
        return repo.findByName(name);
    }

    public Employee findByPhone(long phone) {
        return repo.findByPhone(phone);
    }

    public List<Employee> findByAddress(String address) {
        return repo.findByAddress(address);
    }

    public List<Employee> findByDesignation(String designation) {
        return repo.findByDesignation(designation);
    }

    // Update
    public Employee updateEmployeeEmailById(int id, String email) {
        Optional<Employee> optional = repo.findById(id);
        if (optional.isPresent()) {
            Employee employee = optional.get();
            employee.setEmail(email);
            return repo.save(employee);
        } else {
            return null;
        }
    }

    public Employee updateEmployeePhoneById(int id, long phone) {
        Optional<Employee> optional = repo.findById(id);
        if (optional.isPresent()) {
            Employee employee = optional.get();
            employee.setPhone(phone);
            return repo.save(employee);
        } else {
            return null;
        }
    }

    public Employee updateEmployeeSalaryById(int id, double salary) {
        Optional<Employee> optional = repo.findById(id);
        if (optional.isPresent()) {
            Employee employee = optional.get();
            employee.setSalary(salary);
            return repo.save(employee);
        } else {
            return null;
        }
    }

    public Employee updateEmployeeDesignationById(int id, String designation) {
        Optional<Employee> optional = repo.findById(id);
        if (optional.isPresent()) {
            Employee employee = optional.get();
            employee.setDesignation(designation);
            return repo.save(employee);
        } else {
            return null;
        }
    }

    public Employee updateEmployeeNameById(int id, String name) {
        Optional<Employee> optional = repo.findById(id);
        if (optional.isPresent()) {
            Employee employee = optional.get();
            employee.setName(name);
            return repo.save(employee);
        } else {
            return null;
        }
    }

    public Employee updateEmployeePasswordById(int id, String password) {
        Optional<Employee> optional = repo.findById(id);
        if (optional.isPresent()) {
            Employee employee = optional.get();
            employee.setPassword(password);
            return repo.save(employee);
        } else {
            return null;
        }
    }

    public Employee updateEmployeePasswordByPhone(long phone, String password) {
        Employee employee = repo.findByPhone(phone);
        if (employee != null) {
            employee.setPassword(password);
            return repo.save(employee);
        } else {
            return null;
        }
    }

    public Employee updateEmployeePasswordByEmail(String email, String password) {
        Employee employee = repo.findByEmail(email);
        if (employee != null) {
            employee.setPassword(password);
            return repo.save(employee);
        } else {
            return null;
        }
    }

    public Employee updateEmployee(Employee employee) {
        return repo.save(employee);
    }

    // Delete
    public Employee deleteEmployeeById(int id) {
        Optional<Employee> employeeOptional = repo.findById(id);
        if (employeeOptional.isPresent()) {
            repo.deleteById(id);
            return employeeOptional.get();
        } else {
            return null;
        }
    }

    public Employee deleteEmployeeByEmail(String email) {
        Employee employee = repo.findByEmail(email);
        if (employee != null) {
            repo.delete(employee);
        }
        return employee;
    }

    public Employee deleteEmployeeByPhone(long phone) {
        Employee employee = repo.findByPhone(phone);
        if (employee != null) {
            repo.delete(employee);
        }
        return employee;
    }

    public List<Employee> deleteAllEmployees() {
        List<Employee> employees = repo.findAll();
        repo.deleteAll();
        return employees;
    }

    public List<Employee> deleteEmployeeByName(String name) {
        List<Employee> employees = repo.findByName(name);
        if (employees != null && !employees.isEmpty()) {
           repo.deleteAll(employees);
          
        }
        return null;
    }

    public List<Employee> deleteEmployeeByAddress(String address) {
        List<Employee> employees = repo.findByAddress(address);
        if (employees != null && !employees.isEmpty()) {
            repo.deleteAll(employees);
        }
        return employees;
    }

}
