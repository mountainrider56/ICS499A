package com.shew.consulting.eagleeye.msp.employee.service.model

import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.ConstraintViolation
import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

class EmployeeSaveValidationSpec extends Specification {

    EmployeeSave employeeSave
    Validator validator
    ValidatorFactory factory
    Set<ConstraintViolation<Employee>> constraintViolations

    def setup() {
        employeeSave = new EmployeeSave()
        factory = Validation.buildDefaultValidatorFactory()
        validator = factory.getValidator()
    }

    @Unroll
    def 'setPassword - #password'() {
        when:
        employeeSave.password = password
        constraintViolations = validator.validateProperty(employeeSave, 'password')

        then:
        constraintViolations.size() == errorSize
        constraintViolations.forEach({ i ->
            assert i.getMessage() == message
        })

        where:
        password                | message                                                 | errorSize
        null                    | 'Password is required'                                  | 1
        ''                      | 'Password is required'                                  | 1
        ' '                     | 'Password must be 8 or more characters in length'       | 1
        '1111 1111'             | 'Password contains a whitespace character'              | 1
        '11111111'              | 'Password must contain 1 or more uppercase characters'  | 1
        'A1111111'              | 'Password must contain 2 or more special characters'    | 1
        'A**aaaaa'              | 'Password must contain 2 or more digit characters'      | 1
        'A11**aaaaaaaaaaaaaaaa' | 'Password must be no more than 15 characters in length' | 1
        'A11**aaaaaaaaaa'       | 'Password matches the illegal pattern \'aaa\''          | 1
        'A11**asdert'           | null                                                    | 0
    }

}
