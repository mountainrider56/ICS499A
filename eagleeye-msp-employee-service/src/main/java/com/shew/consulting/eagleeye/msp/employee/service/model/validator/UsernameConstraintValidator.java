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
    public boolean isValid(EmployeeUpdate employeeUpdate, ConstraintValidatorContext context) {
        if (employeeUpdate == null || StringUtils.isEmpty(employeeUpdate.getUsername())) {
            return true;
        }
        Optional<Employee> employee = employeeRepository.findEmployeeByUsername(employeeUpdate.getUsername());
        boolean isValid = !employee.isPresent() || (employee.get().getId().equals(employeeUpdate.getId()));
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("{message}")
                   .addPropertyNode("username")
                   .addConstraintViolation();
        }
        return isValid;
    }

}
