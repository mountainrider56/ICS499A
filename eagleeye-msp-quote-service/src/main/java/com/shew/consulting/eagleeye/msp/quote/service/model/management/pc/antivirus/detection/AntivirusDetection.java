package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.antivirus.detection;

import com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.antivirus.detection.breakdowns.DefinitionManagement;
import com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.antivirus.detection.breakdowns.HistoricReports;
import com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.antivirus.detection.breakdowns.ProvideTrendMicroWFBSSLicense;
import com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.antivirus.detection.breakdowns.ScheduledScanning;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.BusinessService;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.BusinessServiceBreakdown;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
@Component
public class AntivirusDetection extends BusinessService {

    public static final String NAME = "Antivirus Detection";
    public static final String ID = "antivirusDetectionPc";

    public AntivirusDetection() {
        setId(ID);
        setName(NAME);
        setPrice(3.25);
        setDisplayOrder(5);
        List<BusinessServiceBreakdown> breakdowns = new ArrayList<>();
        breakdowns.add(new ProvideTrendMicroWFBSSLicense());
        breakdowns.add(new DefinitionManagement());
        breakdowns.add(new ScheduledScanning());
        breakdowns.add(new HistoricReports());
        setBreakdowns(breakdowns);
    }

}
