package com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management.server

import com.itextpdf.text.Document
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.Quote
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils.PdfTableBuilder
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class PdfServerAntiVirusAntiSpywareDetectionSpec extends Specification {

    def 'build'() {
        setup:
        Quote quote = Mock()
        Document document = Mock()
        Map<String, Service> services = Mock()
        PdfTableBuilder builder = Mock()

        when:
        new PdfServerAntiVirusAntiSpywareDetection(quote, document, services, builder)

        then:
        1 * builder.withQuote(quote) >> builder
        1 * builder.withServices(services) >> builder
        1 * builder.withDocument(document) >> builder
        1 * builder.withHeaders("Workstation") >> builder
        1 * builder.withQuantityRow("AntiVirusAntiSpywareDetectionSERVER") >> builder
        1 * builder.withSubRow("AntiVirusAntiSpywareDetectionProvideTrendMicroWFBSSLicenseSERVER") >> builder
        1 * builder.withSubRow("AntiVirusAntiSpywareDetectionDefinitionManagementSERVER") >> builder
        1 * builder.withSubRow("AntiVirusAntiSpywareDetectionApplicationUpdatesSERVER") >> builder
        1 * builder.withSubRow("AntiVirusAntiSpywareDetectionScheduledScanningSERVER") >> builder
        1 * builder.withSubRow("AntiVirusAntiSpywareDetectionHistoricReportsSERVER") >> builder
        1 * builder.build()
    }

}