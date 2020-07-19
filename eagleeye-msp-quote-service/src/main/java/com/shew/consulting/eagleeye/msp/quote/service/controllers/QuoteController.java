package com.shew.consulting.eagleeye.msp.quote.service.controllers;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.shew.consulting.eagleeye.msp.quote.service.external.CustomerService;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.Quote;
import com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.PdfDocument;
import com.shew.consulting.eagleeye.msp.quote.service.model.services.Service;
import com.shew.consulting.eagleeye.msp.quote.service.repository.QuoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Expose endpoints for the quote service.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("v1/quotes")
public class QuoteController {

    private final QuoteRepository quoteRepository;
    private final CustomerService customerService;
    private final Map<String, Service> services;

    @GetMapping
    public List<Quote> getQuotes() {
        return quoteRepository.findAll();
    }

    @GetMapping("{quoteId}")
    public Quote getQuote(@PathVariable Long quoteId) {
        Optional<Quote> quote = quoteRepository.findById(quoteId);
        if (quote.isPresent()) {
            return quote.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "quote not found: " + quoteId);
    }

    @GetMapping(value = "{quoteId}/files/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> getQuotePDF(@PathVariable Long quoteId) throws DocumentException {

        Optional<Quote> optionalQuote = quoteRepository.findById(quoteId);
        if (!optionalQuote.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "quote not found: " + quoteId);
        }
        Quote quote = optionalQuote.get();

        PdfDocument pdfDocument = new PdfDocument(services);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter.getInstance(pdfDocument.getDocument(), out);

        try {
            pdfDocument.writeToItextDocument(quote, customerService.getCustomer(quote.getCustomerId()));
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to generate quote: " + quoteId);
        }

        return ResponseEntity
                .ok()
                .headers(new HttpHeaders())
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(new ByteArrayInputStream(out.toByteArray())));
    }

}
