package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.backup.management;

import com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.backup.management.breakdowns.IntegratedBackup;
import com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.backup.management.breakdowns.Monitoring;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.BusinessService;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.BusinessServiceBreakdown;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
@Component
public class BackupManagement extends BusinessService {

    public static final String NAME = "Backup management";
    public static final String ID = "backupManagementPc";

    public BackupManagement() {
        setId(ID);
        setName(NAME);
        setDisplayOrder(4);
        List<BusinessServiceBreakdown> breakdowns = new ArrayList<>();
        breakdowns.add(new Monitoring());
        breakdowns.add(new IntegratedBackup());
        setBreakdowns(breakdowns);
    }

}
