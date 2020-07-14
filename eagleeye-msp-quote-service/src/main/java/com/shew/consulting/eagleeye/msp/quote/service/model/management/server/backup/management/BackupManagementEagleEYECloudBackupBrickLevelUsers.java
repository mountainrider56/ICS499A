package com.shew.consulting.eagleeye.msp.quote.service.model.management.server.backup.management;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import org.springframework.stereotype.Component;

@Component
public class BackupManagementEagleEYECloudBackupBrickLevelUsers implements ServiceDefinition {

    public static final String TITLE = "Brick Level Users";

    @Override
    public Service defineService() {
        return new Service(getId(ManagementType.SERVER), TITLE, 1);
    }

}
