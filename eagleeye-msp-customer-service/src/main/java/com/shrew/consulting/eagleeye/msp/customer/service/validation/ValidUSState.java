package com.shrew.consulting.eagleeye.msp.customer.service.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom custom constraint for a US state.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
@Constraint(validatedBy = ValidUSStateValidator.class)
public @interface ValidUSState {
    String message() default "Invalid US state";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
