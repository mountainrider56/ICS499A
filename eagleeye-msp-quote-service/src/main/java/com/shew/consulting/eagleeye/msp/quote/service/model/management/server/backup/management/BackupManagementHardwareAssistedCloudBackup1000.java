package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.backup.management;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import org.springframework.stereotype.Component;

/**
 * Server: Backup Management: Hardware Assisted Cloud Backup (Barracuda via eagleEYE): 1000GB
 */
@Component
public class BackupManagementHardwareAssistedCloudBackup1000 implements ServiceDefinition {

    public static final String TITLE = "1000GB";

    @Override
    public Service defineService() {
        return new Service(getId(ManagementType.SERVER), TITLE, 299.99);
    }

}
