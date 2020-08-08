package com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.shew.consulting.eagleeye.msp.quote.service.model.external.Customer;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.Quote;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management.PdfCustomer;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management.PdfGrandTotal;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management.PdfLogo;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management.additional.*;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management.pc.*;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management.server.*;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils.PdfTableBuilder;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
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
        List<Double> pcTotals = new ArrayList<>();
        List<Double> serverTotals = new ArrayList<>();
        List<Double> additionalTotals = new ArrayList<>();
        List<Double> grandTotals = new ArrayList<>();

        new PdfPcDeviceMonitoring(quote, document, services, tableBuilder5Cols(), pcTotals);
        newLine(document, 2);

        new PdfPcPatchManagement(quote, document, services, tableBuilder5Cols(), pcTotals);
        newLine(document, 2);

        new PdfPcHelpDesk(quote, document, services, tableBuilder5Cols(), pcTotals);
        newLine(document, 3);

        new PdfPcPeriodicSystemOptimization(quote, document, services, tableBuilder5Cols(), pcTotals);
        newLine(document, 2);

        new PdfPcBackupManagement(quote, document, services, tableBuilder5Cols(), pcTotals);
        newLine(document, 2);

        new PdfPcAntivirusDetection(quote, document, services, tableBuilder5Cols(), pcTotals);
        newLine(document, 2);

        new PdfPcAntiMalwareAntiSpywareDetection(quote, document, services, tableBuilder5Cols(), pcTotals);
        newLine(document, 10);

        new PdfPcBasicSpamService(quote, document, services, tableBuilder5Cols(), pcTotals);
        newLine(document, 2);

        grandTotals.add(new PdfPcTotal(document, pcTotals, tableBuilder5Cols()).getTotal());
        newLine(document, 4);

        // Server management
        document.add(new Paragraph("Server Management", getFont14Bold()));
        newLine(document, 1);

        new PdfServerDeviceMonitoring(quote, document, services, tableBuilder5Cols(), serverTotals);
        newLine(document, 2);

        new PdfServerPatchManagement(quote, document, services, tableBuilder5Cols(), serverTotals);
        newLine(document, 8);

        new PdfServerHelpDesk(quote, document, services, tableBuilder5Cols(), serverTotals);
        newLine(document, 2);

        new PdfServerPeriodicSystemOptimization(quote, document, services, tableBuilder5Cols(), serverTotals);
        newLine(document, 2);

        new PdfServerBackupManagement(quote, document, services, tableBuilder5Cols(), serverTotals);
        newLine(document, 2);

        new PdfServerAntiVirusAntiSpywareDetection(quote, document, services, tableBuilder5Cols(), serverTotals);
        newLine(document, 9);

        new PdfServerAdvancedSpamService(quote, document, services, tableBuilder5Cols(), serverTotals);
        newLine(document, 2);

        grandTotals.add(new PdfServerTotal(document, serverTotals, tableBuilder5Cols()).getTotal());
        newLine(document, 4);

        // Additional management
        document.add(new Paragraph("Additional Services", getFont14Bold()));
        newLine(document, 1);

        new PdfAdditionalDarkWebMonitoring(quote, document, services, tableBuilder5Cols(), additionalTotals);
        newLine(document, 2);

        new PdfAdditionalReporting(quote, document, services, tableBuilder5Cols(), additionalTotals);
        newLine(document, 2);

        new PdfAdditionalUPSTesting(quote, document, services, tableBuilder5Cols(), additionalTotals);
        newLine(document, 2);

        new PdfAdditionalNetworkDevices(quote, document, services, tableBuilder5Cols(), additionalTotals);
        newLine(document, 2);

        new PdfAdditionalAssetWarrantyManagement(quote, document, services, tableBuilder5Cols(), additionalTotals);
        newLine(document, 2);

        new PdfAdditionalPeriodicPlanning(quote, document, services, tableBuilder5Cols(), additionalTotals);
        newLine(document, 2);

        new PdfAdditionalHourlyRates(quote, document, services, tableBuilder5Cols(), additionalTotals);
        newLine(document, 2);

        grandTotals.add(new PdfAdditionalTotal(document, additionalTotals, tableBuilder5Cols()).getTotal());
        newLine(document, 4);

        // Grand total
        new PdfGrandTotal(document, grandTotals, tableBuilder5Cols());

        document.close();
    }

    private PdfTableBuilder tableBuilder5Cols() {
        return new PdfTableBuilder(5);
    }

}
