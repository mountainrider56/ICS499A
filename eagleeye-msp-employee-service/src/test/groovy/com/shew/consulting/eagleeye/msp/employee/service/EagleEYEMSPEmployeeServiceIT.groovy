package com.shew.consulting.eagleeye.msp.employee.service

import spock.lang.Specification

class EagleEYEMSPEmployeeServiceIT extends Specification {

    def 'app'() {
        expect:
        EagleEYEMSPEmployeeService.main()
    }

}
