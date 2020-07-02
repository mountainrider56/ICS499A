package com.shrew.consulting.eagleeye.msp.customer.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotNull(message = "Telephone number is required")
    @Size(min = 7, message = "Invalid telephone number")
    private String telephone;

    @NotNull(message = "Email is required")
    @NotEmpty(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

}
