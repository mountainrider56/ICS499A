package com.shew.consulting.eagleeye.msp.quote.service.model.management.additional.asset.warranty.management;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.ServiceDefinition;
import org.springframework.stereotype.Component;

@Component
public class AssetWarrantyManagement implements ServiceDefinition {

    public static final String TITLE = "Asset/Warranty Management";

    @Override
    public Service defineService() {
        return new Service(getId(ManagementType.ADDITIONAL), TITLE, 0);
    }

}