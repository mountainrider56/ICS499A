package com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils

import com.itextpdf.text.Chunk
import com.itextpdf.text.Document
import com.itextpdf.text.Paragraph
import spock.lang.Specification

class PdfFormatSpec extends Specification {

    def 'decimal'() {
        when:
        String decimal = PdfFormat.decimal(21)

        then:
        decimal == '$21.00'
    }

    def 'newLine'() {
        when:
        Paragraph paragraph = PdfFormat.newLine()

        then:
        paragraph == new Paragraph(Chunk.NEWLINE)
    }

    def 'newLineTimes'() {
        setup:
        Document document = Mock()

        when:
        PdfFormat.newLine(document, 5)

        then:
        5 * document.add(_ as Paragraph)
    }

}
