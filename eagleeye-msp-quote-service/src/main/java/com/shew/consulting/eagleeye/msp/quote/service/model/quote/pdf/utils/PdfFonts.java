package com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;

/**
 * All available fonts for the PDF.
 */
public class PdfFonts {

    public static Font getFont14Bold() {
        return FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.BLACK);
    }

    public static Font getFont12Bold() {
        return FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.BLACK);
    }

    public static Font getFont12() {
        return FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);
    }

}
