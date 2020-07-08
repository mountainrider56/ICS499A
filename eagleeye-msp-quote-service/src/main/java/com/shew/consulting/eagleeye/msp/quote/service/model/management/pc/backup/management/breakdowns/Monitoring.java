package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.backup.management.breakdowns;

import com.shew.consulting.eagleeye.msp.quote.service.model.services.BusinessServiceBreakdown;

import javax.persistence.Entity;

@Entity
public class Monitoring extends BusinessServiceBreakdown {

    public static final String NAME = "Monitoring";
    public static final String ID = "monitoringBackupManagementPc";

    public Monitoring() {
        setId(ID);
        setName(NAME);
        setDisplayOrder(0);
        setPrice(3);
    }

}
