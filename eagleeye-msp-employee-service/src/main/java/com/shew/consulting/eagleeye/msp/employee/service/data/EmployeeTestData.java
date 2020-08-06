package com.shew.consulting.eagleeye.msp.employee.service.data;

import com.shew.consulting.eagleeye.msp.employee.service.controllers.EmployeeController;
import com.shew.consulting.eagleeye.msp.employee.service.model.AccountStatus;
import com.shew.consulting.eagleeye.msp.employee.service.model.EmployeeSave;
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
        List<EmployeeSave> employeeSaves = new ArrayList<>();
        employeeSaves.add(employeeSave1());
        employeeSaves.add(employeeSave2());
        employeeSaves.add(employeeSave3());
        employeeSaves.add(employeeSave4());
        employeeSaves.add(employeeSave5());
        employeeSaves.add(employeeSave6());
        employeeSaves.add(employeeSave7());
        employeeSaves.add(employeeSave8());
        employeeSaves.add(employeeSave9());
        employeeSaves.add(employeeSave10());
        employeeSaves.forEach(employeeSave -> {
            Set<ConstraintViolation<EmployeeSave>> violations = validator.validate(employeeSave);
            if (!violations.isEmpty()) {
                throw new ConstraintViolationException(violations);
            }
            employeeController.saveEmployee(employeeSave);
        });
        log.info(event.toString());
    }

    private EmployeeSave employeeSave1() {
        EmployeeSave employeeSave = new EmployeeSave();
        employeeSave.setUsername("KLovell");
        employeeSave.setFirstName("Kenny");
        employeeSave.setLastName("Lovell");
        employeeSave.setEmail("Kenny.Lovell@EagleEYE.com");
        employeeSave.setSecurityRole(SecurityRole.USER);
        employeeSave.setPassword("Password11**");
        employeeSave.setPassword2(employeeSave.getPassword());
        employeeSave.setAccountStatus(AccountStatus.ACTIVE);
        return employeeSave;
    }

    private EmployeeSave employeeSave2() {
        EmployeeSave employeeSave = new EmployeeSave();
        employeeSave.setUsername("KCarroll");
        employeeSave.setFirstName("Karen");
        employeeSave.setLastName("Carroll");
        employeeSave.setEmail("Karen.Carroll@EagleEYE.com");
        employeeSave.setSecurityRole(SecurityRole.ADMIN);
        employeeSave.setPassword("Password11**");
        employeeSave.setPassword2(employeeSave.getPassword());
        employeeSave.setAccountStatus(AccountStatus.ACTIVE);
        return employeeSave;
    }

    private EmployeeSave employeeSave3() {
        EmployeeSave employeeSave = new EmployeeSave();
        employeeSave.setUsername("LCalhoun");
        employeeSave.setFirstName("Lukas");
        employeeSave.setLastName("Calhoun");
        employeeSave.setEmail("Lukas.Calhoun@EagleEYE.com");
        employeeSave.setSecurityRole(SecurityRole.USER);
        employeeSave.setPassword("Password11**");
        employeeSave.setPassword2(employeeSave.getPassword());
        employeeSave.setAccountStatus(AccountStatus.ACTIVE);
        return employeeSave;
    }

    private EmployeeSave employeeSave4() {
        EmployeeSave employeeSave = new EmployeeSave();
        employeeSave.setUsername("BMcclure");
        employeeSave.setFirstName("Bryn");
        employeeSave.setLastName("Mcclure");
        employeeSave.setEmail("Bryn.Mcclure@EagleEYE.com");
        employeeSave.setSecurityRole(SecurityRole.ADMIN);
        employeeSave.setPassword("Password11**");
        employeeSave.setPassword2(employeeSave.getPassword());
        employeeSave.setAccountStatus(AccountStatus.ACTIVE);
        return employeeSave;
    }

    private EmployeeSave employeeSave5() {
        EmployeeSave employeeSave = new EmployeeSave();
        employeeSave.setUsername("GDawe");
        employeeSave.setFirstName("Griff");
        employeeSave.setLastName("Dawe");
        employeeSave.setEmail("Griff.Dawe@EagleEYE.com");
        employeeSave.setSecurityRole(SecurityRole.USER);
        employeeSave.setPassword("Password11**");
        employeeSave.setPassword2(employeeSave.getPassword());
        employeeSave.setAccountStatus(AccountStatus.ACTIVE);
        return employeeSave;
    }

    private EmployeeSave employeeSave6() {
        EmployeeSave employeeSave = new EmployeeSave();
        employeeSave.setUsername("ARusso");
        employeeSave.setFirstName("Ana");
        employeeSave.setLastName("Russo");
        employeeSave.setEmail("Ana.Russo@EagleEYE.com");
        employeeSave.setSecurityRole(SecurityRole.ADMIN);
        employeeSave.setPassword("Password11**");
        employeeSave.setPassword2(employeeSave.getPassword());
        employeeSave.setAccountStatus(AccountStatus.ACTIVE);
        return employeeSave;
    }

    private EmployeeSave employeeSave7() {
        EmployeeSave employeeSave = new EmployeeSave();
        employeeSave.setUsername("SMedrano");
        employeeSave.setFirstName("Shiv");
        employeeSave.setLastName("Medrano");
        employeeSave.setEmail("Shiv.Medrano@EagleEYE.com");
        employeeSave.setSecurityRole(SecurityRole.USER);
        employeeSave.setPassword("Password11**");
        employeeSave.setPassword2(employeeSave.getPassword());
        employeeSave.setAccountStatus(AccountStatus.ACTIVE);
        return employeeSave;
    }

    private EmployeeSave employeeSave8() {
        EmployeeSave employeeSave = new EmployeeSave();
        employeeSave.setUsername("EClarkson");
        employeeSave.setFirstName("Elleanor");
        employeeSave.setLastName("Clarkson");
        employeeSave.setEmail("Elleanor.Clarkson@EagleEYE.com");
        employeeSave.setSecurityRole(SecurityRole.ADMIN);
        employeeSave.setPassword("Password11**");
        employeeSave.setPassword2(employeeSave.getPassword());
        employeeSave.setAccountStatus(AccountStatus.ACTIVE);
        return employeeSave;
    }

    private EmployeeSave employeeSave9() {
        EmployeeSave employeeSave = new EmployeeSave();
        employeeSave.setUsername("SBonilla");
        employeeSave.setFirstName("Skye");
        employeeSave.setLastName("Bonilla");
        employeeSave.setEmail("Skye.Bonilla@EagleEYE.com");
        employeeSave.setSecurityRole(SecurityRole.USER);
        employeeSave.setPassword("Password11**");
        employeeSave.setPassword2(employeeSave.getPassword());
        employeeSave.setAccountStatus(AccountStatus.ACTIVE);
        return employeeSave;
    }

    private EmployeeSave employeeSave10() {
        EmployeeSave employeeSave = new EmployeeSave();
        employeeSave.setUsername("RBurrows");
        employeeSave.setFirstName("Reagan");
        employeeSave.setLastName("Burrows");
        employeeSave.setEmail("Reagan.Burrows@EagleEYE.com");
        employeeSave.setSecurityRole(SecurityRole.ADMIN);
        employeeSave.setPassword("Password11**");
        employeeSave.setPassword2(employeeSave.getPassword());
        employeeSave.setAccountStatus(AccountStatus.ACTIVE);
        return employeeSave;
    }

}
