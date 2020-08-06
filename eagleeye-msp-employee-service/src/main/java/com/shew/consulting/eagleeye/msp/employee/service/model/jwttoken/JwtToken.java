package com.shew.consulting.eagleeye.msp.employee.service.model.jwttoken;

import com.shew.consulting.eagleeye.msp.employee.service.model.Employee;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;

/**
 * Jwt token utilities helper class.
 */
@Getter
@Component
@RequiredArgsConstructor
public class JwtToken {

    public static final int TIME = 172800 * 1000; // 48 hours

    private final String secret;
    private final Clock clock;

    /**
     * Generate token for user.
     */
    public String generateToken(Employee employee) {
        Instant issued = clock.instant();
        Instant expired = issued.plusMillis(TIME);
        return Jwts.builder().setClaims(new HashMap<>()).setSubject(employee.getUsername())
                   .setIssuedAt(Date.from(issued))
                   .setExpiration(Date.from(expired))
                   .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

}
