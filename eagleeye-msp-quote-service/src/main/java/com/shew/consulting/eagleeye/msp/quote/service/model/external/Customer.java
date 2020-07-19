package com.shew.consulting.eagleeye.msp.quote.service.model.external;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Customer class that represents a customer.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private Long id;
    private String name;
    private String telephone;
    private String email;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zipcode;
    private Representative representative;

}
