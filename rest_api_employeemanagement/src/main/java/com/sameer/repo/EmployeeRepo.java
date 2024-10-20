package com.sameer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sameer.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
