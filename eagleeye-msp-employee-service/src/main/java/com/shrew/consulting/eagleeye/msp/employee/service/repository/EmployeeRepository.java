package com.shrew.consulting.eagleeye.msp.employee.service.repository;

import com.shrew.consulting.eagleeye.msp.employee.service.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
