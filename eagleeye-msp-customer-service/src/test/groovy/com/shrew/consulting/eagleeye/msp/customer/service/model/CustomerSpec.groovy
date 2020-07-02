package com.shrew.consulting.eagleeye.msp.customer.service.model

import spock.lang.Specification

class CustomerSpec extends Specification {

    def 'customer creation'() {
        setup:
        Customer customer = new Customer(name: 'customer', telephone: '1234567890', address1: '1111 1st Ave.', address2: '', city: 'St. Paul', state: 'MN', zipcode: '55438')

        expect:
        customer // Confirm not null
        customer.id == 0
        customer.name == 'customer'
        customer.telephone == '1234567890'
        customer.address1 == '1111 1st Ave.'
        !customer.address2
        customer.city == 'St. Paul'
        customer.state == 'MN'
        customer.zipcode == '55438'
    }

}
