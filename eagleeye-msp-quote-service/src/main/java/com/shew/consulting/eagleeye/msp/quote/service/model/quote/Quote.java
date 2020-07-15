package com.shew.consulting.eagleeye.msp.quote.service.model.quote;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.Map;

/**
 * Quote class that represents a quote.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long customerId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Map<String, Selection> selections;

    private double total;

    private Instant timestamp;

}