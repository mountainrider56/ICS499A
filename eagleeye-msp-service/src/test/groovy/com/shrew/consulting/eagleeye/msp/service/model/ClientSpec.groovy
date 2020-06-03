package com.shrew.consulting.eagleeye.msp.service.model

import spock.lang.Specification

class ClientSpec extends Specification {

    def 'client creation'() {
        setup:
        Client client = new Client(firstName: 'Test', lastName: 'User')

        expect:
        client // Confirm not null
        client.firstName == 'Test'
        client.lastName == 'User'
    }

}
