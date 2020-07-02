package com.shrew.consulting.eagleeye.msp.quote.service.model.pc.management.patch.managment;

import com.shrew.consulting.eagleeye.msp.quote.service.model.Item;

import javax.persistence.Entity;

@Entity
public class OfficeUpdates extends Item {

    public OfficeUpdates() {
        setId("officeUpdates");
        setPrice(3);
    }

}
