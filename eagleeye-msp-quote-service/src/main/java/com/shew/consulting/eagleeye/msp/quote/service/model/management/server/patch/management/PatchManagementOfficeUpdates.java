package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.patch.management;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import org.springframework.stereotype.Component;

/**
 * PC: Patch Management: Office Updates
 */
@Component
public class PatchManagementOfficeUpdates implements ServiceDefinition {

    public static final String TITLE = "Office Updates";

    @Override
    public Service defineService() {
        return new Service(getId(ManagementType.SERVER), TITLE, 30);
    }

}
