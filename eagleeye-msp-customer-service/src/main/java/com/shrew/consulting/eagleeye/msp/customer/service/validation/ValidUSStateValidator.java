package com.shrew.consulting.eagleeye.msp.customer.service.validation;

import com.shrew.consulting.eagleeye.msp.customer.service.model.USState;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Custom validation for a string to an US state.
 */
public class ValidUSStateValidator implements ConstraintValidator<ValidUSState, String> {

    @Override
    public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {
        if (string == null) {
            return true;
        }
        try {
            USState.valueOf(string);
        } catch (Exception exception) {
            return false;
        }
        return true;
    }

}
