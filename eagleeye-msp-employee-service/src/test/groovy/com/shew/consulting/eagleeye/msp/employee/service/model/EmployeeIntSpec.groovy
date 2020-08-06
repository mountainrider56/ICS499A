package com.shew.consulting.eagleeye.msp.employee.service.model

import com.shew.consulting.eagleeye.msp.employee.service.repository.EmployeeRepository
import net.bytebuddy.utility.RandomString
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles('test')
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class EmployeeIntSpec extends Specification {

    @Autowired
    EmployeeRepository employeeRepository

    def 'setUsername - length constraint'() {
        setup:
        Employee employee = new Employee(id: 1, username: RandomString.make(16))

        when:
        employeeRepository.save(employee)

        then:
        thrown(DataIntegrityViolationException)
    }

    def 'setUsername - unique constraint'() {
        setup:
        String username = RandomString.make(15)
        Employee employee1 = new Employee(id: 1, username: username)
        Employee employee2 = new Employee(id: 2, username: username)

        when:
        employeeRepository.save(employee1)
        employeeRepository.save(employee2)

        then:
        thrown(DataIntegrityViolationException)
    }

    def 'setFirstName - length constraint'() {
        setup:
        Employee employee = new Employee(firstName: RandomString.make(31))

        when:
        employeeRepository.save(employee)

        then:
        thrown(DataIntegrityViolationException)
    }

    def 'setLastName'() {
        setup:
        Employee employee = new Employee(lastName: RandomString.make(31))

        when:
        employeeRepository.save(employee)

        then:
        thrown(DataIntegrityViolationException)
    }

    def 'setEmail'() {
        setup:
        Employee employee = new Employee(email: RandomString.make(51))

        when:
        employeeRepository.save(employee)

        then:
        thrown(DataIntegrityViolationException)
    }

    def 'setPassword'() {
        setup:
        Employee employee = new Employee(password: RandomString.make(201))

        when:
        employeeRepository.save(employee)

        then:
        thrown(DataIntegrityViolationException)
    }

}
