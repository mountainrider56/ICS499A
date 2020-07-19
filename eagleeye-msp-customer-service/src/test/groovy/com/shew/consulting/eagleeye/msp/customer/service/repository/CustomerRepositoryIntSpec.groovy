package com.shew.consulting.eagleeye.msp.customer.service.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles("test")
class CustomerRepositoryIntSpec extends Specification {

    @Autowired
    CustomerRepository customerRepository

    def 'repository'() {
        expect:
        customerRepository // assert not null
    }

}
