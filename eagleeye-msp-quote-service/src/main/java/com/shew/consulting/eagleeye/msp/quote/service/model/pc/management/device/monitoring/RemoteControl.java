package com.shew.consulting.eagleeye.msp.quote.service.model.pc.management.device.monitoring;

import com.shew.consulting.eagleeye.msp.quote.service.model.Item;

public class RemoteControl extends Item {

    public static final String NAME = "Remote Control";
    public static final String ID = "remoteControlDeviceMonitoring";

    public RemoteControl() {
        setId(NAME);
        setName(ID);
        setOrder(2);
    }

}
