package com.shew.consulting.eagleeye.msp.customer.service.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class CustomerRepositorySpec extends Specification {

    @Autowired
    CustomerRepository customerRepository

    def 'repository'() {
        expect:
        customerRepository // assert not null
    }

}
