package com.shew.consulting.eagleeye.msp.customer.service.validation


import spock.lang.Specification
import spock.lang.Unroll

class ValidUSStateValidatorSpec extends Specification {

    @Unroll
    def 'isValid'() {
        setup:
        ValidUSStateValidator validator = new ValidUSStateValidator()

        expect:
        expected == validator.isValid(state, null)

        where:
        state  | expected
        null   | true
        ''     | false
        'test' | false
        'MN'   | true
        'NY'   | true
        'AA'   | false
    }

}
