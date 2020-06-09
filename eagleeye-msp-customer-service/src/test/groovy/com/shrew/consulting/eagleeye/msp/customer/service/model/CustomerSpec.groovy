package com.shrew.consulting.eagleeye.msp.customer.service.model

import spock.lang.Specification

class CustomerSpec extends Specification {

    def 'client creation'() {
        setup:
        Customer client = new Customer(name: 'customer', telephone: '1234567890', address1: '1111 1st Ave.', address2: '', city: 'St. Paul', state: 'MN', zipcode: '55438')

        expect:
        client // Confirm not null
        client.id == 0
        client.name == 'customer'
        client.telephone == '1234567890'
        client.address1 == '1111 1st Ave.'
        !client.address2
        client.city == 'St. Paul'
        client.state == 'MN'
        client.zipcode == '55438'
    }

}
