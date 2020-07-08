package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.basic.spam.service.breakdowns;

import com.shew.consulting.eagleeye.msp.quote.service.model.services.BusinessServiceBreakdown;

import javax.persistence.Entity;

@Entity
public class DomainLevelFiltering extends BusinessServiceBreakdown {

    public static final String NAME = "Domain Level Filtering";
    public static final String ID = "domainLevelFilteringBasicSpamServicePcPc";

    public DomainLevelFiltering() {
        setId(ID);
        setName(NAME);
        setPrice(2.50);
        setDisplayOrder(0);
    }

}
