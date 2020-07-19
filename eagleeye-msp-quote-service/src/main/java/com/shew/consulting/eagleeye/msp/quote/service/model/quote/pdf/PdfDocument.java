package com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.shew.consulting.eagleeye.msp.quote.service.model.external.Customer;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.Quote;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management.pc.PdfPcDeviceMonitoring;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management.pc.PdfPcPatchManagement;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Map;

import static com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils.PdfFonts.getFont12;
import static com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils.PdfFonts.getFont14Bold;
import static com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils.PdfFormat.newLine;
import static com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils.PdfTableBuilder.getWhiteCell;

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

        Path path = Paths.get(ClassLoader.getSystemResource("pdf/images/logo.png").toURI());
        Image img = Image.getInstance(path.toAbsolutePath().toString());
        img.scaleAbsolute(184, 50);
        document.add(img);

        // Header information
        PdfPTable headerTable = new PdfPTable(2);
        headerTable.setWidthPercentage(100);
        PdfPCell customerCell = getWhiteCell();
        customerCell.addElement(new Paragraph("Customer", getFont14Bold()));
        customerCell.addElement(new Paragraph(customer.getName(), getFont12()));
        customerCell.addElement(new Paragraph(customer.getAddress1(), getFont12()));
        if (!StringUtils.isEmpty(customer.getAddress2())) {
            customerCell.addElement(new Paragraph(customer.getAddress2(), getFont12()));
        }
        String location = customer.getCity() + ", " + customer.getState() + " " + customer.getZipcode();
        customerCell.addElement(new Paragraph(location, getFont12()));
        customerCell.addElement(new Paragraph(customer.getTelephone(), getFont12()));
        customerCell.addElement(new Paragraph(customer.getEmail(), getFont12()));

        headerTable.addCell(customerCell);
        PdfPCell dateCell = getWhiteCell();
        dateCell.addElement(new Paragraph("Start Date", getFont14Bold()));
        dateCell.addElement(new Paragraph(Instant.now().toString(), getFont12()));
        headerTable.addCell(dateCell);
        document.add(headerTable);

        document.add(newLine());
        document.add(newLine());

        document.add(new Paragraph("PC Management", getFont14Bold()));

        document.add(newLine());

        new PdfPcDeviceMonitoring(quote, document, services);

        document.add(newLine());
        document.add(newLine());

        new PdfPcPatchManagement(quote, document, services);

        document.close();
    }

}
