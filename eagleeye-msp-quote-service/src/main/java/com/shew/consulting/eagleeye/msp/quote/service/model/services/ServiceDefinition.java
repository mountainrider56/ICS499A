package com.shew.consulting.eagleeye.msp.quote.service.model.services;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.ManagementType;

/**
 * Interface for each definition of a service.
 */
public interface ServiceDefinition {

    Service defineService();

    default String getId(ManagementType subType) {
        return getClass().getSimpleName() + subType;
    }

}
