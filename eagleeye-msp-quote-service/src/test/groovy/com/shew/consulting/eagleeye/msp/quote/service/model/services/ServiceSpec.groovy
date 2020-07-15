package com.shew.consulting.eagleeye.msp.quote.service.model.services

import spock.lang.Specification

class ServiceSpec extends Specification {

    def 'service'() {
        setup:
        Service service = new Service(id, title, price)

        expect:
        service // not null
        service.id == id
        service.title == title
        service.price == price

        where:
        id    | title   | price
        'id0' | 'test'  | 0 as double
        'id1' | 'test1' | 10.5 as double
    }

    def 'service - no arg constructor'() {
        setup:
        Service service = new Service()

        expect:
        service // not null
    }

}
