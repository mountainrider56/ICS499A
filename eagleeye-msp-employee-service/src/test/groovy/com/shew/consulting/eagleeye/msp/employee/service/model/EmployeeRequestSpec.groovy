package com.shew.consulting.eagleeye.msp.employee.service.model

import spock.lang.Specification

class EmployeeRequestSpec extends Specification {

    def 'employee creation'() {
        setup:
        EmployeeRequest employeeRequest = new EmployeeRequest()
        employeeRequest.id = id
        employeeRequest.username = username
        employeeRequest.firstName = firstName
        employeeRequest.lastName = lastName
        employeeRequest.email = email
        employeeRequest.securityRole = securityRole
        employeeRequest.password = password

        expect:
        employeeRequest // employeeRequest not null
        employeeRequest.id == id
        employeeRequest.username == username
        employeeRequest.firstName == firstName
        employeeRequest.lastName == lastName
        employeeRequest.email == email
        employeeRequest.securityRole == securityRole
        employeeRequest.password == password

        where:
        id | firstName | lastName | username             | email            | securityRole       | password
        0  | 'user'    | 'last'   | firstName + lastName | 'user@test.com'  | SecurityRole.USER  | ''
        1  | 'admin'   | 'last'   | firstName + lastName | 'admin@test.com' | SecurityRole.ADMIN | ''
    }


}
