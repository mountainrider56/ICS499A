package com.shew.consulting.eagleeye.msp.employee.service.controllers;

import com.google.common.cache.LoadingCache;
import com.shew.consulting.eagleeye.msp.employee.service.model.Employee;
import com.shew.consulting.eagleeye.msp.employee.service.model.Login;
import com.shew.consulting.eagleeye.msp.employee.service.model.jwttoken.JwtResponse;
import com.shew.consulting.eagleeye.msp.employee.service.model.jwttoken.JwtTokenUtil;
import com.shew.consulting.eagleeye.msp.employee.service.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("v1/employees/login")
public class LoginController {

    private final JwtTokenUtil jwtTokenUtil;
    private final EmployeeRepository employeeRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final LoadingCache<String, Employee> sessionCache;

    @PostMapping
    public JwtResponse login(@RequestBody Login login) {
        Optional<Employee> optional = employeeRepository.findEmployeeByUsername(login.getUsername());
        if (optional.isPresent()) {
            Employee employee = optional.get();
            if (employee.getAccountStatus().isActive()) {
                if (bCryptPasswordEncoder.matches(login.getPassword(), employee.getPassword())) {
                    String token = jwtTokenUtil.generateToken(optional.get());
                    sessionCache.put(token, optional.get());
                    return new JwtResponse(token);
                }
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Account is locked.");
            }
        }
        String errorMessage = "The username and password entered do not match our records.";
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
    }

    @GetMapping("ping")
    public boolean pingSession(@RequestHeader (name="Authorization", required = false) String token) {
        try {
            return sessionCache.asMap().containsKey(token);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Login not active.");
        }
    }

    @PostMapping("logout")
    public void logout(@RequestHeader (name="Authorization", required = false) String token) {
        try {
            sessionCache.invalidate(token);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to logout.");
        }
    }

    @GetMapping
    public Employee getSession(@RequestHeader (name="Authorization", required = false) String token) {
        try {
            return sessionCache.get(token);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Login not active.");
        }
    }

}
