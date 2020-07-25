package com.shew.consulting.eagleeye.msp.employee.service.model

import spock.lang.Specification
import spock.lang.Unroll

class EmployeeSaveSpec extends Specification {

    @Unroll
    def 'employee save creation - #id'() {
        setup:
        EmployeeSave employeeSave = new EmployeeSave()
        employeeSave.id = id
        employeeSave.username = username
        employeeSave.firstName = firstName
        employeeSave.lastName = lastName
        employeeSave.email = email
        employeeSave.securityRole = securityRole
        employeeSave.password = password
        employeeSave.password2 = password

        expect:
        employeeSave // employeeSave not null
        employeeSave.id == id
        employeeSave.username == username
        employeeSave.firstName == firstName
        employeeSave.lastName == lastName
        employeeSave.email == email
        employeeSave.securityRole == securityRole
        employeeSave.password == password
        employeeSave.password2 == password

        where:
        id | firstName | lastName | username             | email            | securityRole       | password
        0  | 'user'    | 'last'   | firstName + lastName | 'user@test.com'  | SecurityRole.USER  | ''
        1  | 'admin'   | 'last'   | firstName + lastName | 'admin@test.com' | SecurityRole.ADMIN | ''
    }

}
