package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.basic.spam.service.breakdowns;

import com.shew.consulting.eagleeye.msp.quote.service.model.services.BusinessServiceBreakdown;

import javax.persistence.Entity;

@Entity(name = "definitionManagementBasic")
public class DefinitionManagement extends BusinessServiceBreakdown {

    public static final String NAME = "Definition Management";
    public static final String ID = "definitionManagementBasicSpamServicePc";

    public DefinitionManagement() {
        setId(ID);
        setName(NAME);
        setDisplayOrder(1);
    }

}
