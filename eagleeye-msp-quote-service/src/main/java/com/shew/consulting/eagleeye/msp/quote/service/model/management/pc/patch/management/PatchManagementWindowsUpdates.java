package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.patch.management;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import org.springframework.stereotype.Component;

/**
 * PC: Patch Management: Windows Updates
 */
@Component
public class PatchManagementWindowsUpdates implements ServiceDefinition {

    public static final String TITLE = "Windows Updates";

    @Override
    public Service defineService() {
        return new Service(getId(ManagementType.PC), TITLE, 12);
    }

}
