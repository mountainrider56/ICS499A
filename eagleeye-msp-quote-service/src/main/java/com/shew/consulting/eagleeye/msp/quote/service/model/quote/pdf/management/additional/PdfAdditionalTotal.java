package com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management.additional;

import com.itextpdf.text.Document;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils.PdfTableBuilder;
import lombok.Getter;

import java.util.List;

/**
 * Additional Total PDF table.
 */
@Getter
public class PdfAdditionalTotal {

    private double total;

    public PdfAdditionalTotal(Document document, List<Double> totals, PdfTableBuilder builder) throws Exception {
        totals.forEach(i -> this.total += i);
        builder.withDocument(document)
               .withTotalRow("Additional total", total);
    }

}
