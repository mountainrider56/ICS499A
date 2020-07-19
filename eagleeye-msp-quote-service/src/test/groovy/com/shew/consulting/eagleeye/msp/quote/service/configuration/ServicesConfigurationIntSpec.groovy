package com.shew.consulting.eagleeye.msp.quote.service.configuration

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles('test')
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ServicesConfigurationIntSpec extends Specification {

    @Autowired
    Map<String, Service> services

    def 'services'() {
        expect:
        services.size() == 101
    }

}
