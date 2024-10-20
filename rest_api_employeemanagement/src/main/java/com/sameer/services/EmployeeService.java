package com.sameer.services;

import java.util.List;

import com.sameer.model.Employee;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(long employeeId);

    Employee addEmployee(Employee employee);

    Employee updateEmployee(long employeeId, Employee updatedEmployee);

    boolean deleteEmployee(long employeeId);
}
