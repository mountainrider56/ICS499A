package com.shew.consulting.eagleeye.msp.customer.service.model.projections;

/**
 * A project class to get a subset of the Customer class with only the id and name.
 */
public interface CustomerIdAndName {

    Long getId();

    String getName();

}
