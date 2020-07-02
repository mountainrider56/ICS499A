package com.shrew.consulting.eagleeye.msp.employee.service.controllers

import com.shrew.consulting.eagleeye.msp.employee.service.model.SecurityRole
import spock.lang.Specification

class SecurityRolesControllerSpec extends Specification {

    SecurityRolesController securityRolesController

    void setup() {
        securityRolesController = new SecurityRolesController()
    }

    def 'return security roles array'() {
        when:
        SecurityRole[] securityRoles = securityRolesController.getSecurityRoles()

        then:
        securityRoles == [SecurityRole.USER, SecurityRole.ADMIN] as SecurityRole[]
    }

}
