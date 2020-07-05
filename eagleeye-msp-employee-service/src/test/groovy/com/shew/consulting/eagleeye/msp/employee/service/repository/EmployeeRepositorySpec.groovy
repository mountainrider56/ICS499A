package com.shew.consulting.eagleeye.msp.employee.service.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class EmployeeRepositorySpec extends Specification {

    @Autowired
    EmployeeRepository employeeRepository

    def 'repository'() {
        expect:
        employeeRepository // assert not null
    }

}
