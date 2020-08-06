package com.shew.consulting.eagleeye.msp.employee.service.model.jwttoken

import spock.lang.Specification
import spock.lang.Unroll

class JwtResponseSpec extends Specification {

    @Unroll
    def 'response save creation'() {
        when:
        JwtResponse response = new JwtResponse(token: 'TOKEN')

        then:
        response.token == 'TOKEN'
    }

}
