package com.shrew.consulting.eagleeye.msp.quote.service.model.pc.management.backup.management;

import com.shrew.consulting.eagleeye.msp.quote.service.model.Item;

import javax.persistence.Entity;

@Entity
public class Monitoring extends Item {

    public Monitoring() {
        setId("monitoring");
        setPrice(3);
    }

}
