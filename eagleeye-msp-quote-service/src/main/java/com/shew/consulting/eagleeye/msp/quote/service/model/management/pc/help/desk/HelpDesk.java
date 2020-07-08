package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.help.desk;

import com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.help.desk.breakdowns.RemoteControl;
import com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.help.desk.breakdowns.TelephoneSupport;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.BusinessService;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.BusinessServiceBreakdown;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
@Component
public class HelpDesk extends BusinessService {

    public static final String NAME = "Help Desk";
    public static final String ID = "helpDeskPc";

    public HelpDesk() {
        setId(ID);
        setName(NAME);
        setPrice(20);
        setDisplayOrder(2);
        List<BusinessServiceBreakdown> breakdowns = new ArrayList<>();
        breakdowns.add(new TelephoneSupport());
        breakdowns.add(new RemoteControl());
        setBreakdowns(breakdowns);
    }

}
