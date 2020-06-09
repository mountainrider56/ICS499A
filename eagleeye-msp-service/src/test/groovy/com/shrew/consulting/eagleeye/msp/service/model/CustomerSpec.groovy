package com.shrew.consulting.eagleeye.msp.service.model

import spock.lang.Specification

class ClientSpec extends Specification {

    def 'client creation'() {
        setup:
        Customer client = new Customer(firstName: 'Test', lastName: 'User')

        expect:
        client // Confirm not null
        client.firstName == 'Test'
        client.lastName == 'User'
    }

}
