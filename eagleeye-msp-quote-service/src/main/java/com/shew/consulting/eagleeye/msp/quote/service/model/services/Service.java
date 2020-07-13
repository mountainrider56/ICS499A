package com.shew.consulting.eagleeye.msp.quote.service.model.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Service {

    @Id
    private String id;
    private String title;
    private double price;

}
