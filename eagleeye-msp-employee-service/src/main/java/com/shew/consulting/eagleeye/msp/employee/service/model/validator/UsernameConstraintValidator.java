package com.shew.consulting.eagleeye.msp.employee.service.model.validator;

import com.shew.consulting.eagleeye.msp.employee.service.model.Employee;
import com.shew.consulting.eagleeye.msp.employee.service.model.EmployeeRequest;
import com.shew.consulting.eagleeye.msp.employee.service.repository.EmployeeRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Setter
public class UsernameConstraintValidator implements ConstraintValidator<UniqueUsername, EmployeeRequest> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public boolean isValid(EmployeeRequest employeeRequest, ConstraintValidatorContext constraintValidatorContext) {
        if (employeeRequest == null || StringUtils.isEmpty(employeeRequest.getUsername())) {
            return true;
        }
        Optional<Employee> employee = employeeRepository.findEmployeeByUsername(employeeRequest.getUsername());
        return !employee.isPresent() || (employee.get().getId().equals(employeeRequest.getId()));
    }

}
