package com.shew.consulting.eagleeye.msp.employee.service.model

import spock.lang.Specification
import spock.lang.Unroll

class EmployeeUpdateSpec extends Specification {

    @Unroll
    def 'employee update creation - #id'() {
        setup:
        EmployeeUpdate employeeUpdate = new EmployeeUpdate()
        employeeUpdate.id = id
        employeeUpdate.username = username
        employeeUpdate.firstName = firstName
        employeeUpdate.lastName = lastName
        employeeUpdate.email = email
        employeeUpdate.securityRole = securityRole
        employeeUpdate.password = password

        expect:
        employeeUpdate // employeeUpdate not null
        employeeUpdate.id == id
        employeeUpdate.username == username
        employeeUpdate.firstName == firstName
        employeeUpdate.lastName == lastName
        employeeUpdate.email == email
        employeeUpdate.securityRole == securityRole
        employeeUpdate.password == password

        where:
        id | firstName | lastName | username             | email            | securityRole       | password
        0  | 'user'    | 'last'   | firstName + lastName | 'user@test.com'  | SecurityRole.USER  | ''
        1  | 'admin'   | 'last'   | firstName + lastName | 'admin@test.com' | SecurityRole.ADMIN | ''
    }


}
