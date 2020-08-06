package com.shew.consulting.eagleeye.msp.employee.service.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

import java.time.Clock

@SpringBootTest
@ActiveProfiles('test')
class JwtConfigurationSpec extends Specification {

    @Autowired
    Clock clock

    @Autowired
    String jwtSecret

    def 'clock'() {
        expect:
        clock == Clock.systemDefaultZone()
    }

    def 'jwtSecret'() {
        expect:
        jwtSecret == 'javainuse'
    }

}
