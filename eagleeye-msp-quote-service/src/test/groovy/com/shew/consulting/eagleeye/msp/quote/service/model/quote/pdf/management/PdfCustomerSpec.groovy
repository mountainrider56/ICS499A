package com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management

import com.itextpdf.text.Document
import com.itextpdf.text.Paragraph
import com.itextpdf.text.pdf.ColumnText
import com.itextpdf.text.pdf.PdfPCell
import com.itextpdf.text.pdf.PdfPRow
import com.itextpdf.text.pdf.PdfPTable
import com.shew.consulting.eagleeye.msp.quote.service.model.external.Customer
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.Quote
import spock.lang.Specification

import javax.swing.text.Element
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

import static com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils.PdfFonts.getFont12
import static com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils.PdfFonts.getFont14Bold

class PdfCustomerSpec extends Specification {

    def 'pdfCustomer'() {
        setup:
        Document document = Mock()
        Customer customer = new Customer(0, 'customer', '1234567890', 'test@gmail.com', '1111 1st Ave.', 'apt. 2', 'St. Paul', 'MN', '55438', null)
        Quote quote = Mock()

        when:
        new PdfCustomer(document, customer, quote)

        then:
        2 * quote.getTimestamp() >> Instant.now()
        1 * document.add(_ as PdfPTable) >> { args ->
            def pdfPTable = args.get(0) as PdfPTable
            assert pdfPTable.getNumberOfColumns() == 2
            assert pdfPTable.getRows().size() == 1

            PdfPRow pdfPRow0 = pdfPTable.getRow(0)
            PdfPCell[] row0Cells = pdfPRow0.getCells()
            PdfPCell customerCell = row0Cells[0]
            ColumnText customerText = customerCell.getColumn()
            List<Element> customerElements = customerText.getCompositeElements() as List<Element>

            Paragraph paragraph00 = customerElements[0] as Paragraph
            assert paragraph00.getFont() == getFont14Bold()
            assert paragraph00.getContent() == 'Customer'

            Paragraph paragraph01 = customerElements[1] as Paragraph
            assert paragraph01.getFont() == getFont12()
            assert paragraph01.getContent() == customer.name

            Paragraph paragraph02 = customerElements[2] as Paragraph
            assert paragraph02.getFont() == getFont12()
            assert paragraph02.getContent() == customer.address1

            Paragraph paragraph03 = customerElements[3] as Paragraph
            assert paragraph03.getFont() == getFont12()
            assert paragraph03.getContent() == customer.address2

            Paragraph paragraph04 = customerElements[4] as Paragraph
            assert paragraph04.getFont() == getFont12()
            assert paragraph04.getContent() == "${customer.city}, ${customer.state} ${customer.zipcode}"

            Paragraph paragraph05 = customerElements[5] as Paragraph
            assert paragraph05.getFont() == getFont12()
            assert paragraph05.getContent() == customer.telephone

            Paragraph paragraph06 = customerElements[6] as Paragraph
            assert paragraph06.getFont() == getFont12()
            assert paragraph06.getContent() == customer.email

            PdfPCell timestampCell = row0Cells[1]
            ColumnText timestampText = timestampCell.getColumn()
            List<Element> timestampElements = timestampText.getCompositeElements() as List<Element>

            Paragraph paragraph10 = timestampElements[0] as Paragraph
            assert paragraph10.getFont() == getFont14Bold()
            assert paragraph10.getContent() == 'Date'

            Paragraph paragraph11 = timestampElements[1] as Paragraph
            assert paragraph11.getFont() == getFont12()
            assert paragraph11.getContent() == format(quote.getTimestamp())

            assert pdfPTable.getWidthPercentage() == 100
        }
    }

    def 'format'(Instant instant) {
        return DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
                .withLocale(Locale.US)
                .withZone(ZoneId.systemDefault())
                .format(instant)
    }

}
