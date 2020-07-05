package com.shew.consulting.eagleeye.msp.employee.service.model

import spock.lang.Specification

class SecurityRoleSpec extends Specification {

    def 'values'() {
        expect:
        SecurityRole.values().size() == 2
    }

}
