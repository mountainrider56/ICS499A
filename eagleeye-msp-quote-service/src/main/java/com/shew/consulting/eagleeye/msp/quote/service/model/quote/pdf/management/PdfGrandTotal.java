package com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management;

import com.itextpdf.text.Document;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils.PdfTableBuilder;
import lombok.Getter;

import java.util.List;

/**
 * Grand Total PDF table.
 */
@Getter
public class PdfGrandTotal {

    private double total;

    public PdfGrandTotal(Document document, List<Double> totals, PdfTableBuilder builder) throws Exception {
        totals.forEach(i -> this.total += i);
        builder.withDocument(document)
               .withTotalRow("Grand total", total);
    }

}
