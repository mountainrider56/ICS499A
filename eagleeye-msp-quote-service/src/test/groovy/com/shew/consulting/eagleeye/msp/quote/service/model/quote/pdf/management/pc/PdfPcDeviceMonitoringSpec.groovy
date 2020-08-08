package com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management.pc

import com.itextpdf.text.Document
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.Quote
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils.PdfTableBuilder
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

class PdfPcDeviceMonitoringSpec extends Specification {

    def 'build'() {
        setup:
        Quote quote = Mock()
        Document document = Mock()
        Map<String, Service> services = Mock()
        PdfTableBuilder builder = Mock()
        List<Double> totals = Mock()

        when:
        new PdfPcDeviceMonitoring(quote, document, services, builder, totals)

        then:
        1 * builder.withQuote(quote) >> builder
        1 * builder.withServices(services) >> builder
        1 * builder.withDocument(document) >> builder
        1 * builder.withHeaders('Workstation') >> builder
        1 * builder.withQuantityRow('DeviceMonitoringPC') >> builder
        1 * builder.withSubRow('DeviceMonitoringPerformancePC') >> builder
        1 * builder.withSubRow('DeviceMonitoringSystemLogsPC') >> builder
        1 * builder.withSubRow('DeviceMonitoringRemoteControlPC') >> builder
        1 * builder.build(totals) >> builder
        0 * _
    }

}
