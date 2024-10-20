package com.sameer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sameer.model.Employee;
import com.sameer.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeDao;

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeDao.findAll();
        if (!employees.isEmpty()) {
            return employees;
        }
        throw new RuntimeException("No employees found.");
    }

    @Override
    public Employee getEmployeeById(long employeeId) {
        Optional<Employee> optionalEmployee = employeeDao.findById(employeeId);
        if (optionalEmployee.isPresent()) {
            return optionalEmployee.get();
            
        }
        throw new RuntimeException("Employee not found with ID: " + employeeId);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    public Employee updateEmployee(long employeeId, Employee updatedEmployee) {
        if (employeeDao.existsById(employeeId)) {
            updatedEmployee.setId(employeeId); // Ensure the ID is set for the updated employee
            return employeeDao.saveAndFlush(updatedEmployee);
        }
        throw new RuntimeException("Employee not found with ID: " + employeeId);
    }

    @Override
    public boolean deleteEmployee(long employeeId) {
        if (employeeDao.existsById(employeeId)) {
            employeeDao.deleteById(employeeId);
            return true;
        }
        throw new RuntimeException("Employee not found with ID: " + employeeId);
    }
}
