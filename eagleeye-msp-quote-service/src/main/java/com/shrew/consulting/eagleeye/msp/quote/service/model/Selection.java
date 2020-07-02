package com.shrew.consulting.eagleeye.msp.quote.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Selection {

    private long id;
    private Item item;
    private int quantity;

}
