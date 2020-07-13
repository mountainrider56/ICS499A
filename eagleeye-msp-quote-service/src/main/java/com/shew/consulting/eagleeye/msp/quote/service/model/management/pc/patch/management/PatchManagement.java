package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.patch.management;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import org.springframework.stereotype.Component;

@Component
public class PatchManagement implements ServiceDefinition {

    public static final String TITLE = "Patch Management";

    @Override
    public Service defineService() {
        return new Service(getId(ManagementType.PC), TITLE, 0);
    }

}
