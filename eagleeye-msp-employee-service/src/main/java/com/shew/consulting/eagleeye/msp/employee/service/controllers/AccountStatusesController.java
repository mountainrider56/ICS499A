package com.shew.consulting.eagleeye.msp.employee.service.controllers;

import com.shew.consulting.eagleeye.msp.employee.service.model.AccountStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Expose endpoints for the account statuses in employee service.
 */
@RestController
@RequestMapping("v1/employees/account-statuses")
@RequiredArgsConstructor
public class AccountStatusesController {

    @GetMapping
    public AccountStatus[] getAccountStatuses() {
        return AccountStatus.values();
    }

}
