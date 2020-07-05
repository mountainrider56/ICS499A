package com.shew.consulting.eagleeye.msp.employee.service.controllers;

import com.shew.consulting.eagleeye.msp.employee.service.model.Employee;
import com.shew.consulting.eagleeye.msp.employee.service.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Expose endpoints for the employee service.
 */
@RestController
@RequestMapping("v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @PutMapping
    public Employee saveEmployee(@Valid @RequestBody Employee employee) {
        try {
            return employeeRepository.save(employee);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unable to save employee: " + ex.getMessage());
        }
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("{employeeId}")
    public Employee getEmployee(@PathVariable long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (employee.isPresent()) {
            return employee.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "employee not found: " + employeeId);
    }

    @PostMapping("/username")
    public Employee getEmployeeByUsername(@RequestBody String username) {
        Optional<Employee> employee = employeeRepository.findEmployeeByUsername(username);
        if (employee.isPresent()) {
            return employee.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "employee not found: " + username);
    }

}
