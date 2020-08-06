package com.shew.consulting.eagleeye.msp.employee.service.model.jwttoken;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * The response class for a authentication token.
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {

    private String token;

}
