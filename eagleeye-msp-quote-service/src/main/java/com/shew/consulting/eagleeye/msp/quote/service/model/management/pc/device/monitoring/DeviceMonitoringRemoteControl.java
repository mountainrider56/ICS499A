package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.device.monitoring;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import org.springframework.stereotype.Component;

/**
 * PC: Device Monitoring: Remote Control
 */
@Component
public class DeviceMonitoringRemoteControl implements ServiceDefinition {

    public static final String TITLE = "Remote Control";

    @Override
    public Service defineService() {
        return new Service(getId(ManagementType.PC), TITLE, 0);
    }

}
