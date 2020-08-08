package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.device.monitoring;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import org.springframework.stereotype.Component;

/**
 * PC: Device Monitoring: System Logs
 */
@Component
public class DeviceMonitoringSystemLogs implements ServiceDefinition {

    public static final String TITLE = "System Logs";

    @Override
    public Service defineService() {
        return new Service(getId(ManagementType.PC), TITLE, 0);
    }

}
