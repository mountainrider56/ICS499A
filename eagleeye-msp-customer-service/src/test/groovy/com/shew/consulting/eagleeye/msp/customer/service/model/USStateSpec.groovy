package com.shew.consulting.eagleeye.msp.customer.service.model

import spock.lang.Specification

class USStateSpec extends Specification {

    def 'values'() {
        expect:
        USState.values().size() == 50
    }

}
