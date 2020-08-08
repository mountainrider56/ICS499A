package com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management.pc;

import com.itextpdf.text.Document;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils.PdfTableBuilder;
import lombok.Getter;

import java.util.List;

/**
 * PC Total PDF table.
 */
@Getter
public class PdfPcTotal {

    private double total;

    public PdfPcTotal(Document document, List<Double> totals, PdfTableBuilder builder) throws Exception {
        totals.forEach(i -> this.total += i);
        builder.withDocument(document)
               .withTotalRow("PC total", total);
    }

}
