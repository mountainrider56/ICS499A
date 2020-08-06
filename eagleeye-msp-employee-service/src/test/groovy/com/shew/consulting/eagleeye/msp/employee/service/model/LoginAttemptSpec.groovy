package com.shew.consulting.eagleeye.msp.employee.service.model

import spock.lang.Specification

class LoginAttemptSpec extends Specification {

    def 'login attempt creation'() {
        setup:
        Long employeeId = 2
        int attempt = 1
        LoginAttempt loginAttempt = new LoginAttempt(employeeId, attempt)

        expect:
        loginAttempt.employeeId == employeeId
        loginAttempt.attempt == attempt
    }

}
