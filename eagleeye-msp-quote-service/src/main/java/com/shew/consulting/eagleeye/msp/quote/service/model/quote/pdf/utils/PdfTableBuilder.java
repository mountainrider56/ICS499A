package com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.Quote;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.Selection;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;

import java.util.Map;

import static com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils.PdfFonts.getFont12;
import static com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils.PdfFonts.getFont12Bold;
import static com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils.PdfFormat.decimal;

public class PdfTableBuilder {

    private final PdfPTable table;

    private Quote quote;
    private Document document;
    private double total = 0.0;
    private Map<String, Service> services;

    public PdfTableBuilder(int columns) {
        this.table = new PdfPTable(columns);
        table.setWidthPercentage(100);
    }

    public PdfTableBuilder withServices(Map<String, Service> services) {
        this.services = services;
        return this;
    }

    public PdfTableBuilder withQuote(Quote quote) {
        this.quote = quote;
        return this;
    }

    public PdfTableBuilder withDocument(Document document) {
        this.document = document;
        return this;
    }

    public PdfTableBuilder withHeaders(String type) {
        PdfPCell blankCell = getWhiteCell();
        PdfPCell quantity = getWhiteCell();
        PdfPCell item = getWhiteCell();
        PdfPCell subtotal = getWhiteCell();

        quantity.addElement(new Paragraph("Quantity", getFont12Bold()));
        item.addElement(new Paragraph(type, getFont12Bold()));
        subtotal.addElement(new Paragraph("Subtotal", getFont12Bold()));

        table.addCell(blankCell);
        table.addCell(blankCell);
        table.addCell(quantity);
        table.addCell(item);
        table.addCell(subtotal);

        return this;
    }

    public PdfTableBuilder withQuantityRow(String key) {
        PdfPCell titleCell = getWhiteCell();
        titleCell.setColspan(2);
        withQuantityRow(titleCell, key, getFont12Bold());

        return this;
    }

    public PdfTableBuilder withQuantitySubRow(String key) {
        PdfPCell titleCell = getWhiteCell();
        table.addCell(getWhiteCell());
        withQuantityRow(titleCell, key, getFont12());

        return this;
    }

    public PdfTableBuilder withQuantityRow(PdfPCell titleCell, String key, Font font) {
        Service service = services.get(key);
        Selection selection = quote.getSelections().get(key);

        titleCell.addElement(new Paragraph(service.getTitle(), font));

        PdfPCell quantityCell = getWhiteCell();
        String quantity = Integer.toString(selection.getQuantity());
        Paragraph quantityParagraph = new Paragraph(quantity, getFont12());
        quantityCell.addElement(quantityParagraph);

        PdfPCell itemCell = getWhiteCell();
        itemCell.addElement(new Paragraph(decimal(service.getPrice()), getFont12()));

        PdfPCell subtotalCell = getWhiteCell();
        double subtotal = service.getPrice() * selection.getQuantity();
        total += subtotal;
        String decimal = decimal(subtotal);
        subtotalCell.addElement(new Paragraph(decimal, getFont12()));

        table.addCell(titleCell);
        table.addCell(quantityCell);
        table.addCell(itemCell);
        table.addCell(subtotalCell);

        return this;
    }

    public PdfTableBuilder withRow(String key) {
        withRow(key, 5, getFont12Bold());
        return this;
    }

    public PdfTableBuilder withSubRow(String key) {
        table.addCell(getWhiteCell());
        withRow(key, 4, getFont12());
        return this;
    }

    private void withRow(String key, int span, Font font) {
        Service service = services.get(key);

        PdfPCell titleCell = getWhiteCell();
        titleCell.setColspan(span);
        titleCell.addElement(new Paragraph(service.getTitle(), font));

        table.addCell(titleCell);
    }

    public void build() throws DocumentException {
        PdfPCell blankCell = getWhiteCell();
        blankCell.setColspan(3);

        PdfPCell amountCell = getWhiteCell();
        amountCell.addElement(new Paragraph("Amount", getFont12Bold()));

        PdfPCell amountTotal = getWhiteCell();
        amountTotal.addElement(new Paragraph(decimal(total), getFont12()));

        table.addCell(blankCell);
        table.addCell(amountCell);
        table.addCell(amountTotal);

        document.add(table);
    }

    public static PdfPCell getWhiteCell() {
        PdfPCell cell = new PdfPCell();
        cell.setBorderColor(BaseColor.WHITE);
        return cell;
    }

}
