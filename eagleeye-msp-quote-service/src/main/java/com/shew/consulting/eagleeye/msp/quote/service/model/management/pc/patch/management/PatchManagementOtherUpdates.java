package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.patch.management;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import org.springframework.stereotype.Component;

/**
 * PC: Patch Management: Other Updates
 */
@Component
public class PatchManagementOtherUpdates implements ServiceDefinition {

    public static final String TITLE = "Other Updates - AVG, Trend Micro";

    @Override
    public Service defineService() {
        return new Service(getId(ManagementType.PC), TITLE, 3);
    }

}
