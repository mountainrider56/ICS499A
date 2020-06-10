package com.shrew.consulting.eagleeye.msp.quote.service.model.pc.management.periodic.system.optimization;

import com.shrew.consulting.eagleeye.msp.quote.service.model.Item;

import javax.persistence.Entity;

@Entity
public class PeriodicSystemOptimization extends Item {

    public PeriodicSystemOptimization() {
        setId("periodicSystemOptimization");
        setPrice(5);
    }

}
