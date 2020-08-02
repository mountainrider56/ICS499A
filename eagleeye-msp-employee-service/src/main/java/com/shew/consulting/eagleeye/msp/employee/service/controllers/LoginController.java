package com.shew.consulting.eagleeye.msp.employee.service.controllers;

import com.google.common.cache.LoadingCache;
import com.shew.consulting.eagleeye.msp.employee.service.model.AccountStatus;
import com.shew.consulting.eagleeye.msp.employee.service.model.Employee;
import com.shew.consulting.eagleeye.msp.employee.service.model.Login;
import com.shew.consulting.eagleeye.msp.employee.service.model.LoginAttempt;
import com.shew.consulting.eagleeye.msp.employee.service.model.jwttoken.JwtResponse;
import com.shew.consulting.eagleeye.msp.employee.service.model.jwttoken.JwtTokenUtil;
import com.shew.consulting.eagleeye.msp.employee.service.repository.EmployeeRepository;
import com.shew.consulting.eagleeye.msp.employee.service.repository.LoginAttemptRepository;
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

    public static final String ERROR_MESSAGE = "The username and password entered do not match our records.";

    private final JwtTokenUtil jwtTokenUtil;
    private final EmployeeRepository employeeRepository;
    private final LoginAttemptRepository loginAttemptRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final LoadingCache<String, Employee> sessionCache;

    @PostMapping
    public JwtResponse login(@RequestBody Login login) {
        try {
            Optional<Employee> optional = employeeRepository.findEmployeeByUsername(login.getUsername());
            if (optional.isPresent()) {
                Employee employee = optional.get();
                if (employee.getAccountStatus().isActive()) {
                    if (bCryptPasswordEncoder.matches(login.getPassword(), employee.getPassword())) {
                        String token = jwtTokenUtil.generateToken(optional.get());
                        sessionCache.put(token, optional.get());
                        loginAttemptRepository.save(new LoginAttempt(employee.getId(), 0));
                        return new JwtResponse(token);
                    }
                } else {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Account is locked.");
                }
                increaseLoginAttempt(employee);
            }
        } catch (Exception exception) {
            if (exception instanceof ResponseStatusException) {
                throw exception;
            }
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ERROR_MESSAGE);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, ERROR_MESSAGE);
    }

    private void increaseLoginAttempt(Employee employee) {
        Optional<LoginAttempt> optionalLoginAttempt = loginAttemptRepository.findById(employee.getId());
        if (optionalLoginAttempt.isPresent()) {
            LoginAttempt loginAttempt = optionalLoginAttempt.get();
            loginAttempt.setAttempt(loginAttempt.getAttempt() + 1);
            if (loginAttempt.getAttempt() >= 5) {
                employee.setAccountStatus(AccountStatus.LOCKED);
                employeeRepository.save(employee);
            }
            loginAttemptRepository.save(loginAttempt);
        } else {
            loginAttemptRepository.save(new LoginAttempt(employee.getId(), 0));
        }
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
