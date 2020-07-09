package com.shew.consulting.eagleeye.msp.employee.service.repository;

import com.shew.consulting.eagleeye.msp.employee.service.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Create a repository for employee class.
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    List<Employee> findAll();

    Optional<Employee> findEmployeeByUsername(String username);



}
