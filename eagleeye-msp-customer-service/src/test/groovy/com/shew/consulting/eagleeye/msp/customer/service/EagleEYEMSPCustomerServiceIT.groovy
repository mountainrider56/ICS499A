package com.shew.consulting.eagleeye.msp.customer.service

import spock.lang.Specification

class EagleEYEMSPCustomerServiceIT extends Specification {

    def 'app'() {
        expect:
        EagleEYEMSPCustomerService.main()
    }

}
