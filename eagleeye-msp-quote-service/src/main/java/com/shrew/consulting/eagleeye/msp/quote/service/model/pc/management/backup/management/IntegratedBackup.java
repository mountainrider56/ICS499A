package com.shrew.consulting.eagleeye.msp.quote.service.model.pc.management.backup.management;

import com.shrew.consulting.eagleeye.msp.quote.service.model.Item;

import javax.persistence.Entity;

@Entity
public class IntegratedBackup extends Item {

    public IntegratedBackup() {
        setId("integratedBackup");
        setPrice(10);
    }

}
