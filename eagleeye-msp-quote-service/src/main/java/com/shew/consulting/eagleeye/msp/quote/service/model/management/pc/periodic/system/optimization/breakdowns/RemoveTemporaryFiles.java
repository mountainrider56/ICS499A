package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.periodic.system.optimization.breakdowns;

import com.shew.consulting.eagleeye.msp.quote.service.model.services.BusinessServiceBreakdown;

import javax.persistence.Entity;

@Entity
public class RemoveTemporaryFiles extends BusinessServiceBreakdown {


    public static final String NAME = "Remove Temporary Files";
    public static final String ID = "removeTemporaryFilesPeriodicSystemOptimizationPc";

    public RemoveTemporaryFiles() {
        setId(ID);
        setName(NAME);
        setDisplayOrder(1);
    }

}
