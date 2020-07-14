package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.backup.management;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import org.springframework.stereotype.Component;

@Component
public class BackupManagementHardwareAssistedCloudBackup500 implements ServiceDefinition {

    public static final String TITLE = "500GB";

    @Override
    public Service defineService() {
        return new Service(getId(ManagementType.SERVER), TITLE, 199.99);
    }

}
