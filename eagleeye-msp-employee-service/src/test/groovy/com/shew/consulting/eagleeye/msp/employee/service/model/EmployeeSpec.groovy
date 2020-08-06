package com.shew.consulting.eagleeye.msp.employee.service.model


import spock.lang.Specification
import spock.lang.Unroll

class EmployeeSpec extends Specification {

    @Unroll
    def 'employee creation - @#id'() {
        setup:
        Employee employee = new Employee(id, username, firstName, lastName, email, securityRole, password, accountStatus)

        expect:
        employee // employee not null
        employee.id == id
        employee.username == username
        employee.firstName == firstName
        employee.lastName == lastName
        employee.email == email
        employee.securityRole == securityRole
        employee.accountStatus == accountStatus
        employee.password == password

        where:
        id | firstName | lastName | username             | email            | securityRole       | password | accountStatus
        0  | 'user'    | 'last'   | firstName + lastName | 'user@test.com'  | SecurityRole.USER  | ''       | AccountStatus.ACTIVE
        1  | 'admin'   | 'last'   | firstName + lastName | 'admin@test.com' | SecurityRole.ADMIN | ''       | AccountStatus.LOCKED
    }

}
