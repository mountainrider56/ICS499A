package com.shew.consulting.eagleeye.msp.employee.service.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles("test")
class PasswordEncoderConfigurationIntSpec extends Specification {

    @Autowired
    PasswordEncoder passwordEncoder

    def 'passwordEncoder'() {
        expect:
        passwordEncoder // not null
    }

}
