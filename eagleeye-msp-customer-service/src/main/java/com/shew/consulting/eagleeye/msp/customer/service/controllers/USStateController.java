package com.shew.consulting.eagleeye.msp.customer.service.controllers;

import com.shew.consulting.eagleeye.msp.customer.service.model.USState;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Expose endpoints for the available states.
 */
@RestController
@RequestMapping("v1/customers/states")
@RequiredArgsConstructor
public class USStateController {

    @GetMapping
    public USState[] getUSStates() {
        return USState.values();
    }

}
