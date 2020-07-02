package com.shrew.consulting.eagleeye.msp.quote.service.model.pc.management.basic.spam.service;

import com.shrew.consulting.eagleeye.msp.quote.service.model.Item;

import javax.persistence.Entity;

@Entity
public class BasicSpamService extends Item {

    public BasicSpamService() {
        setId("basicSpamService");
        setPrice(2.50);
    }

}
