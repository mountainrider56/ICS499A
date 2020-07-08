package com.shew.consulting.eagleeye.msp.quote.service.model.quote;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long customerId;

    @OneToOne(cascade = CascadeType.ALL)
    private PCManagementQuote pcManagementQuote;

    @OneToOne(cascade = CascadeType.ALL)
    private ServerManagementQuote serverManagementQuote;

    private double total;

    private Instant instant;

}