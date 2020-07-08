package com.shew.consulting.eagleeye.msp.quote.service.model.quote;

import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Selection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Service businessService;

    private int quantity;

}
