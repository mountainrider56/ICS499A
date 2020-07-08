package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.patch.management.breakdowns;

import com.shew.consulting.eagleeye.msp.quote.service.model.services.BusinessServiceBreakdown;

import javax.persistence.Entity;

@Entity
public class OtherUpdates extends BusinessServiceBreakdown {

    public static final String NAME = "Other Updates - AVG, Trend Micro";
    public static final String ID = "otherUpdatesPatchManagementPc";

    public OtherUpdates() {
        setId(ID);
        setName(NAME);
        setDisplayOrder(2);
        setPrice(3);
    }

}
