package com.shew.consulting.eagleeye.msp.employee.service.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles("test")
class EmployeeRepositorySpec extends Specification {

    @Autowired
    EmployeeRepository employeeRepository

    def 'repository'() {
        expect:
        employeeRepository // assert not null
    }

}
