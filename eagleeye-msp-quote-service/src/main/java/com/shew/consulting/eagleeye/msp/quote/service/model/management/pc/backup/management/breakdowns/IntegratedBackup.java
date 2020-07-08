package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.backup.management.breakdowns;

import com.shew.consulting.eagleeye.msp.quote.service.model.services.BusinessServiceBreakdown;

import javax.persistence.Entity;

@Entity
public class IntegratedBackup extends BusinessServiceBreakdown {

    public static final String NAME = "Integrated Backup";
    public static final String ID = "integratedBackupBackupManagementPc";

    public IntegratedBackup() {
        setId(ID);
        setName(NAME);
        setDisplayOrder(1);
        setPrice(10);
    }

}
