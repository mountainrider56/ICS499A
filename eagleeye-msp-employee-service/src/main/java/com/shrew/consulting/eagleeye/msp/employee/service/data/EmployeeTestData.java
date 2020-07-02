package com.shrew.consulting.eagleeye.msp.employee.service.data;

import com.shrew.consulting.eagleeye.msp.employee.service.controllers.EmployeeController;
import com.shrew.consulting.eagleeye.msp.employee.service.model.Employee;
import com.shrew.consulting.eagleeye.msp.employee.service.model.SecurityRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class EmployeeTestData {

    private final EmployeeController employeeController;

    @PostConstruct
    public void postConstruct() {
        IntStream.range(0, 10).forEach(i -> {
            Employee employee = new Employee();
            employee.setFirstName("firstName" + i);
            employee.setLastName("lastName" + i);
            employee.setEmail("email" + i);
            employee.setSecurityRole((i % 2 == 0) ? SecurityRole.USER : SecurityRole.ADMIN);
            employee.setPassword("");
            employeeController.saveEmployee(employee);
        });
    }

}
