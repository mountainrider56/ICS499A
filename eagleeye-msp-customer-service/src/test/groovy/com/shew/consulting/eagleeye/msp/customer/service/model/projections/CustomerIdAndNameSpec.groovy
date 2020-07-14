package com.shew.consulting.eagleeye.msp.customer.service.model.projections

import spock.lang.Specification

class CustomerIdAndNameSpec extends Specification {

    def 'create CustomerIdAndName'() {
        setup:
        CustomerIdAndName customerIdAndName = new CustomerIdAndNameClass()

        expect:
        customerIdAndName
        customerIdAndName.getId() == 1
        customerIdAndName.getName() == 'name'
    }

    class CustomerIdAndNameClass implements CustomerIdAndName {

        @Override
        Long getId() {
            return 1
        }

        @Override
        String getName() {
            return 'name'
        }

    }

}
