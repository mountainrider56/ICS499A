package com.shew.consulting.eagleeye.msp.employee.service.data;

import com.shew.consulting.eagleeye.msp.employee.service.controllers.EmployeeController;
import com.shew.consulting.eagleeye.msp.employee.service.model.EmployeeRequest;
import com.shew.consulting.eagleeye.msp.employee.service.model.SecurityRole;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Add test data on service startup.
 */
@Slf4j
@Component
@Profile("testData")
@RequiredArgsConstructor
public class EmployeeTestData {

    private final EmployeeController employeeController;
    private final Validator validator;

    @EventListener
    public void applicationReady(ApplicationReadyEvent event) {
        List<EmployeeRequest> employeeRequests = new ArrayList<>();
        employeeRequests.add(employeeRequest1());
        employeeRequests.add(employeeRequest2());
        employeeRequests.add(employeeRequest3());
        employeeRequests.add(employeeRequest4());
        employeeRequests.add(employeeRequest5());
        employeeRequests.add(employeeRequest6());
        employeeRequests.add(employeeRequest7());
        employeeRequests.add(employeeRequest8());
        employeeRequests.add(employeeRequest9());
        employeeRequests.add(employeeRequest10());
        employeeRequests.forEach(employeeRequest -> {
            Set<ConstraintViolation<EmployeeRequest>> violations = validator.validate(employeeRequest);
            if (!violations.isEmpty()) {
                throw new ConstraintViolationException(violations);
            }
            employeeController.saveEmployee(employeeRequest);
        });
        log.info(event.toString());
    }

    private EmployeeRequest employeeRequest1() {
        EmployeeRequest employeeRequest = new EmployeeRequest();
        employeeRequest.setUsername("KennyLovell");
        employeeRequest.setFirstName("Kenny");
        employeeRequest.setLastName("Lovell");
        employeeRequest.setEmail("Kenny.Lovell@EagleEYE.com");
        employeeRequest.setSecurityRole(SecurityRole.USER);
        employeeRequest.setPassword("Password11**");
        return employeeRequest;
    }

    private EmployeeRequest employeeRequest2() {
        EmployeeRequest employeeRequest = new EmployeeRequest();
        employeeRequest.setUsername("KarenCarroll");
        employeeRequest.setFirstName("Karen");
        employeeRequest.setLastName("Carroll");
        employeeRequest.setEmail("Karen.Carroll@EagleEYE.com");
        employeeRequest.setSecurityRole(SecurityRole.ADMIN);
        employeeRequest.setPassword("Password11**");
        return employeeRequest;
    }

    private EmployeeRequest employeeRequest3() {
        EmployeeRequest employeeRequest = new EmployeeRequest();
        employeeRequest.setUsername("LukasCalhoun");
        employeeRequest.setFirstName("Lukas");
        employeeRequest.setLastName("Calhoun");
        employeeRequest.setEmail("Lukas.Calhoun@EagleEYE.com");
        employeeRequest.setSecurityRole(SecurityRole.USER);
        employeeRequest.setPassword("Password11**");
        return employeeRequest;
    }

    private EmployeeRequest employeeRequest4() {
        EmployeeRequest employeeRequest = new EmployeeRequest();
        employeeRequest.setUsername("BrynMcclure");
        employeeRequest.setFirstName("Bryn");
        employeeRequest.setLastName("Mcclure");
        employeeRequest.setEmail("Bryn.Mcclure@EagleEYE.com");
        employeeRequest.setSecurityRole(SecurityRole.ADMIN);
        employeeRequest.setPassword("Password11**");
        return employeeRequest;
    }

    private EmployeeRequest employeeRequest5() {
        EmployeeRequest employeeRequest = new EmployeeRequest();
        employeeRequest.setUsername("GriffDawe");
        employeeRequest.setFirstName("Griff");
        employeeRequest.setLastName("Dawe");
        employeeRequest.setEmail("Griff.Dawe@EagleEYE.com");
        employeeRequest.setSecurityRole(SecurityRole.USER);
        employeeRequest.setPassword("Password11**");
        return employeeRequest;
    }

    private EmployeeRequest employeeRequest6() {
        EmployeeRequest employeeRequest = new EmployeeRequest();
        employeeRequest.setUsername("AnaRusso");
        employeeRequest.setFirstName("Ana");
        employeeRequest.setLastName("Russo");
        employeeRequest.setEmail("Ana.Russo@EagleEYE.com");
        employeeRequest.setSecurityRole(SecurityRole.ADMIN);
        employeeRequest.setPassword("Password11**");
        return employeeRequest;
    }

    private EmployeeRequest employeeRequest7() {
        EmployeeRequest employeeRequest = new EmployeeRequest();
        employeeRequest.setUsername("ShivMedrano");
        employeeRequest.setFirstName("Shiv");
        employeeRequest.setLastName("Medrano");
        employeeRequest.setEmail("Shiv.Medrano@EagleEYE.com");
        employeeRequest.setSecurityRole(SecurityRole.USER);
        employeeRequest.setPassword("Password11**");
        return employeeRequest;
    }

    private EmployeeRequest employeeRequest8() {
        EmployeeRequest employeeRequest = new EmployeeRequest();
        employeeRequest.setUsername("ElleanorClarkson");
        employeeRequest.setFirstName("Elleanor");
        employeeRequest.setLastName("Clarkson");
        employeeRequest.setEmail("Elleanor.Clarkson@EagleEYE.com");
        employeeRequest.setSecurityRole(SecurityRole.ADMIN);
        employeeRequest.setPassword("Password11**");
        return employeeRequest;
    }

    private EmployeeRequest employeeRequest9() {
        EmployeeRequest employeeRequest = new EmployeeRequest();
        employeeRequest.setUsername("SkyeBonilla");
        employeeRequest.setFirstName("Skye");
        employeeRequest.setLastName("Bonilla");
        employeeRequest.setEmail("Skye.Bonilla@EagleEYE.com");
        employeeRequest.setSecurityRole(SecurityRole.USER);
        employeeRequest.setPassword("Password11**");
        return employeeRequest;
    }

    private EmployeeRequest employeeRequest10() {
        EmployeeRequest employeeRequest = new EmployeeRequest();
        employeeRequest.setUsername("ReaganBurrows");
        employeeRequest.setFirstName("Reagan");
        employeeRequest.setLastName("Burrows");
        employeeRequest.setEmail("Reagan.Burrows@EagleEYE.com");
        employeeRequest.setSecurityRole(SecurityRole.ADMIN);
        employeeRequest.setPassword("Password11**");
        return employeeRequest;
    }

}
