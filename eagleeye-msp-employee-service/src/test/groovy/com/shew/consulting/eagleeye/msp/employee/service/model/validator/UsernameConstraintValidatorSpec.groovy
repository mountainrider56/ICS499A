package com.shew.consulting.eagleeye.msp.employee.service.model.validator

import com.shew.consulting.eagleeye.msp.employee.service.model.Employee
import com.shew.consulting.eagleeye.msp.employee.service.model.EmployeeRequest
import com.shew.consulting.eagleeye.msp.employee.service.repository.EmployeeRepository
import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.ConstraintValidatorContext

class UsernameConstraintValidatorSpec extends Specification {

    @Unroll
    def 'isValid'() {
        setup:
        EmployeeRepository repository = Mock()
        UsernameConstraintValidator validator = new UsernameConstraintValidator()
        validator.setEmployeeRepository(repository)
        ConstraintValidatorContext context = Mock()

        when:
        boolean result = validator.isValid(employeeRequest, context)

        then:
        if (employeeRequest != null) {
            invocation * repository.findEmployeeByUsername(employeeRequest.getUsername()) >> Optional.ofNullable(response)
        }
        expected == result

        where:
        expected | employeeRequest                                  | response                                  | invocation
        true     | null                                             | null                                      | 0
        true     | new EmployeeRequest(id: 1, username: null)       | null                                      | 0
        true     | new EmployeeRequest(id: 1, username: '')         | null                                      | 0
        true     | new EmployeeRequest(id: 1, username: 'username') | new Employee(id: 1, username: 'username') | 1
        true     | new EmployeeRequest(id: 2, username: 'username') | null                                      | 1
        false    | new EmployeeRequest(id: 2, username: 'username') | new Employee(id: 1, username: 'username') | 1
    }

}
