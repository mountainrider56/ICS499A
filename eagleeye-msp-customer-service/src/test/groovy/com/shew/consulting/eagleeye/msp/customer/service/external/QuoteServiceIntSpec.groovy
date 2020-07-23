package com.shew.consulting.eagleeye.msp.customer.service.external

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class QuoteServiceIntSpec extends Specification {

    @Autowired
    QuoteService quoteService

    def 'restTemplate'() {
        expect:
        quoteService.restTemplate // not null

    }

    def 'quoteHost'() {
        expect:
        quoteService.quoteHost == 'http://localhost:8082'
    }

}
