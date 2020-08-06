package com.shew.consulting.eagleeye.msp.employee.service.model.jwttoken

import com.shew.consulting.eagleeye.msp.employee.service.model.Employee
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import spock.lang.Specification

import java.time.Clock
import java.time.Instant
import java.time.ZoneId

class JwtTokenSpec extends Specification {

    def 'generateToken'() {
        when:
        Clock clock = Clock.fixed(Instant.now(), ZoneId.systemDefault())
        JwtToken jwtToken = new JwtToken('secret', clock)
        Employee employee = new Employee()
        employee.username = 'username'
        String string = jwtToken.generateToken(employee)

        then:
        jwtToken.getSecret() == 'secret'
        jwtToken.getClock() == clock
        Jws<Claims> jws = Jwts.parser().setSigningKey(jwtToken.getSecret()).parseClaimsJws(string)
        jws.header.getAlgorithm() == SignatureAlgorithm.HS512.toString()
        jws.body.getSubject() == employee.username
        jws.body.getIssuedAt().toString() == Date.from(clock.instant()).toString()
        jws.body.getExpiration().toString() == Date.from(clock.instant().plusMillis(JwtToken.TIME)).toString()
    }

}
