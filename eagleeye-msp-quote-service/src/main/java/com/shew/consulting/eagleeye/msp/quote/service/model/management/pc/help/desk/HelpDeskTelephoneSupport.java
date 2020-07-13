package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.help.desk;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import org.springframework.stereotype.Component;

@Component
public class HelpDeskTelephoneSupport implements ServiceDefinition {

    public static final String TITLE = "Telephone Support";

    @Override
    public Service defineService() {
        return new Service(getId(ManagementType.PC), TITLE, 0);
    }

}
