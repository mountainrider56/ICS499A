package com.shew.consulting.eagleeye.msp.employee.service.model

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.ConstraintViolation
import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

@SpringBootTest
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class EmployeeUpdateValidationSpec extends Specification {

    EmployeeUpdate employeeUpdate
    Validator validator
    ValidatorFactory factory
    Set<ConstraintViolation<Employee>> constraintViolations

    def setup() {
        employeeUpdate = new EmployeeUpdate()
        factory = Validation.buildDefaultValidatorFactory()
        validator = factory.getValidator()
    }

    @Unroll
    def 'setUsername - #username'() {
        when:
        employeeUpdate.username = username
        constraintViolations = validator.validateProperty(employeeUpdate, 'username')

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
        employeeUpdate.firstName = firstName
        constraintViolations = validator.validateProperty(employeeUpdate, 'firstName')

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
        employeeUpdate.lastName = lastName
        constraintViolations = validator.validateProperty(employeeUpdate, 'lastName')

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
        employeeUpdate.email = email
        constraintViolations = validator.validateProperty(employeeUpdate, 'email')

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
        employeeUpdate.securityRole = securityRole
        constraintViolations = validator.validateProperty(employeeUpdate, 'securityRole')

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

}
