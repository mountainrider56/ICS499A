package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.help.desk.breakdowns;

import com.shew.consulting.eagleeye.msp.quote.service.model.services.BusinessServiceBreakdown;

import javax.persistence.Entity;

@Entity
public class TelephoneSupport extends BusinessServiceBreakdown {

    public static final String NAME = "Telephone Support";
    public static final String ID = "telephoneSupportHelpDeskPc";

    public TelephoneSupport() {
        setId(ID);
        setName(NAME);
        setDisplayOrder(0);
    }

}
