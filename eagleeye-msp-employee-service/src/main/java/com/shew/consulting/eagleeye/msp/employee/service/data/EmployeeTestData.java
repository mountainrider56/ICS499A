package com.shew.consulting.eagleeye.msp.employee.service.data;

import com.shew.consulting.eagleeye.msp.employee.service.model.Employee;
import com.shew.consulting.eagleeye.msp.employee.service.repository.EmployeeRepository;
import com.shew.consulting.eagleeye.msp.employee.service.model.SecurityRole;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

/**
 * Add test data on service startup.
 */
@Component
@Profile("testData")
@RequiredArgsConstructor
public class EmployeeTestData {

    private final EmployeeRepository employeeRepository;

    @EventListener
    public void applicationReady(ApplicationReadyEvent event) {
        System.out.println(event);
        IntStream.range(0, 10).forEach(i -> {
            Employee employee = new Employee();
            employee.setUsername("username" + i);
            employee.setFirstName("firstName" + i);
            employee.setLastName("lastName" + i);
            employee.setEmail("email" + i + "@gmail.com");
            employee.setSecurityRole((i % 2 == 0) ? SecurityRole.USER : SecurityRole.ADMIN);
            employee.setPassword("ss");
            employeeRepository.save(employee);
        });
    }

}
