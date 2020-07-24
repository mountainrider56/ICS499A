package com.shew.consulting.eagleeye.msp.employee.service.model.validator;

import org.passay.*;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (StringUtils.isEmpty(password)) {
            return true;
        }
        PasswordValidator validator = new PasswordValidator(Arrays.asList(
                new LengthRule(8, 15),
                new WhitespaceRule(),
                new CharacterRule(EnglishCharacterData.UpperCase, 1),
                new CharacterRule(EnglishCharacterData.Special, 2),
                new CharacterRule(EnglishCharacterData.Digit, 2),
                new RepeatCharacterRegexRule(3)));
        RuleResult result = validator.validate(new PasswordData(password));
        if (result.isValid()) {
            return true;
        }
        context.disableDefaultConstraintViolation();
        String message = validator.getMessages(result).get(0).replaceAll("\\.", "");
        context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
        return false;
    }

}
