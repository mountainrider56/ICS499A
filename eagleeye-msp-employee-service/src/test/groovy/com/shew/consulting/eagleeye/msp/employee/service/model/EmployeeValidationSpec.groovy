package com.shew.consulting.eagleeye.msp.employee.service.model


import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.ConstraintViolation
import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

class EmployeeValidationSpec extends Specification {

    Employee employee
    Validator validator
    ValidatorFactory factory
    Set<ConstraintViolation<Employee>> constraintViolations

    void setup() {
        employee = new Employee()
        factory = Validation.buildDefaultValidatorFactory()
        validator = factory.getValidator()
    }

    @Unroll
    def 'setUsername - #username'() {
        when:
        employee.username = username
        constraintViolations = validator.validateProperty(employee, 'username')

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
        employee.firstName = firstName
        constraintViolations = validator.validateProperty(employee, 'firstName')

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
        employee.lastName = lastName
        constraintViolations = validator.validateProperty(employee, 'lastName')

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
        employee.email = email
        constraintViolations = validator.validateProperty(employee, 'email')

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
        employee.securityRole = securityRole
        constraintViolations = validator.validateProperty(employee, 'securityRole')

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
        employee.password = password
        constraintViolations = validator.validateProperty(employee, 'password')

        then:
        constraintViolations.size() == errorSize
        constraintViolations.forEach({ i ->
            assert i.getMessage() == message
        })

        where:
        password | message                | errorSize
        null     | 'Password is required' | 1
        ''       | 'Password is required' | 1
        ' '      | 'Password is required' | 1
        'name'   | null                   | 0
    }

}
