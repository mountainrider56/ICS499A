package com.shew.consulting.eagleeye.msp.quote.service.model.external;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representative class is a representative for a customer.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Representative {

    private Long id;
    private String firstName;
    private String lastName;
    private String telephone;
    private String email;

}
