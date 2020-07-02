package com.shrew.consulting.eagleeye.msp.quote.service.model.pc.management.patch.managment;

import com.shrew.consulting.eagleeye.msp.quote.service.model.Item;

import javax.persistence.Entity;

@Entity
public class WindowsUpdates extends Item {

    public WindowsUpdates() {
        setId("windowsUpdates");
        setPrice(12);
    }

}
