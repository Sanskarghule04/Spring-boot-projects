# Employee Management Spring Boot Application

## Overview
This project is a Spring Boot application designed to manage employee information. It provides RESTful endpoints to perform CRUD operations and various queries on employee data.

## Technologies Used
- Spring Boot
- Spring Data JPA
- Hibernate
- Lombok
- H2 Database (or any preferred database)
- Jakarta Persistence API

## Project Structure

### 1. `com.qsp.employee_springboot.dto`
Contains the `Employee` class, annotated with JPA annotations to map it to the database.

### 2. `com.qsp.employee_springboot.controller`
Contains the `EmployeeController` class, defining the RESTful endpoints for managing employees.

### 3. `com.qsp.employee_springboot.service`
Contains the `EmployeeService` class, handling the business logic and communication with the DAO layer.

### 4. `com.qsp.employee_springboot.dao`
Contains the `EmployeeDao` class, interacting with the database using Spring Data JPA repository methods.

### 5. `com.qsp.employee_springboot.repo`
Contains the `EmployeeRepo` interface, extending `JpaRepository` to provide CRUD operations and custom query methods.

## Endpoints

### EmployeeController

#### Save Operations
- `POST /employee/save` - Save a single employee.
- `POST /employee/saveAll` - Save a list of employees.

#### Find Operations
- `GET /employee/all` - Retrieve all employees.
- `GET /employee/findById` - Retrieve an employee by ID.
- `GET /employee/findByEmail` - Retrieve an employee by email.
- `GET /employee/findByName` - Retrieve employees by name.
- `GET /employee/findByPhone` - Retrieve an employee by phone number.
- `GET /employee/findByAddress` - Retrieve employees by address.
- `GET /employee/findByDesignation` - Retrieve employees by designation.
- `GET /employee/login` - Login an employee using username (email or phone) and password.
- `GET /employee/lessThan` - Retrieve employees with salary less than the given value.
- `GET /employee/greaterThan` - Retrieve employees with salary greater than the given value.
- `GET /employee/between` - Retrieve employees with salary between the given values.

#### Update Operations
- `PATCH /employee/update/email/{id}/{email}` - Update employee email by ID.
- `PATCH /employee/update/phone/{id}/{phone}` - Update employee phone by ID.
- `PATCH /employee/update/password/{id}/{password}` - Update employee password by ID.
- `PATCH /employee/update/salary/{id}/{salary}` - Update employee salary by ID.
- `PATCH /employee/update/designation/{id}/{designation}` - Update employee designation by ID.
- `PATCH /employee/update/name/{id}/{name}` - Update employee name by ID.
- `PATCH /employee/update/password/{email}/{password}` - Update password by email.
- `PATCH /employee/update/password/{phone}/{password}` - Update password by phone.
- `PATCH /employee/update/all` - Update all details of an employee.

#### Delete Operations
- `DELETE /employee/delete/{id}` - Delete an employee by ID.
- `DELETE /employee/delete/byEmail/{email}` - Delete an employee by email.
- `DELETE /employee/delete/byPhone/{phone}` - Delete an employee by phone number.
- `DELETE /employee/delete/byName/{name}` - Delete employees by name.
- `DELETE /employee/delete/byAddress/{address}` - Delete employees by address.
- `DELETE /employee/delete/all` - Delete all employees.

## Setup and Running the Application

1. **Clone the repository**
   ```sh
   git clone <repository-url>
   cd <repository-directory>
