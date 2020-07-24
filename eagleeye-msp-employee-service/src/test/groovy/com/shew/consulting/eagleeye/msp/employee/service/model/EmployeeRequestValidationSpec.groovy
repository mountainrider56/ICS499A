package com.shew.consulting.eagleeye.msp.employee.service.model


import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.ConstraintViolation
import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

class EmployeeRequestValidationSpec extends Specification {

    EmployeeRequest employeeRequest
    Validator validator
    ValidatorFactory factory
    Set<ConstraintViolation<Employee>> constraintViolations

    def setup() {
        employeeRequest = new EmployeeRequest()
        factory = Validation.buildDefaultValidatorFactory()
        validator = factory.getValidator()
    }

    @Unroll
    def 'setUsername - #username'() {
        when:
        employeeRequest.username = username
        constraintViolations = validator.validateProperty(employeeRequest, 'username')

        then:
        constraintViolations.size() == errorSize
        constraintViolations.forEach({ i ->
            assert i.getMessage() == message
        })

        where:
        username   | message                | errorSize
        null       | 'Username is required' | 1
        ''         | 'Username is required' | 1
        ' '        | 'Username is required' | 1
        'username' | null                   | 0
    }

    @Unroll
    def 'setFirstName - #firstName'() {
        when:
        employeeRequest.firstName = firstName
        constraintViolations = validator.validateProperty(employeeRequest, 'firstName')

        then:
        constraintViolations.size() == errorSize
        constraintViolations.forEach({ i ->
            assert i.getMessage() == message
        })

        where:
        firstName | message                  | errorSize
        null      | 'First name is required' | 1
        ''        | 'First name is required' | 1
        ' '       | 'First name is required' | 1
        'name'    | null                     | 0
    }

    @Unroll
    def 'setLastName - #lastName'() {
        when:
        employeeRequest.lastName = lastName
        constraintViolations = validator.validateProperty(employeeRequest, 'lastName')

        then:
        constraintViolations.size() == errorSize
        constraintViolations.forEach({ i ->
            assert i.getMessage() == message
        })

        where:
        lastName | message                 | errorSize
        null     | 'Last name is required' | 1
        ''       | 'Last name is required' | 1
        ' '      | 'Last name is required' | 1
        'name'   | null                    | 0
    }

    @Unroll
    def 'setEmail - #email'() {
        when:
        employeeRequest.email = email
        constraintViolations = validator.validateProperty(employeeRequest, 'email')

        then:
        constraintViolations.size() == errorSize
        constraintViolations.forEach({ i ->
            assert i.getMessage() == message
        })

        where:
        email            | message                | errorSize
        null             | 'Email is required'    | 1
        ''               | 'Email is required'    | 1
        ' '              | 'Invalid email format' | 1
        'test'           | 'Invalid email format' | 1
        'test@gmail.com' | null                   | 0
    }

    @Unroll
    def 'setSecurityRole - #securityRole'() {
        when:
        employeeRequest.securityRole = securityRole
        constraintViolations = validator.validateProperty(employeeRequest, 'securityRole')

        then:
        constraintViolations.size() == errorSize
        constraintViolations.forEach({ i ->
            assert i.getMessage() == message
        })

        where:
        securityRole       | message                     | errorSize
        null               | 'Security role is required' | 1
        SecurityRole.ADMIN | null                        | 0
        SecurityRole.USER  | null                        | 0
    }

    @Unroll
    def 'setPassword - #password'() {
        when:
        employeeRequest.password = password
        constraintViolations = validator.validateProperty(employeeRequest, 'password')

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
