package com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils

import com.itextpdf.text.BaseColor
import com.itextpdf.text.Document
import com.itextpdf.text.Paragraph
import com.itextpdf.text.pdf.ColumnText
import com.itextpdf.text.pdf.PdfPCell
import com.itextpdf.text.pdf.PdfPRow
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.Quote
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.Selection
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service
import spock.lang.Specification

import javax.swing.text.Element

import static com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils.PdfFonts.getFont12
import static com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.utils.PdfFonts.getFont12Bold

class PdfTableBuilderSpec extends Specification {

    def 'withServices'() {
        setup:
        Map<String, Service> services = Mock()
        PdfTableBuilder pdfTableBuilder = new PdfTableBuilder(5)

        when:
        PdfTableBuilder response = pdfTableBuilder.withServices(services)

        then:
        response == pdfTableBuilder
        response.services == services
    }

    def 'withQuote'() {
        setup:
        Quote quote = Mock()
        PdfTableBuilder pdfTableBuilder = new PdfTableBuilder(5)

        when:
        PdfTableBuilder response = pdfTableBuilder.withQuote(quote)

        then:
        response == pdfTableBuilder
        response.quote == quote
    }

    def 'withDocument'() {
        setup:
        Document document = Mock()
        PdfTableBuilder pdfTableBuilder = new PdfTableBuilder(5)

        when:
        PdfTableBuilder response = pdfTableBuilder.withDocument(document)

        then:
        response == pdfTableBuilder
        response.document == document
    }

    def 'withHeaders'() {
        setup:
        PdfTableBuilder pdfTableBuilder = new PdfTableBuilder(5)

        when:
        PdfTableBuilder response = pdfTableBuilder.withHeaders('type')

        then:
        response == pdfTableBuilder
        PdfPRow row = response.table.getRow(0)
        PdfPCell[] cells = row.getCells()

        PdfPCell blankCell = cells[0]
        ColumnText blankColumnText = blankCell.getColumn()
        List<Element> blankCompositeElements = blankColumnText.getCompositeElements() as List<Element>

        !blankCompositeElements

        PdfPCell blankCell2 = cells[1]
        ColumnText blankCell2ColumnText = blankCell2.getColumn()
        List<Element> blankCell2CompositeElements = blankCell2ColumnText.getCompositeElements() as List<Element>

        !blankCell2CompositeElements

        PdfPCell quantityCell = cells[2]
        ColumnText quantityColumnText = quantityCell.getColumn()
        List<Element> quantityCompositeElements = quantityColumnText.getCompositeElements() as List<Element>

        Paragraph quantityParagraph = quantityCompositeElements[0] as Paragraph
        quantityParagraph.getFont() == getFont12Bold()
        quantityParagraph.getContent() == 'Quantity'

        PdfPCell itemCell = cells[3]
        ColumnText itemColumnText = itemCell.getColumn()
        List<Element> itemCompositeElements = itemColumnText.getCompositeElements() as List<Element>

        Paragraph itemParagraph = itemCompositeElements[0] as Paragraph
        itemParagraph.getFont() == getFont12Bold()
        itemParagraph.getContent() == 'type'

        PdfPCell subtotalCell = cells[4]
        ColumnText subtotalColumnText = subtotalCell.getColumn()
        List<Element> subtotalCompositeElements = subtotalColumnText.getCompositeElements() as List<Element>

        Paragraph subtotalParagraph = subtotalCompositeElements[0] as Paragraph
        subtotalParagraph.getFont() == getFont12Bold()
        subtotalParagraph.getContent() == 'Subtotal'
    }

    def 'withQuantityRowDefault'() {
        setup:
        Quote quote = Mock()
        Document document = Mock()
        Map<String, Service> services = Mock()
        Map<String, Selection> selections = Mock()
        PdfTableBuilder pdfTableBuilder = new PdfTableBuilder(5)
                .withDocument(document)
                .withQuote(quote)
                .withServices(services)

        when:
        PdfTableBuilder response = pdfTableBuilder.withQuantityRow('test')

        then:
        response == pdfTableBuilder
        1 * services.get('test') >> new Service(title: 'title', price: 2)
        1 * quote.getSelections() >> selections
        1 * selections.get('test') >> new Selection(quantity: 1)
        PdfPRow row = response.table.getRow(0)
        PdfPCell[] cells = row.getCells()

        PdfPCell titleCell = cells[0]
        titleCell.getColspan() == 2
        ColumnText titleColumnText = titleCell.getColumn()
        List<Element> titleCompositeElements = titleColumnText.getCompositeElements() as List<Element>

        Paragraph titleParagraph = titleCompositeElements[0] as Paragraph
        titleParagraph.getFont() == getFont12Bold()
        titleParagraph.getContent() == 'title'

        PdfPCell quantityCell = cells[2]
        ColumnText quantityColumnText = quantityCell.getColumn()
        List<Element> quantityCompositeElements = quantityColumnText.getCompositeElements() as List<Element>

        Paragraph quantityParagraph = quantityCompositeElements[0] as Paragraph
        quantityParagraph.getFont() == getFont12()
        quantityParagraph.getContent() == '1'

        PdfPCell itemCell = cells[3]
        ColumnText itemColumnText = itemCell.getColumn()
        List<Element> itemCompositeElements = itemColumnText.getCompositeElements() as List<Element>

        Paragraph itemParagraph = itemCompositeElements[0] as Paragraph
        itemParagraph.getFont() == getFont12()
        itemParagraph.getContent() == '$2.00'

        PdfPCell subtotalCell = cells[4]
        ColumnText subtotalColumnText = subtotalCell.getColumn()
        List<Element> subtotalCompositeElements = subtotalColumnText.getCompositeElements() as List<Element>

        Paragraph subtotalParagraph = subtotalCompositeElements[0] as Paragraph
        subtotalParagraph.getFont() == getFont12()
        subtotalParagraph.getContent() == '$2.00'
    }

