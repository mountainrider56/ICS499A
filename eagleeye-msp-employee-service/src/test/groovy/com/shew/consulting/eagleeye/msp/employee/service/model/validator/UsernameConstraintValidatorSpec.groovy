package com.shew.consulting.eagleeye.msp.employee.service.model.validator

import com.shew.consulting.eagleeye.msp.employee.service.model.Employee
import com.shew.consulting.eagleeye.msp.employee.service.model.EmployeeUpdate
import com.shew.consulting.eagleeye.msp.employee.service.repository.EmployeeRepository
import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.ConstraintValidatorContext

class UsernameConstraintValidatorSpec extends Specification {

    @Unroll
    def 'isValid - #expected'() {
        setup:
        EmployeeRepository repository = Mock()
        UsernameConstraintValidator validator = new UsernameConstraintValidator()
        validator.setEmployeeRepository(repository)
        ConstraintValidatorContext context = Mock()
        ConstraintValidatorContext.ConstraintViolationBuilder builder = Mock()
        ConstraintValidatorContext.ConstraintViolationBuilder.NodeBuilderCustomizableContext nodeBuilder = Mock()

        when:
        boolean result = validator.isValid(employeeUpdate, context)

        then:
        if (!expected) {
            1 * context.buildConstraintViolationWithTemplate('{message}') >> builder
            1 * builder.addPropertyNode('username') >> nodeBuilder
        }
        if (employeeUpdate != null) {
            invocation * repository.findEmployeeByUsername(employeeUpdate.getUsername()) >> Optional.ofNullable(response)
        }
        expected == result

        where:
        expected | employeeUpdate                                  | response                                  | invocation
        true     | null                                            | null                                      | 0
        true     | new EmployeeUpdate(id: 1, username: null)       | null                                      | 0
        true     | new EmployeeUpdate(id: 1, username: '')         | null                                      | 0
        true     | new EmployeeUpdate(id: 1, username: 'username') | new Employee(id: 1, username: 'username') | 1
        true     | new EmployeeUpdate(id: 2, username: 'username') | null                                      | 1
        false    | new EmployeeUpdate(id: 2, username: 'username') | new Employee(id: 1, username: 'username') | 1
    }

}
