package com.shew.consulting.eagleeye.msp.customer.service.data

import com.shew.consulting.eagleeye.msp.customer.service.controllers.CustomerController
import com.shew.consulting.eagleeye.msp.customer.service.model.Customer
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
class CustomerTestDataSpec extends Specification {

    Validator validator
    CustomerController customerController
    CustomerTestData customerTestData

    def setup() {
        validator = Mock()
        customerController = Mock()
        customerTestData = new CustomerTestData(customerController, validator)
    }

    def 'applicationReady'() {
        setup:
        ApplicationReadyEvent event = Mock()
        Set<ConstraintViolation<Customer>> constraintViolationSet = new HashSet<>()
        ConstraintViolation<Customer> constraintViolation = Mock()
        constraintViolationSet.add(constraintViolation)

        when:
        customerTestData.applicationReady(event)

        then:
        1 * validator.validate(_ as Customer) >> constraintViolationSet
        0 * customerController.saveCustomer(_ as Customer)
        thrown(ConstraintViolationException)
    }

}
