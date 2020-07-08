package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.patch.management.breakdowns;

import com.shew.consulting.eagleeye.msp.quote.service.model.services.BusinessServiceBreakdown;

import javax.persistence.Entity;

@Entity
public class WindowsUpdates extends BusinessServiceBreakdown {

    public static final String NAME = "Windows Updates";
    public static final String ID = "windowsUpdatesPatchManagementPc";

    public WindowsUpdates() {
        setId(ID);
        setName(NAME);
        setDisplayOrder(0);
        setPrice(12);
    }

}
