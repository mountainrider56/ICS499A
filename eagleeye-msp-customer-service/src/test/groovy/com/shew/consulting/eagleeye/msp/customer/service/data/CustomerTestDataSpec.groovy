package com.shew.consulting.eagleeye.msp.customer.service.data

import com.shew.consulting.eagleeye.msp.customer.service.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles('testData')
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class CustomerTestDataSpec extends Specification {

    @Autowired
    CustomerRepository customerRepository

    def 'applicationReady'() {
        expect:
        customerRepository.findAll().size() == 10
    }

}
