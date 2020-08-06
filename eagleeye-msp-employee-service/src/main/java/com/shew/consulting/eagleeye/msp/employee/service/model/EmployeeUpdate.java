package com.shew.consulting.eagleeye.msp.employee.service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shew.consulting.eagleeye.msp.employee.service.model.validator.UniqueUsername;

import javax.validation.constraints.*;

/**
 * A employee class specifically oriented for updating an employee without password.
 */
@UniqueUsername
@JsonIgnoreProperties(ignoreUnknown=true)
public class EmployeeUpdate extends Employee {

    @Override
    @NotBlank(message = "Username is required")
    @Size(max = 15, message = "Username must be equal to or less than 15 characters")
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    @NotBlank(message = "First name is required")
    @Size(max = 30, message = "First name must be equal to or less than 30 characters")
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    @NotBlank(message = "Last name is required")
    @Size(max = 30, message = "Last name must be equal to or less than 30 characters")
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    @Email(message = "Invalid email format")
    @NotEmpty(message = "Email is required")
    @Size(max = 50, message = "Email must be equal to or less than 50 characters")
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    @NotNull(message = "Security role is required")
    public SecurityRole getSecurityRole() {
        return super.getSecurityRole();
    }

    @Override
    @NotNull(message = "Account status is required")
    public AccountStatus getAccountStatus() {
        return super.getAccountStatus();
    }

    public Employee getEmployee() {
        Employee employee = new Employee();
        employee.setId(getId());
        employee.setUsername(getUsername());
        employee.setFirstName(getFirstName());
        employee.setLastName(getLastName());
        employee.setEmail(getEmail());
        employee.setSecurityRole(getSecurityRole());
        employee.setPassword(getPassword());
        employee.setAccountStatus(getAccountStatus());
        return employee;
    }

}
