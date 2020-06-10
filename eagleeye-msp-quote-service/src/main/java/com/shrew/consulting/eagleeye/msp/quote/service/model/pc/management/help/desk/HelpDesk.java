package com.shrew.consulting.eagleeye.msp.quote.service.model.pc.management.help.desk;

import com.shrew.consulting.eagleeye.msp.quote.service.model.Item;

import javax.persistence.Entity;

@Entity
public class HelpDesk extends Item {

    public HelpDesk() {
        setId("helpDesk");
        setPrice(20);
    }

}
