package com.shew.consulting.eagleeye.msp.quote.service.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles("test")
class ServiceRespositoryIT extends Specification {

    @Autowired
    ServiceRespository serviceRespository

    def 'repository'() {
        expect:
        serviceRespository // assert not null
    }

}
