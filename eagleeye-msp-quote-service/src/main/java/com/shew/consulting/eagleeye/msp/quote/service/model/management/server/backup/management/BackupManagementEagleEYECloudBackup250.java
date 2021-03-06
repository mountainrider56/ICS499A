package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.backup.management;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import org.springframework.stereotype.Component;

/**
 * Server: Backup Management: eagleEYE Cloud Backup (250GB)
 */
@Component
public class BackupManagementEagleEYECloudBackup250 implements ServiceDefinition {

    public static final String TITLE = "eagleEYE Cloud Backup (250GB)";

    @Override
    public Service defineService() {
        return new Service(getId(ManagementType.SERVER), TITLE, 199.95);
    }

}
