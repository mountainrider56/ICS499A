package com.shew.consulting.eagleeye.msp.employee.service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Employee class that represents a employee.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, length = 15)
    private String username;

    @Column(length = 30)
    private String firstName;

    @Column(length = 30)
    private String lastName;

    @Column(length = 50)
    private String email;

    private SecurityRole securityRole;

    @Column(length = 200)
    private String password;

    private AccountStatus accountStatus;

    @JsonIgnore
    public String getPassword() {
        return password;
    }

}
