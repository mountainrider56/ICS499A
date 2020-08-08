package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.antivirus.detection;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import org.springframework.stereotype.Component;

/**
 * PC: AntiVirus Detection: Historic Reports
 */
@Component
public class AntivirusDetectionHistoricReports implements ServiceDefinition {

    public static final String TITLE = "Historic Reports";

    @Override
    public Service defineService() {
        return new Service(getId(ManagementType.PC), TITLE, 0);
    }

}
