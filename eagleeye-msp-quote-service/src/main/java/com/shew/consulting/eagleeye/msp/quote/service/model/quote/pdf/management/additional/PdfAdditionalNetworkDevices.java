package com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management.additional;

import com.itextpdf.text.Document;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.Quote;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils.PdfTableBuilder;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import lombok.Getter;

import java.util.List;
import java.util.Map;

/**
 * Additional Network Devices PDF table.
 */
@Getter
public class PdfAdditionalNetworkDevices {

    private final Quote quote;
    private final Document document;
    private final Map<String, Service> services;
    private final PdfTableBuilder builder;
    private final List<Double> totals;

    public PdfAdditionalNetworkDevices(Quote quote, Document document, Map<String, Service> services,
                                       PdfTableBuilder builder, List<Double> totals) throws Exception {
        this.quote = quote;
        this.document = document;
        this.services = services;
        this.builder = builder;
        this.totals = totals;
        init();
    }

    private void init() throws Exception {
        builder.withQuote(quote)
               .withServices(services)
               .withDocument(document)
               .withHeaders("Device")
               .withRow("NetworkDeviceADDITIONAL")
               .withQuantitySubRow("NetworkDeviceEdgeDevicesADDITIONAL")
               .withQuantitySubRow("NetworkDeviceSNMPDevicesADDITIONAL")
               .build(totals);
    }

}
