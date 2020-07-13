package com.shew.consulting.eagleeye.msp.quote.service.controllers;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.Quote;
import com.shew.consulting.eagleeye.msp.quote.service.repository.QuoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/quotes")
public class QuoteController {

    private final QuoteRepository quoteRepository;

    @GetMapping
    public List<Quote> getQuotes() {
        return quoteRepository.findAll();
    }

    @GetMapping("{quoteId}")
    public Quote getQuote(@PathVariable long quoteId) {
        Optional<Quote> quote = quoteRepository.findById(quoteId);
        if (quote.isPresent()) {
            return quote.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "quote not found: " + quoteId);
    }

//    @GetMapping(value = "{quoteId}/files/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
//    public ResponseEntity<InputStreamResource> getQuotePDF(@PathVariable long quoteId) throws FileNotFoundException, DocumentException {
//        System.out.println(quoteId);
//        Document document = new Document();
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        PdfWriter.getInstance(document, new FileOutputStream("iTextHelloWorld.pdf"));
//
//        document.open();
//        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
//        Chunk chunk = new Chunk("Hello World", font);
//
//        HttpHeaders headers = new HttpHeaders();
//        document.add(chunk);
//        document.close();
//        out.write(document);
//        return ResponseEntity
//                .ok()
//                .headers(headers)
//                .contentType(MediaType.APPLICATION_PDF)
//                .body(new InputStreamResource(document));
//    }

}
