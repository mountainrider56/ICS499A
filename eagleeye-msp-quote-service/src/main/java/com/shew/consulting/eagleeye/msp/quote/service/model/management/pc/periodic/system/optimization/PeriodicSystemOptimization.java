package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.periodic.system.optimization;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import org.springframework.stereotype.Component;

@Component
public class PeriodicSystemOptimization implements ServiceDefinition {

    public static final String TITLE = "Periodic System Optimization";

    @Override
    public Service defineService() {
        return new Service(getId(ManagementType.PC), TITLE, 5);
    }

}
