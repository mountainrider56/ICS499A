package com.shew.consulting.eagleeye.msp.employee.service.model;

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

    @Column(unique = true) // TODO: Test
    private String username;

//    @Column(length = 30) // TODO: Test
    private String firstName;

//    @Column(length = 30) // TODO: Test
    private String lastName;

//    @Column(length = 50) // TODO: Test
    private String email;

//    @Column(length = 5) // TODO: Test
    private SecurityRole securityRole;

//    @Column(length = 15) // TODO: Test
    private String password;

    private AccountStatus accountStatus;

}
