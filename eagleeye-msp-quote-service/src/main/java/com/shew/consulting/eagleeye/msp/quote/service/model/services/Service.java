package com.shew.consulting.eagleeye.msp.quote.service.model.services;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@Entity
public class Service {

    @Id
    private String id;
    private String name;
    private int displayOrder;
    private double price;

}
