package com.shew.consulting.eagleeye.msp.employee.service.model.validator

import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.ConstraintValidatorContext

class PasswordConstraintValidatorSpec extends Specification {

    @Unroll
    def 'isValid - #password'() {
        setup:
        PasswordConstraintValidator validator = new PasswordConstraintValidator()
        ConstraintValidatorContext context = Mock()
        ConstraintValidatorContext.ConstraintViolationBuilder builder = Mock()

        when:
        boolean response = validator.isValid(password, context)

        then:
        if (!expected) {
            1 * context.buildConstraintViolationWithTemplate(message) >> builder
        }
        response == expected

        where:
        expected | password                | message
        true     | null                    | null
        true     | ''                      | null
        false    | ' '                     | 'Password must be 8 or more characters in length'
        false    | '1111 1111'             | 'Password contains a whitespace character'
        false    | '11111111'              | 'Password must contain 1 or more uppercase characters'
        false    | 'A1111111'              | 'Password must contain 2 or more special characters'
        false    | 'A**aaaaa'              | 'Password must contain 2 or more digit characters'
        false    | 'A11**aaaaaaaaaaaaaaaa' | 'Password must be no more than 15 characters in length'
        false    | 'A11**aaaaaaaaaa'       | 'Password matches the illegal pattern \'aaa\''
        true     | 'A11**asdert'           | null
    }

    @Unroll
    def 'isValid - null context - #password'() {
        setup:
        PasswordConstraintValidator validator = new PasswordConstraintValidator()
        ConstraintValidatorContext context = null

        when:
        boolean response = validator.isValid(password, context)

        then:
        0 * context.buildConstraintViolationWithTemplate(_ as String)
        response == expected

        where:
        expected | password
        true     | 'Password11**'
        false    | 'pasdasd'
    }

}
