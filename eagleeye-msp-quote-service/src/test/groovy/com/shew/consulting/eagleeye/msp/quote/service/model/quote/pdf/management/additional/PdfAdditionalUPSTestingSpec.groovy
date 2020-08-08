package com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management.additional

import com.itextpdf.text.Document
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.Quote
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils.PdfTableBuilder
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class PdfAdditionalUPSTestingSpec extends Specification {

    def 'build'() {
        setup:
        Quote quote = Mock()
        Document document = Mock()
        Map<String, Service> services = Mock()
        PdfTableBuilder builder = Mock()
        List<Double> totals = Mock()

        when:
        new PdfAdditionalUPSTesting(quote, document, services, builder, totals)

        then:
        1 * builder.withQuote(quote) >> builder
        1 * builder.withServices(services) >> builder
        1 * builder.withDocument(document) >> builder
        1 * builder.withHeaders('Frequency') >> builder
        1 * builder.withRow('UPSTestingADDITIONAL') >> builder
        1 * builder.withQuantitySubRow('UPSTestingMonthlyADDITIONAL') >> builder
        1 * builder.withQuantitySubRow('UPSTestingQuarterlyADDITIONAL') >> builder
        1 * builder.withQuantitySubRow('UPSTestingAnnuallyADDITIONAL') >> builder
        1 * builder.build(totals) >> builder
        0 * _
    }

}