    def 'withQuantitySubRow'() {
        setup:
        Quote quote = Mock()
        Document document = Mock()
        Map<String, Service> services = Mock()
        Map<String, Selection> selections = Mock()
        PdfTableBuilder pdfTableBuilder = new PdfTableBuilder(5)
                .withDocument(document)
                .withQuote(quote)
                .withServices(services)

        when:
        PdfTableBuilder response = pdfTableBuilder.withQuantitySubRow('test')

        then:
        response == pdfTableBuilder
        1 * services.get('test') >> new Service(title: 'title', price: 2)
        1 * quote.getSelections() >> selections
        1 * selections.get('test') >> new Selection(quantity: 1)
        PdfPRow row = response.table.getRow(0)
        PdfPCell[] cells = row.getCells()

        PdfPCell blankCell = cells[0]
        ColumnText blankColumnText = blankCell.getColumn()
        List<Element> blankCompositeElements = blankColumnText.getCompositeElements() as List<Element>

        !blankCompositeElements

        PdfPCell titleCell = cells[1]
        ColumnText titleColumnText = titleCell.getColumn()
        List<Element> titleCompositeElements = titleColumnText.getCompositeElements() as List<Element>

        Paragraph titleParagraph = titleCompositeElements[0] as Paragraph
        titleParagraph.getFont() == getFont12()
        titleParagraph.getContent() == 'title'

        PdfPCell quantityCell = cells[2]
        ColumnText quantityColumnText = quantityCell.getColumn()
        List<Element> quantityCompositeElements = quantityColumnText.getCompositeElements() as List<Element>

        Paragraph quantityParagraph = quantityCompositeElements[0] as Paragraph
        quantityParagraph.getFont() == getFont12()
        quantityParagraph.getContent() == '1'

        PdfPCell itemCell = cells[3]
        ColumnText itemColumnText = itemCell.getColumn()
        List<Element> itemCompositeElements = itemColumnText.getCompositeElements() as List<Element>

        Paragraph itemParagraph = itemCompositeElements[0] as Paragraph
        itemParagraph.getFont() == getFont12()
        itemParagraph.getContent() == '$2.00'

        PdfPCell subtotalCell = cells[4]
        ColumnText subtotalColumnText = subtotalCell.getColumn()
        List<Element> subtotalCompositeElements = subtotalColumnText.getCompositeElements() as List<Element>

        Paragraph subtotalParagraph = subtotalCompositeElements[0] as Paragraph
        subtotalParagraph.getFont() == getFont12()
        subtotalParagraph.getContent() == '$2.00'
    }

