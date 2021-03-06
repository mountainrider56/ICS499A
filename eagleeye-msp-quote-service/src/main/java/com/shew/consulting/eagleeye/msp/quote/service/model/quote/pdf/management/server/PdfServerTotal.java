package com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management.server;

import com.itextpdf.text.Document;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils.PdfTableBuilder;
import lombok.Getter;

import java.util.List;

/**
 * Server Total PDF table.
 */
@Getter
public class PdfServerTotal {

    private double total;

    public PdfServerTotal(Document document, List<Double> totals, PdfTableBuilder builder) throws Exception {
        totals.forEach(i -> this.total += i);
        builder.withDocument(document)
               .withTotalRow("Server total", total);
    }

}
