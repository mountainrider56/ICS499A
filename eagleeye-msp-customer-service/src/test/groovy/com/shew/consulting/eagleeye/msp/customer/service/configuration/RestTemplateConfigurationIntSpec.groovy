package com.shew.consulting.eagleeye.msp.customer.service.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

@SpringBootTest
class RestTemplateConfigurationIntSpec extends Specification {

    @Autowired
    RestTemplate restTemplate

    def 'restTemplate'() {
        expect:
        restTemplate // not null
    }

}
