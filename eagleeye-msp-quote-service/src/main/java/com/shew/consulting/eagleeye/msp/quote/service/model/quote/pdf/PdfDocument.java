package com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.shew.consulting.eagleeye.msp.quote.service.model.external.Customer;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.Quote;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management.PdfCustomer;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management.PdfLogo;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management.pc.*;
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

        new PdfPcDeviceMonitoring(quote, document, services);
        newLine(document, 2);

        new PdfPcPatchManagement(quote, document, services);
        newLine(document, 2);

        new PdfPcHelpDesk(quote, document, services);
        newLine(document, 3);

        new PdfPcPeriodicSystemOptimization(quote, document, services);
        newLine(document, 2);

        new PdfPcBackupManagement(quote, document, services);
        newLine(document, 2);

        new PdfPcAntivirusDetection(quote, document, services);
        newLine(document, 2);

        new PdfPcAntiMalwareAntiSpywareDetection(quote, document, services);
        newLine(document, 2);

        new PdfPcBasicSpamService(quote, document, services);
        newLine(document, 2);

        // Server management
        document.add(new Paragraph("Server Management", getFont14Bold()));
        newLine(document, 1);

        document.close();
    }

}
