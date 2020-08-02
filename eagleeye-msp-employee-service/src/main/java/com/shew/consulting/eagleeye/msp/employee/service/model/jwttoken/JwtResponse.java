package com.shew.consulting.eagleeye.msp.employee.service.model.jwttoken;

import lombok.Getter;

@Getter
public class JwtResponse {

    private final String token;

    public JwtResponse(String jwttoken) {
        this.token = jwttoken;
    }

}
