package com.shew.consulting.eagleeye.msp.customer.service.model


import spock.lang.Specification

class CustomerSpec extends Specification {

    def 'customer'() {
        setup:
        Customer customer = new Customer(0, 'customer', '1234567890', 'test@gmail.com', '1111 1st Ave.', null, 'St. Paul', USState.MN, '55438', null)

        expect:
        customer // Confirm not null
        customer.id == 0
        customer.name == 'customer'
        customer.email == 'test@gmail.com'
        customer.telephone == '1234567890'
        customer.address1 == '1111 1st Ave.'
        !customer.address2
        customer.city == 'St. Paul'
        customer.state == USState.MN
        customer.zipcode == '55438'
        !customer.representative
    }

}
