package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.patch.management;

import com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.patch.management.breakdowns.OfficeUpdates;
import com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.patch.management.breakdowns.OtherUpdates;
import com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.patch.management.breakdowns.WindowsUpdates;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.BusinessService;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.BusinessServiceBreakdown;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
@Component
public class PatchManagement extends BusinessService {

    public static final String NAME = "Patch Management";
    public static final String ID = "patchManagementPc";

    public PatchManagement() {
        setId(ID);
        setName(NAME);
        setDisplayOrder(1);
        List<BusinessServiceBreakdown> breakdowns = new ArrayList<>();
        breakdowns.add(new WindowsUpdates());
        breakdowns.add(new OfficeUpdates());
        breakdowns.add(new OtherUpdates());
        setBreakdowns(breakdowns);
    }

}
