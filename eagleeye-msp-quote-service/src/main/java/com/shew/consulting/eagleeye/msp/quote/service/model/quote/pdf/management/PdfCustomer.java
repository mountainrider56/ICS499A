package com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.shew.consulting.eagleeye.msp.quote.service.model.external.Customer;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.Quote;
import org.springframework.util.StringUtils;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import static com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils.PdfFonts.getFont12;
import static com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils.PdfFonts.getFont14Bold;
import static com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils.PdfTableBuilder.getWhiteCell;

public class PdfCustomer {

    private final Document document;
    private final Customer customer;
    private final Quote quote;

    public PdfCustomer(Document document, Customer customer, Quote quote) throws Exception {
        this.document = document;
        this.customer = customer;
        this.quote = quote;
        init();
    }

    private void init() throws Exception {
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
        dateCell.addElement(new Paragraph("Date", getFont14Bold()));
        String date = getDateTimeFormatter().format(quote.getTimestamp());
        dateCell.addElement(new Paragraph(date, getFont12()));
        headerTable.addCell(dateCell);
        document.add(headerTable);
    }

    private DateTimeFormatter getDateTimeFormatter() {
        return DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
                                .withLocale(Locale.US)
                                .withZone(ZoneId.systemDefault());
    }

}
