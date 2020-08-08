package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.help.desk;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import org.springframework.stereotype.Component;

/**
 * PC: Help Desk
 */
@Component
public class HelpDesk implements ServiceDefinition {

    public static final String TITLE = "Help Desk (24x7)";

    @Override
    public Service defineService() {
        return new Service(getId(ManagementType.PC), TITLE, 20);
    }

}
