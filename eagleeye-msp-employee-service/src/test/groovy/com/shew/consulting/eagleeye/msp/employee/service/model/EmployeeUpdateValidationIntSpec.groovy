package com.shew.consulting.eagleeye.msp.employee.service.model

import com.shew.consulting.eagleeye.msp.employee.service.repository.EmployeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.ConstraintViolation
import javax.validation.Validator

@SpringBootTest
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class EmployeeUpdateValidationIntSpec extends Specification {

    @Autowired
    Validator validator

    @Autowired
    EmployeeRepository employeeRepository

    EmployeeUpdate employeeUpdate
    Set<ConstraintViolation<Employee>> constraintViolations

    def setup() {
        employeeUpdate = new EmployeeUpdate()
    }

    @Unroll
    def 'unique username - #username'() {
        setup:
        employeeRepository.save(getEmployee1())
        employeeRepository.save(getEmployee2())

        when:
        employeeUpdate.id = 2
        employeeUpdate.username = username
        employeeUpdate.firstName = 'first'
        employeeUpdate.lastName = 'last'
        employeeUpdate.email = 'test@gmail.com'
        employeeUpdate.password = 'Password11**'
        employeeUpdate.securityRole = SecurityRole.USER
        constraintViolations = validator.validate(employeeUpdate)

        then:
        constraintViolations.size() == errorSize
        constraintViolations.forEach({ i ->
            assert i.getMessage() == message
        })

        where:
        username    | message                  | errorSize
        null        | 'Username is required'   | 1
        ''          | 'Username is required'   | 1
        ' '         | 'Username is required'   | 1
        'username'  | null                     | 0
        'username1' | 'Username already taken' | 1
        'username2' | null                     | 0
    }

    def getEmployee1() {
        Employee employee = new Employee()
        employee.username = 'username1'
        employee.firstName = 'firstName1'
        employee.password = 'Password11**'
        employee.lastName = 'lastName1'
        employee.securityRole = SecurityRole.USER
        employee.email = 'employee1@gmail.com'

        employee
    }

    def getEmployee2() {
        Employee employee = new Employee()
        employee.username = 'username2'
        employee.firstName = 'firstName2'
        employee.password = 'Password11**'
        employee.lastName = 'lastName2'
        employee.securityRole = SecurityRole.ADMIN
        employee.email = 'employee2@gmail.com'

        employee
    }

}
