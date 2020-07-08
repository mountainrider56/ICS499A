package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.antivirus.detection.breakdowns;

import com.shew.consulting.eagleeye.msp.quote.service.model.services.BusinessServiceBreakdown;

import javax.persistence.Entity;

@Entity(name = "scheduledScanningAntivirus")
public class ScheduledScanning extends BusinessServiceBreakdown {

    public static final String NAME = "ScheduledScanning";
    public static final String ID = "scheduledScanningAntivirusDetectionPc";

    public ScheduledScanning() {
        setId(ID);
        setName(NAME);
        setDisplayOrder(2);
    }

}
