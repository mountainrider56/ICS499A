package com.shew.consulting.eagleeye.msp.employee.service.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

import javax.validation.Validator

@SpringBootTest
class ValidatorConfigurationSpec extends Specification {

    @Autowired
    Validator validatorFactory

    def 'validator'() {
        expect:
        validatorFactory // not null
    }

}
