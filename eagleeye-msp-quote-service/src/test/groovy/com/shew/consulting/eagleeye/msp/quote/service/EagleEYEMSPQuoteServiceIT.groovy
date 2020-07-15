package com.shew.consulting.eagleeye.msp.quote.service

import spock.lang.Specification

class EagleEYEMSPQuoteServiceIT extends Specification {

    def 'app'() {
        expect:
        EagleEYEMSPQuoteService.main()
    }

}
