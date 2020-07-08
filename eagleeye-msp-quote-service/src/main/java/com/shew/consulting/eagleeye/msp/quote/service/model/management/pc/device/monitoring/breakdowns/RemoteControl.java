package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.device.monitoring.breakdowns;

import com.shew.consulting.eagleeye.msp.quote.service.model.services.BusinessServiceBreakdown;

import javax.persistence.Entity;

@Entity(name = "RemoteControlDeviceMonitoring")
public class RemoteControl extends BusinessServiceBreakdown {

    public static final String NAME = "Remote Control";
    public static final String ID = "remoteControlDeviceMonitoringPc";

    public RemoteControl() {
        setId(ID);
        setName(NAME);
        setDisplayOrder(2);
    }

}
