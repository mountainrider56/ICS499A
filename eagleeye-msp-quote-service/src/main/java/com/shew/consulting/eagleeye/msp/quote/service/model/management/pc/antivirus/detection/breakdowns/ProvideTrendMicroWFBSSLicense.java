package com.shew.consulting.eagleeye.msp.quote.service.model.management.pc.antivirus.detection.breakdowns;

import com.shew.consulting.eagleeye.msp.quote.service.model.services.BusinessServiceBreakdown;

import javax.persistence.Entity;

@Entity
public class ProvideTrendMicroWFBSSLicense extends BusinessServiceBreakdown {

    public static final String NAME = "Provide Trend Micro WFBSS License";
    public static final String ID = "provideTrendMicroWFBSSLicenseAntivirusDetectionPc";

    public ProvideTrendMicroWFBSSLicense() {
        setId(ID);
        setName(NAME);
        setDisplayOrder(0);
    }

}
