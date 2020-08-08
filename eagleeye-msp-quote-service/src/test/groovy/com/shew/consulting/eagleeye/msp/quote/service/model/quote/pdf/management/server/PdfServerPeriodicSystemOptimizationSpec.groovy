package com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management.server

import com.itextpdf.text.Document
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.Quote
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils.PdfTableBuilder
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class PdfServerPeriodicSystemOptimizationSpec extends Specification {


    def 'build'() {
        setup:
        Quote quote = Mock()
        Document document = Mock()
        Map<String, Service> services = Mock()
        PdfTableBuilder builder = Mock()
        List<Double> totals = Mock()

        when:
        new PdfServerPeriodicSystemOptimization(quote, document, services, builder, totals)

        then:
        1 * builder.withQuote(quote) >> builder
        1 * builder.withServices(services) >> builder
        1 * builder.withDocument(document) >> builder
        1 * builder.withHeaders('Server') >> builder
        1 * builder.withQuantityRow('PeriodicSystemOptimizationSERVER') >> builder
        1 * builder.withSubRow('PeriodicSystemOptimizationDefragSERVER') >> builder
        1 * builder.withSubRow('PeriodicSystemOptimizationRemoveTemporaryFilesSERVER') >> builder
        1 * builder.build(totals) >> builder
        0 * _
    }

}
