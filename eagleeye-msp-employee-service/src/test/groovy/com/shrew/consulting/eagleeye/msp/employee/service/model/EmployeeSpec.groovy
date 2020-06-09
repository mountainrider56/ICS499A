package com.shrew.consulting.eagleeye.msp.employee.service.model

import spock.lang.Specification

class EmployeeSpec extends Specification {

    def 'employee creation'() {
        setup:
        Employee employee = new Employee(id, firstName, lastName, email, securityRole, password)

        expect:
        employee // employee not null
        employee.id == id
        employee.firstName == firstName
        employee.lastName == lastName
        employee.email == email
        employee.securityRole == securityRole
        employee.password == password

        where:
        id | firstName | lastName | email            | securityRole       | password
        0  | 'user'    | 'last'   | 'user@test.com'  | SecurityRole.USER  | ''
        1  | 'admin'   | 'last'   | 'admin@test.com' | SecurityRole.ADMIN | ''
    }

}
