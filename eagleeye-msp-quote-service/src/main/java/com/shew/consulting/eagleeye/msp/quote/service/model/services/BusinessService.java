package com.shew.consulting.eagleeye.msp.quote.service.model.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class BusinessService extends Service implements Comparable<BusinessService> {

    @OneToMany(cascade = CascadeType.ALL)
    private List<BusinessServiceBreakdown> breakdowns;

    @Override
    public int compareTo(BusinessService businessService) {
        return this.getDisplayOrder() - businessService.getDisplayOrder();
    }

}
