package com.shew.consulting.eagleeye.msp.employee.service.model.jwttoken;

import com.shew.consulting.eagleeye.msp.employee.service.model.Employee;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Jwt token utilities helper class.
 */

@Component
public class JwtTokenUtil {

    private final String secret;

    public JwtTokenUtil(@Value("${jwt.secret}") String secret) {
        this.secret = secret;
    }

    /**
     * Generate token for user.
     */
    public String generateToken(Employee employee) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder().setClaims(claims).setSubject(employee.getUsername())
                   .setIssuedAt(new Date(System.currentTimeMillis()))
                   .setExpiration(new Date(System.currentTimeMillis() + 18000000))
                   .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

}
