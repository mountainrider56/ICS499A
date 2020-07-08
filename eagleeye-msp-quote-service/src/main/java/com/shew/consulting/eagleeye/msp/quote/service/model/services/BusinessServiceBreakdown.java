package com.shew.consulting.eagleeye.msp.quote.service.model.services;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class BusinessServiceBreakdown extends Service {

}
