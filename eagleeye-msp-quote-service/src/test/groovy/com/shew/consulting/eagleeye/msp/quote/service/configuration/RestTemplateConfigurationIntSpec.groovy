package com.shew.consulting.eagleeye.msp.quote.service.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles('test')
class RestTemplateConfigurationIntSpec extends Specification {

    @Autowired
    RestTemplate restTemplate

    def 'restTemplate'() {
        expect:
        restTemplate // not null
    }

}
