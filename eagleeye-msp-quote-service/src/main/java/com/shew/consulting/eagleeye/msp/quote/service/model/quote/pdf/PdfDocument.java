package com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.shew.consulting.eagleeye.msp.quote.service.model.external.Customer;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.Quote;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management.PdfCustomer;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management.PdfLogo;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management.additional.*;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management.pc.*;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management.server.*;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils.PdfTableBuilder;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import lombok.Data;

import java.util.Map;

import static com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils.PdfFonts.getFont14Bold;
import static com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils.PdfFormat.newLine;

@Data
public class PdfDocument {

    private final Document document;
    private final Map<String, Service> services;

    public PdfDocument(Map<String, Service> services) {
        this.document = new Document();
        this.services = services;
    }

    public void writeToItextDocument(Quote quote, Customer customer) throws Exception {
        document.open();
        document.addCreationDate();

        new PdfLogo(document);
        new PdfCustomer(document, customer, quote);
        newLine(document, 2);

        // PC management
        document.add(new Paragraph("PC Management", getFont14Bold()));
        newLine(document, 1);

        new PdfPcDeviceMonitoring(quote, document, services, getPdfTableBuilderWith5Cols());
        newLine(document, 2);

        new PdfPcPatchManagement(quote, document, services, getPdfTableBuilderWith5Cols());
        newLine(document, 2);

        new PdfPcHelpDesk(quote, document, services, getPdfTableBuilderWith5Cols());
        newLine(document, 3);

        new PdfPcPeriodicSystemOptimization(quote, document, services, getPdfTableBuilderWith5Cols());
        newLine(document, 2);

        new PdfPcBackupManagement(quote, document, services, getPdfTableBuilderWith5Cols());
        newLine(document, 2);

        new PdfPcAntivirusDetection(quote, document, services, getPdfTableBuilderWith5Cols());
        newLine(document, 2);

        new PdfPcAntiMalwareAntiSpywareDetection(quote, document, services, getPdfTableBuilderWith5Cols());
        newLine(document, 2);

        new PdfPcBasicSpamService(quote, document, services, getPdfTableBuilderWith5Cols());
        newLine(document, 2);

        //FIXME

        // Server management
        document.add(new Paragraph("Server Management", getFont14Bold()));
        newLine(document, 1);

        new PdfServerDeviceMonitoring(quote, document, services, getPdfTableBuilderWith5Cols());
        newLine(document, 2);

        new PdfServerPatchManagement(quote, document, services, getPdfTableBuilderWith5Cols());
        newLine(document, 2);

        new PdfServerHelpDesk(quote, document, services, getPdfTableBuilderWith5Cols());
        newLine(document, 3);

        new PdfServerPeriodicSystemOptimization(quote, document, services, getPdfTableBuilderWith5Cols());
        newLine(document, 2);

        new PdfServerBackupManagement(quote, document, services, getPdfTableBuilderWith5Cols());
        newLine(document, 2);

        new PdfServerAntiVirusAntiSpywareDetection(quote, document, services, getPdfTableBuilderWith5Cols());
        newLine(document, 2);

        new PdfServerAdvancedSpamService(quote, document, services, getPdfTableBuilderWith5Cols());
        newLine(document, 2);

        //FIXME

        document.add(new Paragraph("Additional Services", getFont14Bold()));
        newLine(document, 1);

        new PdfAdditionalDarkWebMonitoring(quote, document, services, getPdfTableBuilderWith5Cols());
        newLine(document, 2);

        new PdfAdditionalReporting(quote, document, services, getPdfTableBuilderWith5Cols());
        newLine(document, 2);

        new PdfAdditionalUPSTesting(quote, document, services, getPdfTableBuilderWith5Cols());
        newLine(document, 2);

        new PdfAdditionalNetworkDevices(quote, document, services, getPdfTableBuilderWith5Cols());
        newLine(document, 2);

        new PdfAdditionalAssetWarrantyManagement(quote, document, services, getPdfTableBuilderWith5Cols());
        newLine(document, 2);

        new PdfAdditionalPeriodicPlanning(quote, document, services, getPdfTableBuilderWith5Cols());
        newLine(document, 2);

        new PdfAdditionalHourlyRates(quote, document, services, getPdfTableBuilderWith5Cols());
        newLine(document, 2);

        //FIXME

        //FIXME

        document.close();
    }

    private PdfTableBuilder getPdfTableBuilderWith5Cols() {
        return new PdfTableBuilder(5);
    }

}
