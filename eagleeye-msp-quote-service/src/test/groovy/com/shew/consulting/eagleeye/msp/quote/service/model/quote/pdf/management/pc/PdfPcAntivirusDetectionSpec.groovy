package com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management.pc

import com.itextpdf.text.Document
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.Quote
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils.PdfTableBuilder
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class PdfPcAntivirusDetectionSpec extends Specification {

    def 'build'() {
        setup:
        Quote quote = Mock()
        Document document = Mock()
        Map<String, Service> services = Mock()
        PdfTableBuilder builder = Mock()

        when:
        new PdfPcAntivirusDetection(quote, document, services, builder)

        then:
        1 * builder.withQuote(quote) >> builder
        1 * builder.withServices(services) >> builder
        1 * builder.withDocument(document) >> builder
        1 * builder.withHeaders("Workstation") >> builder
        1 * builder.withQuantityRow("AntivirusDetectionPC") >> builder
        1 * builder.withSubRow("AntivirusDetectionProvideTrendMicroWFBSSLicensePC") >> builder
        1 * builder.withSubRow("AntivirusDetectionDefinitionManagementPC") >> builder
        1 * builder.withSubRow("AntivirusDetectionScheduledScanningPC") >> builder
        1 * builder.withSubRow("AntivirusDetectionHistoricReportsPC") >> builder
        1 * builder.build()
    }

}
