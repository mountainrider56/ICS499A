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
class EmployeeSaveValidationIntSpec extends Specification {

    @Autowired
    Validator validator

    @Autowired
    EmployeeRepository employeeRepository

    EmployeeSave employeeSave
    Set<ConstraintViolation<Employee>> constraintViolations

    def setup() {
        employeeSave = new EmployeeSave()
    }

    @Unroll
    def 'matching passwords - #password/#password2'() {
        setup:
        employeeSave.id = 1
        employeeSave.username = 'username'
        employeeSave.firstName = 'first'
        employeeSave.lastName = 'last'
        employeeSave.email = 'test@gmail.com'
        employeeSave.securityRole = SecurityRole.USER
        employeeSave.password = password
        employeeSave.password2 = password2

        when:
        constraintViolations = validator.validate(employeeSave)

        then:
        constraintViolations.size() == errorSize
        constraintViolations.forEach({ i ->
            assert i.getMessage() == message
        })

        where:
        password       | password2      | errorSize | message
        'ssss'         | 'sssa'         | 1         | 'Password must be 8 or more characters in length'
        'Password11**' | 'Password12**' | 1         | 'Passwords do not match'
    }


}
