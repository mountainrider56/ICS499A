package com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management.additional

import com.itextpdf.text.Document
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.Quote
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils.PdfTableBuilder
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class PdfAdditionalPeriodicPlanningSpec extends Specification {

    def 'build'() {
        setup:
        Quote quote = Mock()
        Document document = Mock()
        Map<String, Service> services = Mock()
        PdfTableBuilder builder = Mock()

        when:
        new PdfAdditionalPeriodicPlanning(quote, document, services, builder)

        then:
        1 * builder.withQuote(quote) >> builder
        1 * builder.withServices(services) >> builder
        1 * builder.withDocument(document) >> builder
        1 * builder.withHeaders("Workstation") >> builder
        1 * builder.withRow("PeriodicPlanningReviewADDITIONAL") >> builder
        1 * builder.withQuantitySubRow("PeriodicPlanningReviewMonthlyADDITIONAL") >> builder
        1 * builder.withQuantitySubRow("PeriodicPlanningReviewQuarterlyADDITIONAL") >> builder
        1 * builder.withQuantitySubRow("PeriodicPlanningReviewAnnuallyADDITIONAL") >> builder
        1 * builder.build()
    }

    /*
    builder.withQuote(quote)
               .withServices(services)
               .withDocument(document)
               .withHeaders("Workstation")
               .withRow("PeriodicPlanningReviewADDITIONAL")
               .withQuantitySubRow("PeriodicPlanningReviewMonthlyADDITIONAL")
               .withQuantitySubRow("PeriodicPlanningReviewQuarterlyADDITIONAL")
               .withQuantitySubRow("PeriodicPlanningReviewAnnuallyADDITIONAL")
               .build();
     */
}
