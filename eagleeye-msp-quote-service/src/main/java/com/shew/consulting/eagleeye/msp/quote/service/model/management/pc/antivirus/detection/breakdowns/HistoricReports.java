package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.antivirus.detection.breakdowns;

import com.shew.consulting.eagleeye.msp.quote.service.model.services.BusinessServiceBreakdown;

import javax.persistence.Entity;

@Entity
public class HistoricReports extends BusinessServiceBreakdown {

    public static final String NAME = "Historic Reports";
    public static final String ID = "historicReportsAntivirusDetectionPc";

    public HistoricReports() {
        setId(ID);
        setName(NAME);
        setDisplayOrder(3);
    }

}
