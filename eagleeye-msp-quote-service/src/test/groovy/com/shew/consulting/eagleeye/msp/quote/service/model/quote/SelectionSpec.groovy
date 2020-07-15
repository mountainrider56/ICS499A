package com.shew.consulting.eagleeye.msp.quote.service.model.quote

import spock.lang.Specification

class SelectionSpec extends Specification {

    def 'selection'() {
        setup:
        Selection selection = new Selection(id, quantity)

        expect:
        selection // not null
        selection.id == id
        selection.quantity == quantity

        where:
        id | quantity
        0  | 1
        2  | 2
    }

}
