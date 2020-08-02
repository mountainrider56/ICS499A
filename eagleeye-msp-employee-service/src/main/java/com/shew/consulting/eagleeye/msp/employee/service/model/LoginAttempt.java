package com.shew.consulting.eagleeye.msp.employee.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class LoginAttempt {

    @Id
    private Long EmployeeId;
    private int attempt;

}
