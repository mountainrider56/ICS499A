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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.time.Instant;
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

    @PutMapping
    public Quote saveQuote(@RequestBody Quote quote) {
        quote.setTotal(0);
        quote.getSelections().forEach((key, value) -> {
            double total = quote.getTotal();
            Service service = services.get(key);
            double serviceTotal = service.getPrice() * value.getQuantity();
            quote.setTotal(total + serviceTotal);
        });
        quote.setTimestamp(Instant.now());
        return quoteRepository.save(quote);
    }

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

    @GetMapping("customers/{customerId}")
    public Long getQuoteIdByCustomer(@PathVariable Long customerId) {
        Optional<Quote> quote = quoteRepository.findByCustomerId(customerId);
        if (quote.isPresent()) {
            return quote.get().getId();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "quote not found by customer: " + customerId);
    }

    @DeleteMapping("{quoteId}")
    public boolean deleteQuote(@PathVariable Long quoteId) {
        if (quoteRepository.existsById(quoteId)) {
            quoteRepository.deleteById(quoteId);
            return !quoteRepository.existsById(quoteId);
        } else {
            return false;
        }
    }

    @GetMapping(value = "{quoteId}/files/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> getQuotePDF(@PathVariable Long quoteId) throws DocumentException {
        Quote quote = getQuote(quoteId);

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
