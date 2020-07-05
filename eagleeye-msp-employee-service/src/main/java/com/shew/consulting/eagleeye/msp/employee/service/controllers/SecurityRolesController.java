package com.shew.consulting.eagleeye.msp.employee.service.controllers;

import com.shew.consulting.eagleeye.msp.employee.service.model.SecurityRole;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Expose endpoints for the security roles in employee service.
 */
@RestController
@RequestMapping("v1/employees/security-roles")
@RequiredArgsConstructor
public class SecurityRolesController {

    @GetMapping
    public SecurityRole[] getSecurityRoles() {
        return SecurityRole.values();
    }

}
