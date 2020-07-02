package com.shrew.consulting.eagleeye.msp.quote.service.model.pc.management.device.monitoring;

import com.shrew.consulting.eagleeye.msp.quote.service.model.Item;

import javax.persistence.Entity;

@Entity
public class DeviceMonitoring extends Item {

    public DeviceMonitoring() {
        setId("deviceMonitoring");
        setPrice(10);
    }

}
