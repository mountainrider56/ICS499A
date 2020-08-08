package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.device.monitoring;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import org.springframework.stereotype.Component;

/**
 * PC: Device Monitoring
 */
@Component
public class DeviceMonitoring implements ServiceDefinition {

    public static final String TITLE = "Device Monitoring";

    @Override
    public Service defineService() {
        return new Service(getId(ManagementType.PC), TITLE, 10);
    }

}
