package com.shrew.consulting.eagleeye.msp.quote.service.model.pc.management.patch.managment;

import com.shrew.consulting.eagleeye.msp.quote.service.model.Item;

import javax.persistence.Entity;

@Entity
public class OtherUpdates extends Item {

    public OtherUpdates() {
        setId("otherUpdates");
        setPrice(3);
    }

}
