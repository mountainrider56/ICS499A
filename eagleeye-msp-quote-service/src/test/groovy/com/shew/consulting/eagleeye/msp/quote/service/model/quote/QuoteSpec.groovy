package com.shew.consulting.eagleeye.msp.quote.service.model.quote

import spock.lang.Specification

import java.time.Instant

class QuoteSpec extends Specification {

    def 'quote'() {
        setup:
        Quote quote = new Quote(id, customerId, selections, total, timestamp)

        expect:
        quote // not null
        quote.id == id
        quote.customerId == customerId
        quote.selections == selections
        quote.total == total
        quote.timestamp == timestamp

        where:
        id | customerId | selections                 | total | timestamp
        0  | 0          | [:]                        | 0     | null
        0  | 1          | ['0': new Selection(0, 1)] | 1     | Instant.now()
    }

}
