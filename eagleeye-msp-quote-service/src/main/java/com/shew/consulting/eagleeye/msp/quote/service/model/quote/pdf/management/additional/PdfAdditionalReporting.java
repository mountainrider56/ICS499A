package com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management.additional;

import com.itextpdf.text.Document;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.Quote;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils.PdfTableBuilder;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;

import java.util.Map;

/**
 * Additional Reporting PDF table.
 */
public class PdfAdditionalReporting {

    private final Quote quote;
    private final Document document;
    private final Map<String, Service> services;
    private final PdfTableBuilder builder;

    public PdfAdditionalReporting(Quote quote, Document document, Map<String, Service> services,
                                  PdfTableBuilder builder) throws Exception {
        this.quote = quote;
        this.document = document;
        this.services = services;
        this.builder = builder;
        init();
    }

    private void init() throws Exception {
        builder.withQuote(quote)
               .withServices(services)
               .withDocument(document)
               .withHeaders("Workstation")
               .withRow("ReportingADDITIONAL")
               .withQuantitySubRow("ReportingMonthlyADDITIONAL")
               .withQuantitySubRow("ReportingQuarterlyADDITIONAL")
               .withQuantitySubRow("ReportingAnnuallyADDITIONAL")
               .build();
    }

}
