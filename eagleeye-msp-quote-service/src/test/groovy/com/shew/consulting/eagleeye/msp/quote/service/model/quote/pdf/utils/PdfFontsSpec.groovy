package com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils

import com.itextpdf.text.BaseColor
import com.itextpdf.text.Font
import com.itextpdf.text.FontFactory
import spock.lang.Specification

class PdfFontsSpec extends Specification {

    def 'getFont14Bold'() {
        when:
        Font font = PdfFonts.getFont14Bold()

        then:
        font.getBaseFont().getPostscriptFontName() == FontFactory.HELVETICA_BOLD
        font.getSize() == 14
        font.getColor() == BaseColor.BLACK
    }

    def 'getFont12Bold'() {
        when:
        Font font = PdfFonts.getFont12Bold()

        then:
        font.getBaseFont().getPostscriptFontName() == FontFactory.HELVETICA_BOLD
        font.getSize() == 12
        font.getColor() == BaseColor.BLACK
    }

    def 'getFont12'() {
        when:
        Font font = PdfFonts.getFont12()

        then:
        font.getBaseFont().getPostscriptFontName() == FontFactory.HELVETICA
        font.getSize() == 12
        font.getColor() == BaseColor.BLACK
    }

}
