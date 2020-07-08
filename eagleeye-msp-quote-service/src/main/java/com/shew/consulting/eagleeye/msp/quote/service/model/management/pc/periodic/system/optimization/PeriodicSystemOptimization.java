package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.periodic.system.optimization;

import com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.periodic.system.optimization.breakdowns.Defrag;
import com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.periodic.system.optimization.breakdowns.RemoveTemporaryFiles;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.BusinessService;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.BusinessServiceBreakdown;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
@Component
public class PeriodicSystemOptimization extends BusinessService {

    public static final String NAME = "Periodic System Optimization";
    public static final String ID = "periodicSystemOptimizationPc";

    public PeriodicSystemOptimization() {
        setId(ID);
        setName(NAME);
        setDisplayOrder(3);
        setPrice(5);
        List<BusinessServiceBreakdown> breakdowns = new ArrayList<>();
        breakdowns.add(new Defrag());
        breakdowns.add(new RemoveTemporaryFiles());
        setBreakdowns(breakdowns);
    }

}
