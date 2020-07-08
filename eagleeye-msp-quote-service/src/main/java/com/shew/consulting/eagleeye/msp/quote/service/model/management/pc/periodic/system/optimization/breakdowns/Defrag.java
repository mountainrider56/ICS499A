package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.periodic.system.optimization.breakdowns;

import com.shew.consulting.eagleeye.msp.quote.service.model.services.BusinessServiceBreakdown;

import javax.persistence.Entity;

@Entity
public class Defrag extends BusinessServiceBreakdown {

    public static final String NAME = "Defrag";
    public static final String ID = "defragPeriodicSystemOptimizationPc";

    public Defrag() {
        setId(ID);
        setName(NAME);
        setDisplayOrder(0);
    }

}
