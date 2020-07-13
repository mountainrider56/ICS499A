package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.backup.management;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import org.springframework.stereotype.Component;

@Component
public class BackupManagementIntegratedBackup implements ServiceDefinition {

    public static final String TITLE = "Integrated Backup";

    @Override
    public Service defineService() {
        return new Service(getId(ManagementType.PC), TITLE, 10);
    }

}
