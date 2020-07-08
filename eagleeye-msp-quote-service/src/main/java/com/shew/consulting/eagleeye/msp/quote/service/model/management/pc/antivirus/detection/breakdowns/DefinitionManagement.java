package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.antivirus.detection.breakdowns;

import com.shew.consulting.eagleeye.msp.quote.service.model.services.BusinessServiceBreakdown;

import javax.persistence.Entity;

@Entity(name = "definitionManagementAntivirus")
public class DefinitionManagement extends BusinessServiceBreakdown {

    public static final String NAME = "Definition Management";
    public static final String ID = "definitionManagementAntivirusDetectionPc";

    public DefinitionManagement() {
        setId(ID);
        setName(NAME);
        setDisplayOrder(1);
    }

}