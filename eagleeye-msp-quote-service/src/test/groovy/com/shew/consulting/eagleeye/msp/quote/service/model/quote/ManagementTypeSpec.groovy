package com.shew.consulting.eagleeye.msp.quote.service.model.quote

import spock.lang.Specification

class ManagementTypeSpec extends Specification {

    def 'values'() {
        expect:
        ManagementType.values().size() == 3
    }

}
