package com.shew.consulting.eagleeye.msp.quote.service.model.services;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;

public interface ServiceDefinition {

    Service defineService();

    default String getId(ManagementType subType) {
        return getClass().getSimpleName() + subType;
    }

}
