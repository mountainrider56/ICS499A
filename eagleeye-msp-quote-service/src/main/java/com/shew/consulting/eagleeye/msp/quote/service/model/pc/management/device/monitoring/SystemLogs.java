package com.shew.consulting.eagleeye.msp.quote.service.model.pc.management.device.monitoring;

import com.shew.consulting.eagleeye.msp.quote.service.model.Item;

public class SystemLogs extends Item {

    public static final String NAME = "System Logs";
    public static final String ID = "systemLogsDeviceMonitoring";

    public SystemLogs() {
        setId(NAME);
        setName(ID);
        setOrder(1);
    }

}
