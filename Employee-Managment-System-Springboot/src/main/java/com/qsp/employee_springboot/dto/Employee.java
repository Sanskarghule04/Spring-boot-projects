package com.qsp.employee_springboot.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "employee_info")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeId")
    private int id;

    @NotEmpty
    @Column(name = "employeeName")
    private String name;

    @Min(6000000000L)
	@Max(9999999999L)
    @Column(name = "employeePhone", unique = true)
    private long phone;

    @NotEmpty
    @Column(name = "employeeAddress")
    private String address;

    @NotEmpty (message="email can't be Empty")
	@Email(regexp = "[a-z0-9,_$]+@(a-z]+\\.[a-z](2,3)",message="incorrect email format")
    @Column(name = "employeeEmail", unique = true)
    private String email;

    @NotEmpty(message = "password can't be Empty")
    @Size(min = 6, max = 16, message = "password must be between 6 and 16 characters long")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,16}$", message = "password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character")
    @Column(name = "employeePassword")
    private String password;
    
    @NotEmpty
    @Min(0)
    @Column(name = "employeeSalary")
    private double salary;

    @NotEmpty
    @Column(name = "employeeDesignation")
    private String designation;
    
    @Column(name = "employeeGrade")    
    private char grade;
}

