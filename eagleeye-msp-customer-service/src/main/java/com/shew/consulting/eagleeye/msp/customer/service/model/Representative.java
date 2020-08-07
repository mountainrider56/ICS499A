package com.shew.consulting.eagleeye.msp.customer.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * Representative class is a representative for a customer.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Representative {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 30)
    @NotBlank(message = "First name is required")
    @Size(max = 30, message = "First name must be equal to or less than 30 characters")
    private String firstName;

    @Column(length = 30)
    @NotBlank(message = "Last name is required")
    @Size(max = 30, message = "Last name must be equal to or less than 30 characters")
    private String lastName;

    @Column(length = 17)
    @NotNull(message = "Telephone number is required")
    @Size(min = 14, max = 17, message = "Invalid telephone number")
    private String telephone;

    @Column(length = 50)
    @NotEmpty(message = "Email is required")
    @Email(message = "Invalid email format")
    @Size(max = 50, message = "Email must be equal to or less than 50 characters")
    private String email;

}
