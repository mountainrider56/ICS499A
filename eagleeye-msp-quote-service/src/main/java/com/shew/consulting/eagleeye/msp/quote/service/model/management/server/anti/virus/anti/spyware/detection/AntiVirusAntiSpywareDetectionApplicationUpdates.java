package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.anti.virus.anti.spyware.detection;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import org.springframework.stereotype.Component;

/**
 * Server: AntiVirus/Antispyware Detection: Application Updates
 */
@Component
public class AntiVirusAntiSpywareDetectionApplicationUpdates implements ServiceDefinition {

    public static final String TITLE = "Application Updates";

    @Override
    public Service defineService() {
        return new Service(getId(ManagementType.SERVER), TITLE, 0);
    }

}
