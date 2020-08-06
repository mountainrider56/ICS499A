package com.shew.consulting.eagleeye.msp.employee.service.data

import com.shew.consulting.eagleeye.msp.employee.service.controllers.EmployeeController
import com.shew.consulting.eagleeye.msp.employee.service.model.EmployeeSave
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

import javax.validation.ConstraintViolation
import javax.validation.ConstraintViolationException
import javax.validation.Validator

@SpringBootTest
@ActiveProfiles('test')
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class EmployeeTestDataSpec extends Specification {

    Validator validator
    EmployeeController employeeController
    EmployeeTestData employeeTestData

    def setup() {
        validator = Mock()
        employeeController = Mock()
        employeeTestData = new EmployeeTestData(employeeController, validator)
    }

    def 'applicationReady'() {
        setup:
        ApplicationReadyEvent event = Mock()
        Set<ConstraintViolation<EmployeeSave>> constraintViolationSet = new HashSet<>()
        ConstraintViolation<EmployeeSave> constraintViolation = Mock()
        constraintViolationSet.add(constraintViolation)

        when:
        employeeTestData.applicationReady(event)

        then:
        1 * validator.validate(_ as EmployeeSave) >> constraintViolationSet
        0 * employeeController.saveEmployee(_ as EmployeeSave)
        thrown(ConstraintViolationException)
    }

}
