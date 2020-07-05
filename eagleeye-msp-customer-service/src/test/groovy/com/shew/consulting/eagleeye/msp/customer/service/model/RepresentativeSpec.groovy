package com.shew.consulting.eagleeye.msp.customer.service.model


import spock.lang.Specification

class RepresentativeSpec extends Specification {

    def 'representative'() {
        setup:
        Representative representative = new Representative(0, 'first', 'last', '1234567890', 'test@gmail.com')

        expect:
        representative.id == 0
        representative.firstName == 'first'
        representative.lastName == 'last'
        representative.telephone == '1234567890'
        representative.email == 'test@gmail.com'
    }

}
