package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.patch.management.breakdowns;

import com.shew.consulting.eagleeye.msp.quote.service.model.services.BusinessServiceBreakdown;

import javax.persistence.Entity;

@Entity
public class OfficeUpdates extends BusinessServiceBreakdown {

    public static final String NAME = "Office Updates";
    public static final String ID = "officeUpdatesPatchManagementPc";

    public OfficeUpdates() {
        setId(ID);
        setName(NAME);
        setDisplayOrder(1);
        setPrice(3);
    }

}
