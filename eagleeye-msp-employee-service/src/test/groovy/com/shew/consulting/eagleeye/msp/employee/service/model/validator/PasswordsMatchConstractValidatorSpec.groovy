package com.shew.consulting.eagleeye.msp.employee.service.model.validator

import com.shew.consulting.eagleeye.msp.employee.service.model.EmployeeSave
import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.ConstraintValidatorContext

class PasswordsMatchConstractValidatorSpec extends Specification {

    @Unroll
    def 'isValid - #password/#password2'() {
        setup:
        ConstraintValidatorContext context = Mock()
        ConstraintValidatorContext.ConstraintViolationBuilder builder = Mock()
        ConstraintValidatorContext.ConstraintViolationBuilder.NodeBuilderCustomizableContext nodeBuilder = Mock()
        PasswordsMatchConstractValidator validator = new PasswordsMatchConstractValidator()
        EmployeeSave employeeSave = new EmployeeSave()
        employeeSave.password = password
        employeeSave.password2 = password2

        when:
        boolean response = validator.isValid(employeeSave, context)

        then:
        if (!expected) {
            1 * context.buildConstraintViolationWithTemplate("{message}") >> builder
            1 * builder.addPropertyNode("password2") >> nodeBuilder
        }
        response == expected

        where:
        expected | password       | password2
        true     | null           | null
        true     | null           | ''
        true     | ''             | null
        true     | ''             | ''
        true     | 'ssss'         | 'ssss'
        true     | 'ssa'          | 'sss'
        false    | 'Password11**' | 'Password12**'
    }

}