    def 'withQuantityRow'() {
        setup:
        Quote quote = Mock()
        Document document = Mock()
        Map<String, Service> services = Mock()
        Map<String, Selection> selections = Mock()
        PdfTableBuilder pdfTableBuilder = new PdfTableBuilder(4)
                .withDocument(document)
                .withQuote(quote)
                .withServices(services)

        when:
        PdfTableBuilder response = pdfTableBuilder.withQuantityRow(PdfTableBuilder.getWhiteCell(), 'test', getFont12())

        then:
        response == pdfTableBuilder
        1 * services.get('test') >> new Service(title: 'title', price: 2)
        1 * quote.getSelections() >> selections
        1 * selections.get('test') >> new Selection(quantity: 1)
        PdfPRow row = response.table.getRow(0)
        PdfPCell[] cells = row.getCells()

        PdfPCell titleCell = cells[0]
        ColumnText titleColumnText = titleCell.getColumn()
        List<Element> titleCompositeElements = titleColumnText.getCompositeElements() as List<Element>

        Paragraph titleParagraph = titleCompositeElements[0] as Paragraph
        titleParagraph.getFont() == getFont12()
        titleParagraph.getContent() == 'title'

        PdfPCell quantityCell = cells[1]
        ColumnText quantityColumnText = quantityCell.getColumn()
        List<Element> quantityCompositeElements = quantityColumnText.getCompositeElements() as List<Element>

        Paragraph quantityParagraph = quantityCompositeElements[0] as Paragraph
        quantityParagraph.getFont() == getFont12()
        quantityParagraph.getContent() == '1'

        PdfPCell itemCell = cells[2]
        ColumnText itemColumnText = itemCell.getColumn()
        List<Element> itemCompositeElements = itemColumnText.getCompositeElements() as List<Element>

        Paragraph itemParagraph = itemCompositeElements[0] as Paragraph
        itemParagraph.getFont() == getFont12()
        itemParagraph.getContent() == '$2.00'

        PdfPCell subtotalCell = cells[3]
        ColumnText subtotalColumnText = subtotalCell.getColumn()
        List<Element> subtotalCompositeElements = subtotalColumnText.getCompositeElements() as List<Element>

        Paragraph subtotalParagraph = subtotalCompositeElements[0] as Paragraph
        subtotalParagraph.getFont() == getFont12()
        subtotalParagraph.getContent() == '$2.00'
    }

    def 'withRow'() {
        setup:
        Map<String, Service> services = Mock()
        PdfTableBuilder pdfTableBuilder = new PdfTableBuilder(5)
                .withServices(services)

        when:
        PdfTableBuilder response = pdfTableBuilder.withRow('test')

        then:
        1 * services.get('test') >> new Service(title: 'title')
        PdfPRow row = response.table.getRow(0)
        PdfPCell[] cells = row.getCells()

        PdfPCell titleCell = cells[0]
        titleCell.getColspan() == 5
        ColumnText titleColumnText = titleCell.getColumn()
        List<Element> titleCompositeElements = titleColumnText.getCompositeElements() as List<Element>

        Paragraph titleParagraph = titleCompositeElements[0] as Paragraph
        titleParagraph.getFont() == getFont12Bold()
        titleParagraph.getContent() == 'title'
    }

    def 'withSubRow'() {
        setup:
        Map<String, Service> services = Mock()
        PdfTableBuilder pdfTableBuilder = new PdfTableBuilder(5)
                .withServices(services)

        when:
        PdfTableBuilder response = pdfTableBuilder.withSubRow('test')

        then:
        1 * services.get('test') >> new Service(title: 'title')
        PdfPRow row = response.table.getRow(0)
        PdfPCell[] cells = row.getCells()

        PdfPCell blankCell = cells[0]
        ColumnText blankColumnText = blankCell.getColumn()
        List<Element> blankCompositeElements = blankColumnText.getCompositeElements() as List<Element>

        !blankCompositeElements

        PdfPCell titleCell = cells[1]
        titleCell.getColspan() == 4
        ColumnText titleColumnText = titleCell.getColumn()
        List<Element> titleCompositeElements = titleColumnText.getCompositeElements() as List<Element>

        Paragraph titleParagraph = titleCompositeElements[0] as Paragraph
        titleParagraph.getFont() == getFont12()
        titleParagraph.getContent() == 'title'
    }

    def 'build'() {
        setup:
        Document document = Mock()
        PdfTableBuilder pdfTableBuilder = new PdfTableBuilder(5).withDocument(document)

        when:
        pdfTableBuilder.build()

        then:
        PdfPRow row = pdfTableBuilder.table.getRow(0)
        PdfPCell[] cells = row.getCells()

        PdfPCell blankCell = cells[0]
        blankCell.getColspan() == 3
        ColumnText blankColumnText = blankCell.getColumn()
        List<Element> blankCompositeElements = blankColumnText.getCompositeElements() as List<Element>

        !blankCompositeElements

        PdfPCell amountCell = cells[3]
        ColumnText amountColumnText = amountCell.getColumn()
        List<Element> amountCompositeElements = amountColumnText.getCompositeElements() as List<Element>

        Paragraph amountParagraph = amountCompositeElements[0] as Paragraph
        amountParagraph.getFont() == getFont12Bold()
        amountParagraph.getContent() == 'Amount'

        PdfPCell totalCell = cells[4]
        ColumnText totalColumnText = totalCell.getColumn()
        List<Element> totalCompositeElements = totalColumnText.getCompositeElements() as List<Element>

        Paragraph totalParagraph = totalCompositeElements[0] as Paragraph
        totalParagraph.getFont() == getFont12()
        totalParagraph.getContent() == '$0.00'
    }

    def 'getWhiteCell'() {
        when:
        PdfPCell pdfPCell = PdfTableBuilder.getWhiteCell()

        then:
        pdfPCell.borderColor == BaseColor.WHITE
    }

}
