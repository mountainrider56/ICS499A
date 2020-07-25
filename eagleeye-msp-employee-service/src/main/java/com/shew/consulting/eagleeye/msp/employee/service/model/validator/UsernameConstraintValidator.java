package com.shew.consulting.eagleeye.msp.employee.service.model.validator;

import com.shew.consulting.eagleeye.msp.employee.service.model.Employee;
import com.shew.consulting.eagleeye.msp.employee.service.model.EmployeeUpdate;
import com.shew.consulting.eagleeye.msp.employee.service.repository.EmployeeRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Setter
public class UsernameConstraintValidator implements ConstraintValidator<UniqueUsername, EmployeeUpdate> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public boolean isValid(EmployeeUpdate employeeUpdate, ConstraintValidatorContext constraintValidatorContext) {
        if (employeeUpdate == null || StringUtils.isEmpty(employeeUpdate.getUsername())) {
            return true;
        }
        Optional<Employee> employee = employeeRepository.findEmployeeByUsername(employeeUpdate.getUsername());
        return !employee.isPresent() || (employee.get().getId().equals(employeeUpdate.getId()));
    }

}
