package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.device.monitoring.breakdowns;

import com.shew.consulting.eagleeye.msp.quote.service.model.services.BusinessServiceBreakdown;

import javax.persistence.Entity;

@Entity
public class SystemLogs extends BusinessServiceBreakdown {

    public static final String NAME = "System Logs";
    public static final String ID = "systemLogsDeviceMonitoringPc";

    public SystemLogs() {
        setId(ID);
        setName(NAME);
        setDisplayOrder(1);
    }

}
