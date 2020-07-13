package com.shew.consulting.eagleeye.msp.quote.service.model.quote;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;
import java.util.Map;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long customerId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Map<String, Selection> selections;

    private double total;

    private Instant timestamp;

}