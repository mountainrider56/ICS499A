package com.shrew.consulting.eagleeye.msp.employee.service.controllers

import com.shrew.consulting.eagleeye.msp.employee.service.model.Employee
import com.shrew.consulting.eagleeye.msp.employee.service.repository.EmployeeRepository
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException
import spock.lang.Specification

class EmployeeControllerSpec extends Specification {

    EmployeeRepository employeeRepository
    EmployeeController employeeController

    void setup() {
        employeeRepository = Mock()
        employeeController = new EmployeeController(employeeRepository)
    }

    def 'save employee'() {
        setup:
        Employee employee = new Employee()

        when:
        Employee response = employeeController.saveEmployee(employee)

        then:
        1 * employeeRepository.save(employee) >> employee
        0 * _ // no more calls
        response == employee
    }

    def 'get employees'() {
        setup:
        Employee employee1 = new Employee()
        Employee employee2 = new Employee()

        when:
        List<Employee> employees = employeeController.getEmployees()

        then:
        1 * employeeRepository.findAll() >> [employee1, employee2]
        0 * _ // no more calls
        employees == [employee1, employee2]
    }

    def 'get employee'() {
        setup:
        Optional<Employee> optional = Optional.ofNullable(new Employee())

        when:
        Employee response = employeeController.getEmployee(0)

        then:
        1 * employeeRepository.findById(0) >> optional
        0 * _ // no more calls
        response == optional.get()
    }

    def 'get employee - 404'() {
        setup:
        Optional<Employee> optional = Optional.ofNullable(null)

        when:
        employeeController.getEmployee(0)

        then:
        1 * employeeRepository.findById(0) >> optional
        0 * _ // no more calls
        ResponseStatusException ex = thrown()
        ex.message == '404 NOT_FOUND "employee not found: 0"'
        ex.status == HttpStatus.NOT_FOUND
    }

}
