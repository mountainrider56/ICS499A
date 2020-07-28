package com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;

import java.text.DecimalFormat;

public class PdfFormat {

    private final static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#0.00");

    public static String decimal(double number) {
        return "$" + DECIMAL_FORMAT.format(number);
    }

    public static Paragraph newLine() {
        return new Paragraph(Chunk.NEWLINE);
    }

    public static void newLine(Document document, int times) throws Exception {
        for (int i = 1; i <= times; i++) {
            document.add(newLine());
        }
    }

}
