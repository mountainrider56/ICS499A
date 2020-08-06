package com.shew.consulting.eagleeye.msp.employee.service.model.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Constraint interface for matching passwords.
 */
@Documented
@Constraint(validatedBy = PasswordsMatchConstractValidator.class)
@Target({TYPE})
@Retention(RUNTIME)
public @interface MatchingPasswords {

    String message() default "Passwords do not match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
