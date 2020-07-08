package com.shew.consulting.eagleeye.msp.quote.service.model.quote;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class PCManagementQuote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Selection> selections;

}
