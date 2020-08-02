package com.shew.consulting.eagleeye.msp.employee.service.controllers;

import com.shew.consulting.eagleeye.msp.employee.service.model.Employee;
import com.shew.consulting.eagleeye.msp.employee.service.model.EmployeeSave;
import com.shew.consulting.eagleeye.msp.employee.service.model.EmployeeUpdate;
import com.shew.consulting.eagleeye.msp.employee.service.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Expose endpoints for the employee service.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("v1/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping
    public Employee saveEmployee(@Valid @RequestBody EmployeeSave employeeSave) {
        try {
            Employee employee = employeeSave.getEmployee();
            employee.setPassword(passwordEncoder.encode(employee.getPassword()));
            return employeeRepository.save(employee);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to save employee.");
        }
    }

    @PutMapping
    public Employee updateEmployee(@Valid @RequestBody EmployeeUpdate employeeUpdate) {
        try {
            Employee employee = employeeUpdate.getEmployee();
            Optional<Employee> saveEmployee = employeeRepository.findById(employee.getId());
            if (!saveEmployee.isPresent()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Employee is not existing.");
            }
            employee.setPassword(saveEmployee.get().getPassword());
            return employeeRepository.save(employee);
        } catch (Exception ex) {
            if (ex instanceof ResponseStatusException) {
                throw ex;
            }
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unable to update employee.");
        }
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("{employeeId}")
    public Employee getEmployee(@PathVariable Long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (employee.isPresent()) {
            return employee.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "employee not found: " + employeeId);
    }

    @GetMapping("/username")
    public Employee getEmployeeByUsername(@RequestBody String username) {
        Optional<Employee> employee = employeeRepository.findEmployeeByUsername(username);
        if (employee.isPresent()) {
            return employee.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "employee not found: " + username);
    }

    @DeleteMapping("{employeeId}")
    public boolean deleteEmployee(@PathVariable Long employeeId) {
        if (employeeRepository.existsById(employeeId)) {
            employeeRepository.deleteById(employeeId);
            return !employeeRepository.existsById(employeeId);
        } else {
            return false;
        }
    }

}
