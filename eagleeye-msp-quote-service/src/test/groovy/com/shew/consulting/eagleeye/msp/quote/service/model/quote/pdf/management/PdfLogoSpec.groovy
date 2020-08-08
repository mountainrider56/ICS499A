package com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management

import com.itextpdf.text.Document
import com.itextpdf.text.Image
import spock.lang.Specification

import java.nio.file.Path
import java.nio.file.Paths

class PdfLogoSpec extends Specification {

    def 'pdfLogo'() {
        setup:
        Document document = Mock()
        Path path = Paths.get(ClassLoader.getSystemResource('pdf/images/logo.png').toURI())

        when:
        new PdfLogo(document)

        then:
        1 * document.add(_ as Image) >> { args ->
            def image = args.get(0) as Image
            assert image.height == 50
            assert image.width == 184
            assert image.getUrl().toString() == "file:${path.toAbsolutePath().toString()}"
        }
    }

}
