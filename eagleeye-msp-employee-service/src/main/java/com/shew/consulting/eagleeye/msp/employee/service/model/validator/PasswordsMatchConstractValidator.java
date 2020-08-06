package com.shew.consulting.eagleeye.msp.employee.service.model.validator;

import com.shew.consulting.eagleeye.msp.employee.service.model.EmployeeSave;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Custom Hibernate validator that confirms that two passwords are the same.
 */
public class PasswordsMatchConstractValidator implements ConstraintValidator<MatchingPasswords, EmployeeSave> {

    @Override
    public boolean isValid(EmployeeSave employeeSave, ConstraintValidatorContext context) {
        if (employeeSave.getPassword() == null || employeeSave.getPassword2() == null) {
            return true;
        }
        PasswordConstraintValidator passwordConstraintValidator = new PasswordConstraintValidator();
        if (passwordConstraintValidator.isValid(employeeSave.getPassword(), null)) {
            boolean isValid = employeeSave.getPassword().equals(employeeSave.getPassword2());
            if (!isValid) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("{message}")
                       .addPropertyNode("password2")
                       .addConstraintViolation();
            }
            return isValid;
        }
        return true;
    }

}
