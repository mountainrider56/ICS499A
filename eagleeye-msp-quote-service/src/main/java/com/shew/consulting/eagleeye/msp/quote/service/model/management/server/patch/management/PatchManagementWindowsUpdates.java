package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.patch.management;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import org.springframework.stereotype.Component;

/**
 * PC: Patch Management: OWindows Updates
 */
@Component
public class PatchManagementWindowsUpdates implements ServiceDefinition {

    public static final String TITLE = "Windows Updates";

    @Override
    public Service defineService() {
        return new Service(getId(ManagementType.SERVER), TITLE, 55);
    }

}
