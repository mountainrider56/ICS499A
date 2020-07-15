package com.shew.consulting.eagleeye.msp.quote.service.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles("test")
class QuoteRepositoryIT extends Specification {

    @Autowired
    QuoteRepository quoteRepository

    def 'repository'() {
        expect:
        quoteRepository // assert not null
    }

}
