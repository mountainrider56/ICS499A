package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.anti.virus.anti.spyware.detection;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import org.springframework.stereotype.Component;

@Component
public class AntiVirusAntiSpywareDetectionProvideTrendMicroWFBSSLicense implements ServiceDefinition {

    public static final String TITLE = "Provide Trend Micro WFBSS License";

    @Override
    public Service defineService() {
        return new Service(getId(ManagementType.SERVER), TITLE, 0);
    }

}
