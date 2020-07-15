package com.shew.consulting.eagleeye.msp.quote.service.data

import com.shew.consulting.eagleeye.msp.quote.service.repository.QuoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles('testData')
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class QuoteTestDataIT extends Specification {

    @Autowired
    QuoteRepository quoteRepository

    def 'applicationReady'() {
        expect:
        quoteRepository.findAll().size() == 10
    }

}
