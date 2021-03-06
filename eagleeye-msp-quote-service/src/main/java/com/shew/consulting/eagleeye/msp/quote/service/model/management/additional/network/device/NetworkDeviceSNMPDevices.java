package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.network.device;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import org.springframework.stereotype.Component;

/**
 * Additional: Network Device Service: SNMP Devices
 */
@Component
public class NetworkDeviceSNMPDevices implements ServiceDefinition {

    public static final String TITLE = "SNMP Devices";

    @Override
    public Service defineService() {
        return new Service(getId(ManagementType.ADDITIONAL), TITLE, 10);
    }

}
