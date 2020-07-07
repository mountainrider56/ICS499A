package com.shew.consulting.eagleeye.msp.quote.service.model.pc.management.device.monitoring;

import com.shew.consulting.eagleeye.msp.quote.service.model.Item;

public class Performance extends Item {

    public static final String NAME = "Performance";
    public static final String ID = "performanceDeviceMonitoring";

    public Performance() {
        setId(NAME);
        setName(ID);
        setOrder(0);
    }

}
