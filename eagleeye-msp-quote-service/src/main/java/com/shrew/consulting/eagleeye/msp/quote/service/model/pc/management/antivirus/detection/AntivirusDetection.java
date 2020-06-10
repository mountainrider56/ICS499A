package com.shrew.consulting.eagleeye.msp.quote.service.model.pc.management.antivirus.detection;

import com.shrew.consulting.eagleeye.msp.quote.service.model.Item;

import javax.persistence.Entity;

@Entity
public class AntivirusDetection extends Item {

    public AntivirusDetection() {
        setId("antivirusDetection");
        setPrice(3.25);
    }

}
