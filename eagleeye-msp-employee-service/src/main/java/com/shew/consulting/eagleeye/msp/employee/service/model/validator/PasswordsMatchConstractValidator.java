package com.shew.consulting.eagleeye.msp.employee.service.model.validator;

import com.shew.consulting.eagleeye.msp.employee.service.model.EmployeeSave;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordsMatchConstractValidator implements ConstraintValidator<MatchingPasswords, EmployeeSave> {

    @Override
    public boolean isValid(EmployeeSave employeeSave, ConstraintValidatorContext constraintValidatorContext) {
        if (employeeSave.getPassword() == null || employeeSave.getPassword2() == null) {
            return true;
        }
        PasswordConstraintValidator passwordConstraintValidator = new PasswordConstraintValidator();
        if (passwordConstraintValidator.isValid(employeeSave.getPassword(), null)) {
            return employeeSave.getPassword().equals(employeeSave.getPassword2());
        }
        return true;
    }

}
