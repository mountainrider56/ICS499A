package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.device.monitoring.breakdowns;

import com.shew.consulting.eagleeye.msp.quote.service.model.services.BusinessServiceBreakdown;

import javax.persistence.Entity;

@Entity
public class Performance extends BusinessServiceBreakdown {

    public static final String NAME = "Performance";
    public static final String ID = "performanceDeviceMonitoringPc";

    public Performance() {
        setId(ID);
        setName(NAME);
        setDisplayOrder(0);
    }

}
