package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.basic.spam.service;

import com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.basic.spam.service.breakdowns.DefinitionManagement;
import com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.basic.spam.service.breakdowns.DomainLevelFiltering;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.BusinessService;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.BusinessServiceBreakdown;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
@Component
public class BasicSpamService extends BusinessService {

    public static final String NAME = "Basic Spam Service";
    public static final String ID = "basicSpamServicePc";

    public BasicSpamService() {
        setId(ID);
        setName(NAME);
        setDisplayOrder(7);
        List<BusinessServiceBreakdown> breakdowns = new ArrayList<>();
        breakdowns.add(new DomainLevelFiltering());
        breakdowns.add(new DefinitionManagement());
        setBreakdowns(breakdowns);
    }

}
