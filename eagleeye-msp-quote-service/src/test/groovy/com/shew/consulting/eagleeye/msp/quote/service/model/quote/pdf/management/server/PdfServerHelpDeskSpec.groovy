package com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management.server

import com.itextpdf.text.Document
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.Quote
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils.PdfTableBuilder
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class PdfServerHelpDeskSpec extends Specification {

    def 'build'() {
        setup:
        Quote quote = Mock()
        Document document = Mock()
        Map<String, Service> services = Mock()
        PdfTableBuilder builder = Mock()

        when:
        new PdfServerHelpDesk(quote, document, services, builder)

        then:
        1 * builder.withQuote(quote) >> builder
        1 * builder.withServices(services) >> builder
        1 * builder.withDocument(document) >> builder
        1 * builder.withHeaders("Workstation") >> builder
        1 * builder.withQuantityRow("HelpDeskSERVER") >> builder
        1 * builder.withSubRow("HelpDeskTelephoneSupportSERVER") >> builder
        1 * builder.withSubRow("HelpDeskRemoteControlSERVER") >> builder
        1 * builder.build()
    }

}
