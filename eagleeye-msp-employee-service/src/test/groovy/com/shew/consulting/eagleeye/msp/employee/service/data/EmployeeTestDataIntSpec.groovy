package com.shew.consulting.eagleeye.msp.employee.service.data

import com.shew.consulting.eagleeye.msp.employee.service.repository.EmployeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles('testData')
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class EmployeeTestDataIntSpec extends Specification {

    @Autowired
    EmployeeRepository employeeRepository

    def 'applicationReady'() {
        expect:
        employeeRepository.findAll().size() == 10
    }

}
