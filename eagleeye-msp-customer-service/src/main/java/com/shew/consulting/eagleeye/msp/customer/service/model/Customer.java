package com.shew.consulting.eagleeye.msp.customer.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Customer class that represents a customer.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    private Long id;

    @Column(length = 50)
    @NotBlank(message = "Name is required")
    @Size(max = 50, message = "Name must be equal to or less than 50 characters")
    private String name;

    @Column(length = 17)
    @NotNull(message = "Telephone number is required")
    @Size(min = 14, max = 17, message = "Invalid telephone number")
    private String telephone;

    @Column(length = 50)
    @Email(message = "Invalid email format")
    @NotEmpty(message = "Email is required")
    @Size(max = 50, message = "Email must be equal to or less than 50 characters")
    private String email;

    @Column(length = 50)
    @NotBlank(message = "Address is required")
    @Size(max = 50, message = "Address must be equal to or less than 50 characters")
    private String address1;

    @Column(length = 50)
    @Size(max = 50, message = "Address must be equal to or less than 50 characters")
    private String address2;

    @Column(length = 50)
    @NotBlank(message = "City is required")
    @Size(max = 50, message = "City must be equal to or less than 50 characters")
    private String city;

    @NotNull(message = "State is required")
    private USState state;

    @Column(length = 5)
    @NotNull(message = "Zipcode is required")
    @Pattern(regexp = "(^\\d{5}$)", message = "Invalid zipcode")
    private String zipcode;

    @Valid
    @MapsId
    @OneToOne(cascade = CascadeType.ALL)
    @NotNull(message = "Representative is required")
    private Representative representative;

}
