package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.device.monitoring;

import com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.device.monitoring.breakdowns.Performance;
import com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.device.monitoring.breakdowns.RemoteControl;
import com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.device.monitoring.breakdowns.SystemLogs;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.BusinessService;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.BusinessServiceBreakdown;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
@Component
public class DeviceMonitoring extends BusinessService {

    public static final String NAME = "Device Monitoring";
    public static final String ID = "deviceMonitoringPc";

    public DeviceMonitoring() {
        setId(ID);
        setName(NAME);
        setPrice(10);
        setDisplayOrder(0);
        List<BusinessServiceBreakdown> breakdowns = new ArrayList<>();
        breakdowns.add(new Performance());
        breakdowns.add(new SystemLogs());
        breakdowns.add(new RemoteControl());
        setBreakdowns(breakdowns);
    }

}
