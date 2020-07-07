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

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Telephone number is required")
    @Size(min = 7, message = "Invalid telephone number")
    private String telephone;

    @Email(message = "Invalid email format")
    @NotEmpty(message = "Email is required")
    private String email;

    @NotBlank(message = "Address is required")
    private String address1;

    private String address2;

    @NotBlank(message = "City is required")
    private String city;

    @NotNull(message = "State is required")
    private USState state;

    @NotNull(message = "Zipcode is required")
    @Pattern(regexp = "(^\\d{5}$)|(^\\d{5}-\\d{4}$)", message = "Invalid zipcode")
    private String zipcode;

    @Valid
    @MapsId
    @OneToOne(cascade = CascadeType.ALL)
    @NotNull(message = "Representative is required")
    private Representative representative;

}
