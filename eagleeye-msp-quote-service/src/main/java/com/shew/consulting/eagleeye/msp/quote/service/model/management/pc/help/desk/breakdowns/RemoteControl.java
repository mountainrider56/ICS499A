package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.help.desk.breakdowns;

import com.shew.consulting.eagleeye.msp.quote.service.model.services.BusinessServiceBreakdown;

import javax.persistence.Entity;

@Entity(name = "RemoteControlHelpDesk")
public class RemoteControl extends BusinessServiceBreakdown {

    public static final String NAME = "Remote Control";
    public static final String ID = "remoteControlHelpDeskPc";

    public RemoteControl() {
        setId(ID);
        setName(NAME);
        setDisplayOrder(1);
    }

}
